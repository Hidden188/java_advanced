package jsoup.wechat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class JavaInterview {

    static String url = "https://mp.weixin.qq.com/s/tRoMPMXUOVoY6MUtZXu4tw";

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a[target=_blank]"); // 获取每一期连接
            FileOutputStream fos = null;
            for (Element element : elements) {
                String subUrl = element.attr("href");
                document = Jsoup.connect(subUrl).get();
                String title = document.select("meta[property=og:title]").first().attr("content");
                File file = new File("D:/chromdownload/", title + ".html");
                // 下载图片、音频、视频，并修改其链接为本地
                document = getImagAudio(document);
                // 写入html内容
                fos = new FileOutputStream(file);
                fos.write(document.html().getBytes());
                // 创建文件
                file.createNewFile();
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存图片、音视频，并修改连接
     *
     * @param document
     * @return
     */
    private static Document getImagAudio(Document document) throws IOException {
        // TODO
        Elements elements = document.getElementsByAttribute("src");
        //elements.addAll(document.getElementsByAttribute("href"));
        for (Element element : elements) {
            String srcUrl = element.attr("src");
            // 下载资源
            URL url = new URL(srcUrl);
            URLConnection uc = url.openConnection();
            InputStream is = uc.getInputStream();
            // 创建存放资源的文件夹路径
            String srcPath = "";
            File file = new File(srcPath);
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while ((i = is.read()) != -1) {
                out.write(i);
            }
            is.close();
        }
        return document;
    }
}
