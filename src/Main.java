import service.ReadFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile=new ReadFile();
       if( readFile.getFileData()){
           System.out.println("Read file and save to database was successfully");
       }else {
           System.out.println("sorry ==> save to database was failed !");
       }
    }
}
