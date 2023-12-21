import java.util.*;
import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text or provide a file path:");

        String input = scanner.nextLine();

        String text = "";
        try {
        
            File file = new File(input);
            if (file.exists() && file.isFile()) {
             
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + "\n";
                }
                fileScanner.close();
            } else {
                text = input;
            }

           
            String[] words = text.split("[\\s\\p{Punct}]+");

          
            int wordCount = 0;

          
            for (String word : words) {
               
                wordCount++;
            }

            
            System.out.println("Total words: " + wordCount);


        } catch (FileNotFoundException e) {
            System.out.println("File not found or an error occurred.");
        }
    }
}