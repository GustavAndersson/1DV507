package ga222gb_assign3.count_words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WordCount1Main {

    public static void main(String[] args) throws IOException{
        Set<Word> hashSet = new HashSet<>();
        Set<Word> treeSet = new TreeSet<>();

        String text = readText("C:\\Users\\guust\\Desktop\\words.txt");
        String[] words = text.split(" ");

        for(int i = 0; i < words.length; i++){
            Word word = new Word(words[i]);
            hashSet.add(word);
            treeSet.add(word);
        }

        Iterator<Word> it = treeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("Hashset size: " + hashSet.size());
        System.out.println("Treeset size: " + treeSet.size());
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
