package jsoup.tickets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.io.IOException;

public class TicketJSoup {

    static String urlBef = "http://10.1.0.6/trac/LabwayLIMS/search?wiki=on&ticket=on&changeset=on&milestone=on&q=ma.jian&page=";
    static String urlAft = "&noquickjump=1";

    static Set<String> tickets = new HashSet<>();

    static int i = 1;

    public static void main(String[] args) {
        crawer();
    }

    private static void crawer() {
        try {
            for (; i < 52; i++) {
                String url = urlBef + String.valueOf(i) + urlAft;
                Document document = Jsoup.connect(url).get();
                Elements elementdd = document.select("dd");
                Elements elementdt = document.select("dt");
                Elements[] elements = new Elements[]{elementdd, elementdt};
                for (Elements element : elements) {
                    for (Element ele : element) {
                        String text = ele.text();
                        if (!text.contains("#")) {
                            continue;
                        }
                        int index = text.indexOf('#');
                        if (!text.substring(index + 1, index + 4).matches("-?[0-9]+.*[0-9]*")) { // 判断是不是ticket号
                            continue;
                        }
                        String ticket = text.substring(index + 1, index + 5);
                        outPutTicketName(ticket);
                    }
                }
            }
        } catch (IOException e) {
            crawer();
        }
        System.out.println(milestoneMap.toString());
        System.out.println(tickets.toString());
        System.out.println(tickets.size());
    }

    static String ticketBef = "http://10.1.0.6/trac/LabwayLIMS/ticket/";
    static Map<String, List<String>> milestoneMap = new HashMap<>();

    private static void outPutTicketName(String ticketId) throws IOException {
        if (tickets.contains(ticketId)) {
            return;
        }
        tickets.add(ticketId);
        String url = ticketBef + ticketId;
        Document document = Jsoup.connect(url).get();
        // 判断是否是我的ticket
        Elements element = document.select("td[headers=h_owner]");
        String author = element.get(0).text();
        if (!"马建".equals(author)) {
            return;
        }
        element = document.select("span[class=summary]");
        String ticketName = element.get(0).text();

        // 里程碑
        element = document.select("td[headers=h_milestone]");
        String milestone = element.get(0).text();
        if(milestone != null || !"".equals(milestone)) {
            if (milestoneMap.containsKey(milestone)) {
                List<String> names = milestoneMap.get(milestone);
                names.add(ticketName);
                milestoneMap.put(milestone, names);
            } else {
                List<String> names = new ArrayList<> ();
                names.add(ticketName);
                milestoneMap.put(milestone, names);
            }
        }
        System.out.println(ticketId + "  " + ticketName);
    }

}
