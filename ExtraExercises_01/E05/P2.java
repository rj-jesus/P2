import static java.lang.System.*;

public class P2
{
   public static void main(String[] args)
   {
	 for(String word : args) out.printf("\"" + word + "\"" + " contains %d pair(s) of consecutive equal characters.\n", countPairs(word));
   }
   public static int countPairs(String word){
	 int pair_count = 0;
	 if(word.length() > 1) pair_count = word.charAt(0) == word.charAt(1) ? 1 + countPairs(word.substring(1)) : countPairs(word.substring(1));
     return pair_count;
   }
}

