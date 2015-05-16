import static java.lang.System.*;

public class P3 {

   public static void main(String[] args) {
	   if(args.length % 2 != 0){
		   System.err.print("Error: Expecting arguments as args1, pre1, args2, pre2, ..., argsN, preN\n");
		   System.exit(1);
	   }
	   for(int i = 0; i < args.length; i += 2){
		   System.out.print("\"" + args[i] + "\"" + " is prefixed by " + "\"" + args[i + 1] + "\" -> " + isPrefix(args[i], args[i + 1]) + "\n");
	   }
   }
	public static boolean isPrefix(String origin, String pref){
		boolean is_prefixed = true;
		if(pref.length() > 0){
			if(origin.length() < pref.length()) is_prefixed = false;
			else if(origin.length() == pref.length()) is_prefixed = origin.equals(pref);
			else{
				if(origin.charAt(0) == pref.charAt(0)) is_prefixed = isPrefix(origin.substring(1), pref.substring(1));
				else is_prefixed = false;
			}
		}
		return is_prefixed;
	}
}

