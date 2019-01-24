package ga222gb_assign3.count_words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount2Main {

    public static void main(String[] args) throws IOException {
        String text = readText("C:\\Users\\guust\\Desktop\\words.txt");
        String[] words = text.split(" ");

        WordSet hashSet = new HashWordSet();
        WordSet treeSet = new TreeWordSet();

        for(int i = 0; i < words.length; i++){
            Word word = new Word(words[i]);
            hashSet.add(word);
            treeSet.add(word);
        }

        System.out.println("Hash size: " + hashSet.size());  //Size of the HashSet
        System.out.println("Tree size: " + treeSet.size());  //Size of the TreeSet

        System.out.println("HashSet toString: " + hashSet.toString()); //Print all words in the HashSet
        System.out.println("TreeSet toString: " + treeSet.toString()); //Print all words in the TreeSet

        Word w1 = new Word("Computer");
        Word w2 = new Word("Linneuniversitetet");
        System.out.println(hashSet.contains(w1)); //Check if HashSet contains the word 'Computer' - should return true.
        System.out.println(treeSet.contains(w1)); //Check if TreeSet contains the word 'Computer' - should return true.
        System.out.println(treeSet.contains(w2)); //Check if TreeSet contains the word 'Linneuniversitetet' - should return false.
    }

    public static String readText(String filePath) throws IOException{
        StringBuffer sb = new StringBuffer();
        try{
            String line;
            FileReader in = new FileReader(filePath);
            BufferedReader br = new BufferedReader(in);
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
