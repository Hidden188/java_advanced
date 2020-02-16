package jsoup.tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class UrlGet {

    static String urlBef = "http://10.1.0.6/trac/LabwayLIMS/search?ticket=on&changeset=on&q=ma.jian&page=";
    static String urlAft = "&noquickjump=1";
    static Set<String> tickets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = null;
        HttpURLConnection conn = null;
        for (int i = 1; i < 52; i++) {
            String urlStr = urlBef + String.valueOf(i) + urlAft;
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1096.1 Safari/536.6");
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setDoOutput(true);
            if (conn.getResponseCode() == 302) {
                System.out.println(302);
            }
            if (conn.getResponseCode() == 200) {
                System.out.println(200);
            }
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String s = "";
            while ((s = rd.readLine()) != null) {
                //sb.append(s);
                getTickets(s);
            }
            /*if (sb.length() == 0) {
                sb.append("[]");
            }
            String result = sb.toString();
            System.out.println(result);*/
        }

        rd.close();
        conn.disconnect();
        System.out.println(tickets.toString());
        System.out.println(tickets.size());
    }

    private static void getTickets(String text) {
        if (!text.contains("#")) {
            return;
        }
        int index = text.indexOf('#');
        if (!text.substring(index + 1, index + 4).matches("-?[0-9]+.*[0-9]*")) { // 判断是不是ticket号
            return;
        }
        String ticket = text.substring(index, index + 4);
        tickets.add(ticket);
    }

}
