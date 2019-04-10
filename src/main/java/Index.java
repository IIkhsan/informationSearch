import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Index {
    public static void main(String[] args) throws IOException {

        Map<String, TreeSet<Integer>> results = new LinkedHashMap<String, TreeSet<Integer>>();

        for (int i = 1; i <= 22; i++) {
            String name = "/Users/ilasihsanov/Desktop/qwweq/src/info_search/lemm/" + i + ".txt";
            Scanner scanner = new Scanner(new File(name));

            String line = scanner.nextLine().trim();//������� ��������� �������
            String lineData[] = line.split(" ");

            for (String aLineData : lineData) {
                if (results.containsKey(aLineData)) {   //���� map �������� ����� ����
                    TreeSet<Integer> hasResults = results.get(aLineData);  //������� �������� �����
                    hasResults.add(i);
                    results.put(aLineData, hasResults);

                } else {
                    TreeSet<Integer> hasResults = new TreeSet<Integer>();
                    hasResults.add(i);
                    results.put(aLineData, hasResults);
                }
            }
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : results.entrySet()) {
            String name = "/Users/ilasihsanov/Desktop/qwweq/src/info_search/invert/" + entry.getKey() + ".txt";
            PrintWriter writer = new PrintWriter(name);
            String value = "";
            for (Integer number : entry.getValue()) {
                value += number + " ";
            }
            writer.println(value);
            writer.close();
        }

    }
}
