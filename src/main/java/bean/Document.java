package bean;

import java.util.List;

public class Document {

    private org.jsoup.nodes.Document    rawHTML;    // Raw HTML file in Jsoup Document format
    private String                      pureText;   // Removed HTML tags and conjunctions version of Document
    private List<String> sentences;                 // Sentences of the pure text

    public org.jsoup.nodes.Document getRawHTML() {
        return rawHTML;
    }

    public void setRawHTML(org.jsoup.nodes.Document rawHTML) {
        this.rawHTML = rawHTML;
    }

    public String getPureText() {
        return pureText;
    }

    public void setPureText(String pureText) {
        this.pureText = pureText;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }
}
