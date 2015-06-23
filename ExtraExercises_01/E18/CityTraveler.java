import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class CityTraveler{
    public static void main(String[] args){
        AssociativeArray<Queue<String>> arr = new AssociativeArray<Queue<String>>();
        int longestWord = -1;
        for(String arg : args) longestWord = Math.max(longestWord, parseCityFile(arr, arg));
        String[] allArrayKeys = arr.keysToArray();
        for(String key : allArrayKeys){
            Queue<String> keyEntry = arr.get(key);
            /* With right-align
            out.print(String.format("%1$" + longestWord + "s", key) + " : ");
            */
            out.print(key + String.valueOf(new char[longestWord-key.length()]).replace("\0", " ") + " : ");
            int sizeCities = keyEntry.size();
            while(sizeCities > 0){
                out.print(keyEntry.peek() + " ");
                keyEntry.in(keyEntry.peek());
                keyEntry.out();
                sizeCities--;
            }
            out.print("\n");
        }
    }
    
    public static int parseCityFile(AssociativeArray<Queue<String>> arr, String fname){
        int longestWord = -1;
        try{
            Scanner fsc = new Scanner(new File(fname));
            while(fsc.hasNextLine()){
                String user = fsc.nextLine().trim();
                longestWord = Math.max(longestWord, user.length());
                if(!arr.exists(user)) arr.set(user, new Queue<String>());
                arr.get(user).in(fname);
            }
        }
        catch(FileNotFoundException e){
            err.print("Couldn't find file to parse. Aborting.");
            exit(1);
        }
        return longestWord;
    }
}
