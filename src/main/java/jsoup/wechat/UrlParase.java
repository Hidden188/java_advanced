package jsoup.wechat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UrlParase {

    private String gongZhongHao;

    // “青橄榄在家上学公众号首页”
    String termite = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzA5MjIzNDcwOA==&scene=124&uin=&key=&devicetype=Windows+10&version=620603c8&lang=zh_CN&a8scene=7&winzoom=1";

    public UrlParase(String gongZhongHao) {
        this.gongZhongHao = gongZhongHao;
    }


    public Map<String, String> parase() {
        try {
            Document document = Jsoup.connect(gongZhongHao).get();
            String html = document.html();
            Elements elements = document.select("meta[property=og:title]");
            String title = elements.get(0).attr("content");
            Map<String, String> returnMap = new HashMap<>();
            returnMap.put("title", title);
            returnMap.put("html" , html);
            return returnMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
