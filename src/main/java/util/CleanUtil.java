package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CleanUtil {

    public String removeHtmlTags(String htmlContent){
        String result   = new String();

        try {
            FileReader fr = new FileReader();
            fr.
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public String readTextFile(){
        String testText = new String();

        try{
            File file =
                    new File(System.getProperty("user.dir") + "/data/data.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }catch (IOException e){
            e.printStackTrace();
        }

        return testText;
    }

}
