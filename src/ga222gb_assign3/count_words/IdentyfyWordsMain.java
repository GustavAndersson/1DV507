package ga222gb_assign3.count_words;

import java.io.*;

public class IdentyfyWordsMain {

    public static void main(String[] args) throws IOException{
        try{
            String text = readText("C:\\Users\\guust\\Desktop\\HistoryOfProgramming.txt");
            saveToFile("C:\\Users\\guust\\Desktop\\words.txt", text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String readText(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line;
        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);
        while((line = br.readLine()) != null){
            String cleanLine = line.replaceAll("[^A-Za-z ]", "");
            sb.append(cleanLine + "\n");
        }
        br.close();
        return sb.toString();
    }

    private static void saveToFile(String filePath, String text) throws IOException {
        File file = new File(filePath);
        PrintWriter printer = new PrintWriter(file);
        printer.print(text);
        printer.close();
    }
}

