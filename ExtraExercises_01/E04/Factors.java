import static java.lang.System.*;

public class Factors
{
   public static void main(String[] args)
   {
      for(int i = 0; i < args.length; i++)
         out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
   }
  public static String factors(int n){
	assert n >= 0: "Error: Value should be a nonnegative integer.";
    String to_return = "";
    if(n == 0) to_return = "0";
    else if(n == 1) to_return = "1";
    else if(isPrime(n)) to_return += n;
    else for(int i = (int) Math.sqrt(n); i > 1; i--) if(isPrime(i) && n % i == 0) to_return = i + " * " + factors(n / i);
    return to_return;
  }
  public static boolean isPrime(int n){
    assert n >= 1: "Error: Value should be positive.";
    if(n == 1) return false;
    for(int i = (int) Math.sqrt(n); i > 1; i--) if(n % i == 0) return false;
    return true;
  }
}

