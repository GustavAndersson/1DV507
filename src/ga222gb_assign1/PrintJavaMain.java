package ga222gb_assign1;

import java.io.*;

public class PrintJavaMain {

    public static void main(String[] args) throws IOException{
        try{
            File startDir = new File("C:\\Users\\guust\\IdeaProjects\\1DV507\\src\\ga222gb_assign1");
            printAllJavaFiles(startDir);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static int depth = 1, count = 0;
    public static void printAllJavaFiles(File file) throws IOException{
        if(file.isDirectory()){
            System.out.println((++count) + indentation() + file.getName());
            depth++;
            File[] subs = file.listFiles();
            for(File f : subs){
                printAllJavaFiles(f);
            }
            depth--;
        }else if(file.isFile()){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int rows = 0;
            while(reader.readLine() != null){
                rows++;
            }
            reader.close();
            System.out.println((++count) + indentation() + file.getName() + " (" + rows + " rows)");
        }
    }

    public static String indentation(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < depth; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
