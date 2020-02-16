package jsoup.htmls;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {

    /**
     * 解析csdn一些目录
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://blog.csdn.net/zhouwei1818/article/details/80180872").get();
        if (document == null) {
            return;
        }
        Elements elements = document.select("strong");
        for (Element element : elements) {
            System.out.println(element.text());
        }
    }
}
