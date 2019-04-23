//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class TF {
//    public static void main(String[] args) throws FileNotFoundException {
//
//        for (int i=1; i <= 171; i++) {
//            String name = "/Users/ilasihsanov/Desktop/qwweq/src/info_search/lemm/" + i + ".txt";
//            Scanner scanner = new Scanner(new File(name));
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine().trim();
//                String lineData[] = line.split(" ");
//                for (int j = 0; j < lineData.length; j++) {
//                    String word= porter.stem(lineData[j]);
//                    writer.print(word+" ");
//                }
//            }
//        }
//    }
//
//    public HashMap<String, Map> calculaterTermFrequency(HashMap<String, Integer>inputMap) {
//
//        HashMap termFreqMap = new HashMap<>();
//        double sum = 0.0;
//        for (float val: inputMap.values()) {
//            sum += val;
//        }
//
//        Iterator it = inputMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            double tf = (Integer)pair.getValue()/sum;
//            termFreqMap.put((pair.getKey().toString()), tf);
//        }
//        return termFreqMap;
//    }
//
//    public HashMap<String,Double> calculateInverseDocFrequency(String [] docProperties)
//    {
//        HashMap<String,Double> InverseDocFreqMap = new HashMap<>();
//        int size = docProperties.length;
//        double wordCount ;
//        for (String word : wordList) {
//            wordCount = 0;
//            for(int i=0;i<size;i++)
//            {
//                HashMap<String,Integer> tempMap = docProperties[i].getWordCountMap();
//                if(tempMap.containsKey(word))
//                {
//                    wordCount++;
//                    continue;
//                }
//            }
//            double temp = size/ wordCount;
//            double idf = 1 + Math.log(temp);
//            InverseDocFreqMap.put(word,idf);
//        }
//        return InverseDocFreqMap;
//    }
//}
