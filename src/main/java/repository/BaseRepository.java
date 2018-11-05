package repository;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BaseRepository {

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
