package CS3213;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie titles (terminate input by entering empty line) ");

        List<String> inputs = new ArrayList<String>();
        String userInput = sc.nextLine();
        
        while (!userInput.isEmpty()) {
            inputs.add(userInput);
            userInput = sc.nextLine();
        }

        System.out.println("Enter words to ignore (terminate input by entering empty line) ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while (!inputWordToIgnore.isEmpty()) {
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }
        
        System.out.println("Enter required words list (terminate input by entering empty line) ");
        String inputReqWords = sc.nextLine();
        List<String> reqWordsList = new ArrayList<String>();
        while (!inputReqWords.isEmpty()) {
        	reqWordsList.add(inputReqWords);
        	inputReqWords = sc.nextLine();
        }
        

        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        
        KeyFilter keyfilter = new KeyFilter();
        keyfilter.setRequiredWords(reqWordsList);
        keyfilter.setKwicOriList(Arrays.asList(result));
        
        List<String> filtered_results = keyfilter.filterList();
        
        StringBuilder builder = new StringBuilder();
        
        String separator = System.lineSeparator();
        for (String str : filtered_results) {
            builder.append(str).append(separator);
        }
        System.out.print(builder.toString());

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
        System.exit(0);
    }
}
