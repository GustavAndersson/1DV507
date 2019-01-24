package ga222gb_assign1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class WarAndPeace {

    public static void main(String[] args) throws IOException{

        String text = readText("C:\\Users\\guust\\Desktop\\WarAndPeace.txt");
        String[] words = text.split(" ");
        System.out.println("Initial word count: " + words.length);

        Stream<String> stream = Arrays.stream(words);

        long wordCount = stream
                .map(w -> cleanUp(w))
                .filter(w -> w.length() > 0)
                .map(w -> w.toLowerCase())
                .distinct()
                .count();
        System.out.println("Unique words: " + wordCount);

    }

    public static String cleanUp(String word){
        word = word.replaceAll("\\p{Pd}", "-");     //Change all em-dash (—) to  basic dash (-)
        word = word.replaceAll("[^A-Za-z-]", "");   //Save A-z and -
        return word;
    }

    public static String readText(String filePath) throws IOException{
        StringBuffer sb = new StringBuffer();
        try{
            String line;
            FileReader in = new FileReader(filePath);
            BufferedReader br = new BufferedReader(in);
            while((line = br.readLine()) != null){
                sb.append(line + " ");
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
