import java.util.Scanner;
import pt.ua.prog.*;

public class ex0204 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		Contacto[] list = null;
		String tmp1 = "";
		for(; ; ){
			System.out.print("Nome: ");
			tmp1 = sc.nextLine();
			if(tmp1.equals("finish")) break;
			System.out.print("Telemóvel: ");
			String tmp2 = sc.nextLine();
			System.out.print("Email: ");
			String tmp3 = sc.nextLine();
			list = expandList(list);
			list[list.length-1] = new Contacto(tmp1, tmp2, tmp3);
		}
		System.out.print("Listagem:\n");
		for(int i = 0; i < list.length; i++){
			System.out.printf("%s: %s; %s\n", list[i].nome(), list[i].telefone(), list[i].eMail());
		}
		if(list != null) System.out.printf("Contactos: %d\n", list[0].count);
	}
	public static Contacto[] expandList(Contacto[] a){
		Contacto[] b = null;
		if(a == null){
			b = new Contacto[1];
		}
		else{
			b = new Contacto[a.length + 1];
			for(int i = 0; i < a.length; i++){
				b[i] = a[i];
			}
		}
		return b;
	}
}

