import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class PhoneCalls{
    public static void main(String[] args){
        AssociativeArray<NumberData> arr = new AssociativeArray<NumberData>();
        for(String arg : args){
            String action = arg.length() >= 3 ? arg.substring(arg.length()-3) : "";
            switch(action){
                case "cls":
                    printCLS(arr, arg);
                    break;
                case "nms":
                    parseNMS(arr, arg);
                    break;
                default:
                    out.print("\n");
                    if(!arr.exists(arg)) err.print("Number " + arg + " not found. Skipped.\n");
                    else{
                        NumberData number = arr.get(arg);
                        out.print("Calls made by " + (number.name == null ? arg : number.name) + ":\n");
                        int sizeMade = number.callsMade.size();
                        if(sizeMade == 0) out.print("  - None\n");
                        while(sizeMade > 0){
                            CallData callMade = number.callsMade.peek();
                            out.print("  - to phone " + (arr.get(callMade.number).name == null ? callMade.number : arr.get(callMade.number).name) + " (" + callMade.duration + " seconds)\n");
                            number.callsMade.out();
                            number.callsMade.in(callMade);
                            sizeMade--;
                        }
                        out.print("Calls received by " + (number.name == null ? arg : number.name) + ":\n");
                        int sizeReceived = number.callsReceived.size();
                        if(sizeReceived == 0) out.print("  - None\n");
                        while(sizeReceived > 0){
                            CallData callReceived = number.callsReceived.peek();
                            out.print("  - from phone " + (arr.get(callReceived.number).name == null ? callReceived.number : arr.get(callReceived.number).name) + " (" + callReceived.duration + " seconds)\n");
                            number.callsReceived.out();
                            number.callsReceived.in(callReceived);
                            sizeReceived--;
                        }
                    }
                    break;
            }
        }
    }
    public static void printCLS(AssociativeArray<NumberData> arr, String fname){
        try{
            Scanner fsc = new Scanner(new File(fname));
            while(fsc.hasNextLine()){
                String[] lines = fsc.nextLine().split(" ");
                if(!arr.exists(lines[0])) arr.set(lines[0], new NumberData());
                arr.get(lines[0]).callsMade.in(new CallData(lines[1], Integer.parseInt(lines[2])));
                if(!arr.exists(lines[1])) arr.set(lines[1], new NumberData());
                arr.get(lines[1]).callsReceived.in(new CallData(lines[0], Integer.parseInt(lines[2])));
                String from = arr.get(lines[0]).name == null ? lines[0] : arr.get(lines[0]).name;
                String to = arr.get(lines[1]).name == null ? lines[1] : arr.get(lines[1]).name;
                out.printf("%s to %s (%d seconds)\n", from, to, Integer.parseInt(lines[2]));
            }
        }
        catch(FileNotFoundException e){
            err.print("Couldn't find \"" + fname + "\". Aborting.\n");
            exit(1);
        }
    }
    public static void parseNMS(AssociativeArray<NumberData> arr, String fname){
        try{
            Scanner fsc = new Scanner(new File(fname));
            while(fsc.hasNextLine()){
                String[] lines = fsc.nextLine().split(" ", 2);
                if(!arr.exists(lines[0])) arr.set(lines[0], new NumberData());
                arr.get(lines[0]).name = lines[1];
            }
            fsc.close();
        }
        catch(FileNotFoundException e){
            err.print("Couldn't find \"" + fname + "\". Aborting.\n");
            exit(1);
        }
    }
}

class NumberData{
    Queue<CallData> callsMade = new Queue<CallData>(), callsReceived = new Queue<CallData>();
    String name;
}

class CallData{
    String number;
    int duration;
    public CallData(String number, int duration){
        this.number = number;
        this.duration = duration;
    }
}
