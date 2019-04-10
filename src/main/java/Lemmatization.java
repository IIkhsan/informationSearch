import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Lemmatization {
    public static void main(String[] args) throws FileNotFoundException {
        Porter porter = new Porter();
        for (int i = 1; i <= 22; i++) {
            Scanner scanner = new Scanner(new File("/Users/ilasihsanov/Desktop/qwweq/src/info_search/tokens/" + i + ".txt"));
            PrintWriter writer = new PrintWriter(i + ".txt");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String lineData[] = line.split(" ");
                for (int j = 0; j < lineData.length; j++) {
                    String word= porter.stem(lineData[j]);
                    writer.print(word+" ");
                }
            }
            writer.close();


        }


    }
}
