import static java.lang.System.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import exameP2.Queue;

public class JustifiedText{
	public static void main(String[] args){
		int max_length = -1;
		Queue<String> text = new Queue<String>();
		try{
			if(args.length != 2){
				err.print("Error: Usage: java JustifiedText <length> <file_name>.\n");
				exit(1);
			}
			max_length = Integer.parseInt(args[0]);
			Scanner scf = new Scanner(new File(args[1]));
			while(scf.hasNextLine()){
				String line = scf.nextLine();
				for(String word : line.split(" ")) if(!word.equals("")) text.in(word);
				if(line.equals("")){
					out.print(justify(text, max_length));
					out.print("\n");
					text.clear();
				}
			}
			out.print(justify(text, max_length));
		}
		catch(NumberFormatException e){
			err.print("Error: Couldn't parse line's length. Aborting.\n");
			exit(2);
		}
		catch(FileNotFoundException e){
			err.print("Error: Couldn't find file to justify. Aborting.\n");
			exit(3);
		}
		finally{
			if(max_length < 1) throw new AssertionError("Error: Invalid length. Aborting.\n");
		}
	}
	public static String justify(Queue<String> text, int max_length){
		String result = new String(), line = new String(), word;
		while(!text.isEmpty()){
			word = text.peek();
			if(line.length() + word.length() <= max_length){
				line += " " + word;
				text.out();
				if(text.isEmpty()) result += line.substring(1) + "\n";
			}
			else{
				if(line.length() == 0) throw new AssertionError("Error: Wasn't expecting an empty string. Program can't continue.");
				line = line.substring(1);
				int spaces_missing = max_length - line.length();
				String[] line_words = line.split(" ");
				int spaces_gaps = line_words.length - 1;
				line = line_words[0];
				for(int i = 1; i < line_words.length; i++){
					int spaces_to_add = (int) Math.round((double) spaces_missing / spaces_gaps);
					line += new String(new char[spaces_to_add + 1]).replace("\0", " ") + line_words[i];
					spaces_missing -= spaces_to_add;
					spaces_gaps--;
				}
				result += line + "\n";
				line = new String();
			}
		}
		return result;
	}
}

