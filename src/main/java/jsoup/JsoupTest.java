package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

public class JsoupTest {
    public static void main(String[] args) {
        get();
    }

    public static void jsoup() {
        try {
            // 直接从字符串中输入 HTML 文档
            String html = "<html><head><title>测试</title></head><body><p>jsoup 相关文章</p></body></html>";
            Document doc = Jsoup.parse(html);

            // 从URL加载 HTML 文档
            doc = Jsoup.connect("https://www.baidu.com/").get();

            // 从文件中加载 HTML 文档
            File input = new File("D:/baidu.html");
            doc = Jsoup.parse(input, "UTF-8", "https://www.baidu.com/"); // 这里的url是当input为空时远程访问html

            System.out.println("获取成功");

            // 获取元素节点
            Elements elementdd = doc.select("dd[headers=h_owner]");
            for (Element ele : elementdd) {
                String text = ele.text();
                System.out.println(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void get() {
        TreeSet treeSet = new TreeSet();
        treeSet.add("dog");
        treeSet.add("222");
        treeSet.add("camel");
        treeSet.add("##");
        treeSet.add("cat");
        treeSet.add("ant");
        System.out.println(treeSet);
    }

}
