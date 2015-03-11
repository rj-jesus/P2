package pt.ua.prog;

public class Contacto {
	public static int count = 0;
	
	private String name = new String();
	private String num = new String();
	private String email = new String();
	
	public Contacto(String a){
		if(a.equals("")){
			System.err.print("Contacto inválido!");
			System.exit(1);
		}
		name = a;
		count++;
	}
	public Contacto(String a, String n){
		if(a.equals("")){
			System.err.print("Contacto inválido!");
			System.exit(1);
		}
		name = a;
		num = n;
		count++;
	}
	public Contacto(String a, String n, String b){
		if(a.equals("")){
			System.err.print("Contacto inválido!");
			System.exit(1);
		}
		name = a;
		num = n;
		email = b;
		count++;
	}
	public String nome(){
		return name;
	}
	public String telefone(){
		return num;
	}
	public String eMail(){
		return email;
	}
}

