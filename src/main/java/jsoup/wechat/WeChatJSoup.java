package jsoup.wechat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class WeChatJSoup {

    static String pdfUrl = "D:/chromdownload/pdf";
    static String htmlUrl = "D:/chromdownload/html";
    static String gongZhongHao = "https://mp.weixin.qq.com/s/N-b5Mr414-D2lo6FT7Ur3g";

    public static void main(String[] args) {
        begin();
    }

    private static void begin() {
        try {
            // 通过url获取dom
            Document document = Jsoup.connect(gongZhongHao).get();
            if (document == null) {
                return;
            }
            Elements elements = document.select("meta[property=og:title]");
            String fileName = elements.get(0).attr("content") + ".pdf";
            //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\ITextTest.pdf"));
            String html = document.html();


            // 创建文件
            File file = new File(htmlUrl);
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 有问题的
    /*private static void start() {
        UrlParase urlParase = new UrlParase(gongZhongHao);
        Map<String, String> htmlStrs = urlParase.parase();
        if (htmlStrs == null || htmlStrs.isEmpty()) {
            return;
        }
        OutputPdf outputPdf = new OutputPdf();
        // 解析输出pdf
        outputPdf.parse(htmlStrs);
    }*/

}
