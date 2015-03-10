package pt.ua.prog;

public class Caixa {
	private long[] moedas = new long[15];
	
	public long total(){
		return sum(moedas);
	}
	private long sum(long[] a){
		long sum = 0;
		for(int i = 0; i < a.length; i++) sum += a[i] * valueAt(i);
		return sum;
	}
	public void print(){
		for(int i = 0; i < moedas.length; i++){
			if(moedas[i] != 0) System.out.printf("%d moeda(s)/nota(s) de %.2f euros.\n", moedas[i], (double)valueAt(i) / 100);
		}
	}
	public void print(long[] a){
		for(int i = 0; i < a.length; i++){
			if(a[i] != 0) System.out.printf("%d moeda(s)/nota(s) de %.2f euros.\n", a[i], (double)valueAt(i) / 100);
		}
	}
	public long[] takeMoney(long amount){
		assert amount <= total();
		long[] a = new long[15];
		for(int i = moedas.length - 1; i >= 0; i--){
			if(amount % valueAt(i) == 0 && moedas[i] != 0){
				a[i] = amount / valueAt(i);
				moedas[i] -= amount / valueAt(i);
				amount -= a[i] * valueAt(i);
			}
		}
		
		assert sum(a) == amount;
		
		return a;
	}
	public void addCoins(long money){
		assert money >= 0;
		for(int i = moedas.length - 1; i >= 0; i--){
			if(money % valueAt(i) == 0){
				moedas[i] += money / valueAt(i);
				break;
			}
		}
	}
	private long valueAt(int i){
		switch(i){
			case 0: return 1;
			case 1: return 2;
			case 2: return 5;
			case 3: return 10;
			case 4: return 20;
			case 5: return 50;
			case 6: return 100;
			case 7: return 200;
			case 8: return 500;
			case 9: return 1000;
			case 10: return 2000;
			case 11: return 5000;
			case 12: return 10000;
			case 13: return 20000;
			case 14: return 50000;
		}
		return -1;
	}
}
