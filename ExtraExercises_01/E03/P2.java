import static java.lang.System.*;

public class P2
{
   public static void main(String[] args)
   {
      for(String expr : args) out.print(expr + " -> " + invertDigits(expr, "", 0) + "\n");
   }
  public static String invertDigits(String word, String temp_digits, int index){
	String to_return = "";
	if(index < word.length()){
      if(Character.isDigit(word.charAt(index))) to_return += invertDigits(word, word.charAt(index) + temp_digits, index+1);
	  else to_return += temp_digits + word.charAt(index) + invertDigits(word, "", index+1);
	}
	else if(index == word.length()) to_return += temp_digits;
	return to_return;
  }
}

