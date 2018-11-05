package app;


import bean.Document;
import repository.BaseRepository;
import util.CleanUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private static CleanUtil        cleanUtil;
    private static Document         document;
    private static BaseRepository   baseRepository;

    public static void main( String[] args ) {

        document            = new Document();
        cleanUtil           = new CleanUtil();

        document.setRawHTML(cleanUtil.getRawHTMLDocument(baseRepository.readTestText()));
        document.setPureText(cleanUtil.removeConjunctions(document.getRawHTML().text()));
        document.setSentences(cleanUtil.divideIntoSentences(document.getPureText()));

    }


}
