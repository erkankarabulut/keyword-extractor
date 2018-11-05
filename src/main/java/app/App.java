package app;


import util.CleanUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private static CleanUtil cleanUtil;

    public static void main( String[] args ) {

        String rawHTML  = new String(); // Raw HTML file
        String pureText = new String(); // The test document without html tags and conjunctions

        rawHTML = readTestText();
        cleanUtil = new CleanUtil(rawHTML);

        pureText = cleanUtil.removeConjunctions();
        System.out.println(pureText);

    }

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
