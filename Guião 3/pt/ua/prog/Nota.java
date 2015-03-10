package pt.ua.prog;

public class Nota {
	private Data begin, end;
	private String text;
	
	public Data begin(){
		return begin;
	}
	public Data end(){
		return end;
	}
	public Nota(Data begin, Data end, String text){
		this.begin = begin;
		this.end = end;
		this.text = text;
	}
	public void writeNote(){
		System.out.printf("%s", text);
	}
	
	
	public void printNote(){
		begin.printDate();
		System.out.print(" <-> ");
		end.printDate();
		System.out.print(": ");
		writeNote();
		System.out.print("\n");
	}
}
