import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        sentence = sentence.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

        String[] words = sentence.split("\\s+");

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(
                    word,
                    wordFrequency.getOrDefault(word, 0) + 1
            );
        }

        System.out.println("\nWord Frequency:");
        System.out.println("-----------------------------");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(
                    entry.getKey() + " = " + entry.getValue()
            );
        }

        sc.close();
    }
}
