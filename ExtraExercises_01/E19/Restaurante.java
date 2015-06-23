import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class Restaurante{
   public static void main(String[] args){
       AssociativeArray<Integer> arr = new AssociativeArray<Integer>();
       Queue<String> pending = new Queue<String>();
       for(String arg : args) parseFile(arr, pending, arg);
       String[] allKeys = arr.keysToArray();
       out.print("Comida em stock:\n");
       for(String key : allKeys) if(arr.get(key) > 0) out.print("  " + key + ": " + arr.get(key) + "\n");
       while(!pending.isEmpty()){
           out.print("Refeição pendente: " + pending.peek() + "\n");
           pending.out();
       }
   }
   public static void parseFile(AssociativeArray<Integer> arr, Queue<String> pending, String fname){
       try{
           Scanner fsc = new Scanner(new File(fname));
           while(fsc.hasNextLine()){
               String line = fsc.nextLine();
               if(line.indexOf("entrada:") != -1){
                   line = line.substring(9);
                   if(!arr.exists(line)) arr.set(line, 0);
                   arr.set(line, arr.get(line) + 1);
                   while(tryToDeliverPending(arr, pending));
               }
               else if(line.indexOf("saida:") != -1){
                   boolean serving = pending.isEmpty();
                   line = line.substring(7);
                   String[] ingredients = line.split(" ");
                   String checkRepetitions = "";
                   for(String materials : ingredients){
                       String[] ingredient = materials.split(":");
                       if(checkRepetitions.indexOf(ingredient[0]) != -1){
                           err.print("Repeated ingredient: \"" + ingredient[0] + "\". Aborting.\n");
                           exit(2);
                       }
                       checkRepetitions += ingredient[0] + "|";
                       if(!serving || !arr.exists(ingredient[0]) || arr.get(ingredient[0]) - Integer.parseInt(ingredient[1]) < 0){
                           pending.in(line);
                           serving = false;
                           break;
                       }
                   }
                   if(serving){
                       for(String materials : ingredients){
                           String[] ingredient = materials.split(":");
                           arr.set(ingredient[0], arr.get(ingredient[0]) - Integer.parseInt(ingredient[1]));
                       }
                       out.print("Refeição servida: " + line + "\n");
                   }
               }
               else err.print("Couldn't understand: \"" + line + "\". Skipped.\n");
           }
       }
       catch(FileNotFoundException e){
           err.print("Couldn't find \"" + fname + "\". Aborting.\n");
           exit(1);
       }
   }
   public static boolean tryToDeliverPending(AssociativeArray<Integer> arr, Queue<String> pending){
       boolean success = !pending.isEmpty();
       if(success){
           String checkRepetitions = "";
           for(String ingredient : pending.peek().split(" ")){
               String[] info = ingredient.split(":");
               if(checkRepetitions.indexOf(info[0]) != -1){
                   err.print("Repeated ingredient: \"" + info[0] + "\". Aborting.\n");
                   exit(2);
               }
               checkRepetitions += info[0] + "|";
               if(!arr.exists(info[0]) || arr.get(info[0]) - Integer.parseInt(info[1]) < 0) success = false;
           }
       }
       if(success){
           for(String ingredient : pending.peek().split(" ")){
               String[] info = ingredient.split(":");
               arr.set(info[0], arr.get(info[0]) - Integer.parseInt(info[1]));
           }
           out.print("Refeição servida: " + pending.peek() + "\n");
           pending.out();
       }
       return success;
   }
}
