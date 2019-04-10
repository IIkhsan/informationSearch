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
        PrintWriter indexWriter = new PrintWriter("index.txt");
        for (int i = 10; i <= 31; i++) {
            String url = "https://lenta.ru/news/2017/07/" + i + "/";
            Document document = Jsoup.connect(url).get();
            String text = document.select(".g-layout div").text();
            System.out.println(text);
            String docName = j + ".txt";
            PrintWriter writer = new PrintWriter(docName);
            writer.println(text);
            writer.close();
            indexWriter.println(j + ".txt " + url);
            j++;
        }
        indexWriter.close();

    }

}