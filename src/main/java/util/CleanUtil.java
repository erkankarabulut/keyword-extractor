package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanUtil {


    public String removeConjunctions(String text){
        String result = text;

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
                result = result.replaceAll(" " + conjunction + " ", " ");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    public Document getRawHTMLDocument(String htmlContent){
        return Jsoup.parse(htmlContent);
    }

    public List<String> divideIntoSentences(String pureText){
        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(pureText);
        while (reMatcher.find()) {
            System.out.println(reMatcher.group());
        }

        return Arrays.asList(pureText.split("\n"));
    }

}
