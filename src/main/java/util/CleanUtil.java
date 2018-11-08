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

    // This method removes conjunctions from a given html file content

    // @param text Html content

    // @return Remove conjunction version of given text

    public String removeConjunctions(String text){
        String result = text;

        try{

            File file =
                    new File(this.getClass().getResource("").getPath() + "../../../../../../data/conjunctions.txt");
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

    // It parses raw html content to xml document

    // @param text Html content

    // @return xml doc

    public Document getRawHTMLDocument(String htmlContent){
        return Jsoup.parse(htmlContent);
    }

    // It divides given text into sentences with using a regex

    // @param pureText The text that does not contains any conjunction or html tag

    // @return sentece list

    public List<String> divideIntoSentences(String pureText){
        ArrayList<String> resultList = new ArrayList<>();

        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(pureText);
        while (reMatcher.find()) {
            resultList.add(reMatcher.group());
        }

        return resultList;
    }

}
