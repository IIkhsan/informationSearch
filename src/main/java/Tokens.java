import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Tokens {
    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 1; i <= 171; i++) {
            Scanner scanner = new Scanner(new File("/Users/ilasihsanov/Desktop/qwweq/src/info_search/docs/" + i + ".txt"));
            PrintWriter writer = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/tokens/" + i + ".txt");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String lineData[] = line.split(" ");
                for (int j = 0; j < lineData.length; j++) {
                    lineData[j] = lineData[j].replace("?", "");
                    lineData[j] = lineData[j].replace("!", "");
                    lineData[j] = lineData[j].replace("(", "");
                    lineData[j] = lineData[j].replace(")", "");
                    lineData[j] = lineData[j].replace(";", "");
                    lineData[j] = lineData[j].replace(":", "");
                    lineData[j] = lineData[j].replace("-", "");
                    lineData[j] = lineData[j].replace("+", "");
                    lineData[j] = lineData[j].replace("=", "");
                    lineData[j] = lineData[j].replace(".", "");
                    lineData[j] = lineData[j].replace(",", "");
                    lineData[j] = lineData[j].replace("|", "");
                    lineData[j] = lineData[j].replace("/", "");
                    lineData[j] = lineData[j].replace("\"", "");
                    lineData[j] = lineData[j].replace("�", "");
                    lineData[j] = lineData[j].replace("�", "");
                    lineData[j] = lineData[j].replace("�", "");
                    lineData[j] = lineData[j].replace("«", "");
                    lineData[j] = lineData[j].replace("»", "");
                    lineData[j] = lineData[j].toLowerCase();
                    writer.print(lineData[j] + " ");
                }
            }
            writer.close();

        }


    }
}
