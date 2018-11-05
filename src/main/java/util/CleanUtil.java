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

    private Document document; // Raw HTML file in Jsoup Document format
    private String   text;     // Removed HTML tags version of Document

    public CleanUtil(String rawHtml){
        document    = Jsoup.parse(rawHtml);
        text        = document.text().toLowerCase();
    }

    public String removeConjunctions(){

        try{
            File file =
                    new File(System.getProperty("user.dir") + "/data/conjunctions.txt");
            Scanner sc = new Scanner(file);

            String temp = new String();
            while (sc.hasNextLine()){
                temp += sc.nextLine() + "\n";
            }

            String[] conjunctionList = temp.split(",");
            for (String conjunction : conjunctionList){
                text = text.replaceAll(" " + conjunction + " ", " ");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return text;
    }



}
