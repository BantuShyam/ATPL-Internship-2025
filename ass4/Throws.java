import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Throws {
    public static int readFile(File f) throws IOException{
        int lineCount=0;
        if(!f.exists() && !f.isFile()){
            System.out.println("Invalid file...");
            return 0;
        }
        else{
            try(BufferedReader br=new BufferedReader(new FileReader(f))){
                String line;
                while((line=br.readLine())!=null){
                    lineCount++;
                }
                System.out.println("The number of lines in the file is "+lineCount);
        }
    }
    return lineCount;
}
public static void main(String[] args){
    try{
        File f=new File("example.txt");
        readFile(f);
    }
    catch(IOException e){
        System.out.println("the error is "+e.getMessage());
    }
}
}
