package repository;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BaseRepository {

    // This method is created for test purposes. It reads a data file which includues an html page and returns it's content

    public static String readTestText(){
        String testText = new String();

        try{
            File file =
                    new File(System.getProperty("user.dir") + "/data/data.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                testText += sc.nextLine() + "\n";
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return testText;
    }

}
