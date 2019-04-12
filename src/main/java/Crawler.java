import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Crawler {

    public static void main(String[] args) throws Exception {
        int j = 1;
        PrintWriter indexWriter = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/docs/index.txt");
        for (int k = 1; k <= 9; k++) {
            for (int i = 10; i <= 28; i++) {
                String url = "https://lenta.ru/news/2018/0" + k +"/" + i + "/";
                Document document = Jsoup.connect(url).get();
                String text = document.select(".g-layout div").text();
                String docName = j + ".txt";
                PrintWriter writer = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/docs/" + docName);
                writer.println(text);
                writer.close();
                indexWriter.println(j + ".txt " + url);
                j++;
                System.out.println(url);
            }
        }
        indexWriter.close();

    }

}