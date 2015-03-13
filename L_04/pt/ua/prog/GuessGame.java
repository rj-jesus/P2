package pt.ua.prog;

public class GuessGame {
	private int min, max, attempt, counter = 0;
	public int secretNumber;
	
	public GuessGame(int min, int max){
		assert max - min > 1;
		this.min = min;
		this.max = max;
		secretNumber = min + (int)(Math.random()*(max - min));
		if(min == secretNumber) attempt = max;
		else attempt = min;
	}
	public int min(){
		return min;
	}
	public int max(){
		return max;
	}
	public boolean validAttempt(int x){
		if(x < min || x > max) return false;
		return true;
	}
	public boolean finished(){
		if(attempt == secretNumber) return true;
		return false;
	}
	public void play(int x){
		if(!finished() && validAttempt(x)){
			attempt = x;
			counter++;
		}
	}
	public boolean attemptIsHigher(){
		if(attempt > secretNumber) return true;
		return false;
	}
	public boolean attemptIsLower(){
		if(attempt < secretNumber) return true;
		return false;
	}
	public int numAttempts(){
		return counter;
	}
}
