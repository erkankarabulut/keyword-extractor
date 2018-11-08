package util;

import java.util.ArrayList;
import java.util.List;

public class Indexer {

    public List<List<String>> rotateSentences(List<String> sentenceList){
        List<List<String>> resultList = new ArrayList<>();
        for(String sentence : sentenceList){
            String[] words              = sentence.split(" ");
            String temp                 = new String();
            List<String> tempSentence   = new ArrayList<>();

            for (int i=0; i<words.length; i++){
                temp = rotate(words, i);
                tempSentence.add(temp);
            }

            java.util.Collections.sort(tempSentence);
            resultList.add(tempSentence);
        }

        return resultList;
    }

    public String rotate(String[] words, Integer startIndex){
        String result = new String();

        for(int i=0; i<words.length; i++){
            result += words[(startIndex + i) % words.length] + " ";
        }

        return result;
    }

}
