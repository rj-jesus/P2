import static java.lang.System.*;
import linkedlist.Array;

public class p102
{
   public static void main(String[] args)
   {
      if (args.length == 0)
      {
         err.println("Usage: p102 <DIM> <oper> ...");
         exit(1);
      }

      int dim = Integer.parseInt(args[0]); // ignoring conversion errors

      Array<Double> array = new Array<Double>(dim);

      for(int i = 1; i < args.length; i++)
      {
         if (args[i].equals("set")) // operation: set idx value
         {
            if (i+2 >= args.length)
            {
               err.println("Error: missing argument to set");
               exit(2);
            }
            i++;
            int idx = Integer.parseInt(args[i]);
            if (idx < 0 || idx >= array.length())
            {
               err.println("Error: invalid index "+idx);
               exit(2);
            }
            i++;
            double val = Integer.parseInt(args[i]);
            array.set(val, idx);
         }
         else if (args[i].equals("get")) // operation: get idx
         {
            if (i+1 >= args.length)
            {
               err.println("Error: missing argument to get");
               exit(3);
            }
            i++;
            int idx = Integer.parseInt(args[i]);
            if (idx < 0 || idx >= array.length())
            {
               err.println("Error: invalid index "+idx);
               exit(2);
            }
            if (!array.defined(idx))
               out.println("ERROR: element at "+idx+"+ not defined!");
            else
               out.printf("get(%d)=%1.1f\n", idx, array.get(idx));
         }
         else if (args[i].equals("print")) // operation: print
         {
            for(int idx = 0; idx < array.length(); idx++)
               if (array.defined(idx))
                  out.printf(" %1.1f",array.get(idx));
               else
                  out.printf(" (undef)");
            out.println();
         }
         else if (args[i].equals("max")) // operation: max
         {
            boolean exists = false;
            double max = 0;
            for(int idx = 0; idx < array.length(); idx++)
               if (array.defined(idx))
               {
                  double d  = array.get(idx);
                  if (!exists)
                  {
                     exists = true;
                     max = d;
                  }
                  else if (d > max)
                     max = d;
               }
            if (!exists)
               out.println("ERROR: A maximum value does not exists in an empty array!");
            else
               out.println("max="+max);
         }
      }
   }
}

