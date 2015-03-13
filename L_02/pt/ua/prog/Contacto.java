package pt.ua.prog;

public class Contacto {
	private static int count = 0;
	
	private String name;
	private String num;
	private String email;
	
	public Contacto(String name, String num){
		if(name.equals("")){
			System.err.print("Error: Invalid name!\n");
			System.exit(1);
		}
		this.name = name;
		this.num = num;
		count++;
	}
	public Contacto(String name, String num, String email){
		if(name.equals("")){
			System.err.print("Error: Invalid name!\n");
			System.exit(1);
		}
		this.name = name;
		this.num = num;
		this.email = email;
		count++;
	}
	public String nome(){
		return name;
	}
	public int telefone(){
		return Integer.parseInt(num);
	}
	public String eMail(){
		if(email == null) return "";
		return email;
	}
	public int count(){
		return count;
	}
}

