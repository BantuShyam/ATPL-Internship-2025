import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ExceptionsExample {
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
public static void NullPointerExample(){
    String s=null;
    System.out.println(s.length());
}
public static void ArithmeticExceptionExample(){
     BigDecimal a1 = new BigDecimal(25);  
        BigDecimal a2 = new BigDecimal(7);  

        a1 = a1.divide(a2);  
        System.out.println(a1.toString());
}
public static void fileException(String f) throws FileNotFoundException{
    File f2=new File(f);
    Scanner s=new Scanner(f2);


    while(s.hasNextLine()){
        System.out.println(s.nextLine());
    }
    s.close();
}
public static void main(String[] args){
    try{
        File f=new File("example1.txt");
        readFile(f);
    }
    catch(IOException e){
        System.out.println("the error is "+e.getMessage());
    }
    try{
        NullPointerExample();
    }
    catch(NullPointerException n){
        System.out.println("null pointer example "+n.getMessage());
    }
    try{
        ArithmeticExceptionExample();
    }
    catch(ArithmeticException a){
        System.out.println(a.getMessage());
    }
    try{
        fileException("example2.txt");
    }
    catch(FileNotFoundException f){
        System.out.println(f.getMessage());
    }
}
}
