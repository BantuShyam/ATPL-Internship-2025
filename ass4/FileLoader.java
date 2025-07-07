import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileLoader {
    public static void loadFile(String path){
        try(FileInputStream fi=new FileInputStream(path)){
            int line;
            while((line=fi.read())!= -1){
                char ch =(char) line;
                    System.out.println(ch);
        }
        System.out.println("File found");
    }
    catch(FileNotFoundException f){
        System.out.println("file not found");
    }
    catch(IOException ie){
        System.out.println("error reading file");
    }
}
public static void main(String[] args) {
    loadFile("example.txt");
}
}
