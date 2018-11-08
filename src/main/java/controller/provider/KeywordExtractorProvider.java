package controller.provider;

import bean.Document;
import org.json.JSONObject;
import repository.BaseRepository;
import util.CleanUtil;
import util.Indexer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class KeywordExtractorProvider {

    private static CleanUtil        cleanUtil;
    private static Document         document;
    private static BaseRepository baseRepository;

    public static JSONObject indexDocument(HttpServletRequest request, MultivaluedMap form){
        JSONObject result = new JSONObject();

        document        = new Document();
        cleanUtil       = new CleanUtil();
        Indexer indexer = new Indexer();

        document.setRawHTML(cleanUtil.getRawHTMLDocument(form.get("document").toString()));
        document.setPureText(cleanUtil.removeConjunctions(document.getRawHTML().text()));
        document.setSentences(cleanUtil.divideIntoSentences(document.getPureText()));

        List<List<String>> rotatedSentenceList = indexer.rotateSentences(document.getSentences());
        result.put("rotatedSentenceList", rotatedSentenceList);
        result.put("url", form.get("url"));
        result.put("status", 200);

        return result;
    }

}
