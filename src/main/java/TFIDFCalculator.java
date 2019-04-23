import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TFIDFCalculator {

    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, TreeSet<Integer>> results = new LinkedHashMap<String, TreeSet<Integer>>();
        List<Map<String, Double>> tfWordsDocuments = new ArrayList<Map<String, Double>>();

        for (int i = 1; i <= 171; i++) {
            String filePath = new String("/Users/ilasihsanov/Desktop/qwweq/src/info_search/lemm/" + i + ".txt");
            Scanner scanner = new Scanner(new File(filePath));

            String line = scanner.nextLine().trim();//
            List<String> listWithStrings = Arrays.asList(line.split(" "));
            Map<String, Integer> tfWords = new LinkedHashMap<>();

            for (String aLineData : listWithStrings) {
                if (tfWords.containsKey(aLineData)) {
                    int count = tfWords.get(aLineData);
                    tfWords.put(aLineData, count+1);
                    TreeSet<Integer> hasResults = results.get(aLineData);  //
                    hasResults.add(i);
                    results.put(aLineData, hasResults);
                } else {
                    tfWords.put(aLineData, 1);
                    TreeSet<Integer> hasResults = new TreeSet<Integer>();
                    hasResults.add(i);
                    results.put(aLineData, hasResults);
                }
            }

            PrintWriter writer = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/tf/" + i + ".txt");
            Map<String, Double> wordsWithSize = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> tfWord: tfWords.entrySet()) {
                writer.print(tfWord.getKey());
                writer.print(" ");
                writer.println((double)tfWord.getValue()/tfWords.size());
                wordsWithSize.put(tfWord.getKey(), (double)tfWord.getValue()/tfWords.size());
            }
            tfWordsDocuments.add(wordsWithSize);
            writer.close();
        }

        Map<String, Double> idfResult = new LinkedHashMap<>();
        PrintWriter writer = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/idf/idf.txt");
        for (Map.Entry<String, TreeSet<Integer>> entry : results.entrySet()) {
            int mathCount = entry.getValue().first();
//            System.out.println(171 + "/" + mathCount + " = " + (double)171/mathCount + " log = " + Math.log((double)171/mathCount));
            double idf = Math.log((double)171/mathCount);
            writer.println(entry.getKey() + " " + idf);
            idfResult.put(entry.getKey(), idf);
        }
        writer.close();

        for (Map<String, Double> wordsTf: tfWordsDocuments) {
            PrintWriter idfWriter = new PrintWriter("/Users/ilasihsanov/Desktop/qwweq/src/info_search/tf-idf/" + tfWordsDocuments.indexOf(wordsTf) + "idf.txt");
            for (Map.Entry<String, Double> wordTf: wordsTf.entrySet()) {
                if (idfResult.containsKey(wordTf.getKey())) {
                    Double wordIDF = idfResult.get(wordTf.getKey());
                    Double tfIDF = wordTf.getValue() * wordIDF;
                    idfWriter.println(wordTf.getKey() + " " + (double)tfIDF);
                }
            }
            idfWriter.close();
        }
//        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
//        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
//        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
//        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

//        TFIDFCalculator calculator = new TFIDFCalculator();
//        double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
//        System.out.println("TF-IDF (ipsum) = " + tfidf);

    }


}