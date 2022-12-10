import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String inputfile = System.getProperty("user.dir") + "\\AdventOfCode2022\\Day3\\input.txt";

        AdventInputReader reader = new AdventInputReader();
        day3 d;
        d = new day3();
        try {
            ArrayList<String> lines =  reader.readLines(inputfile);
            int sum = 0;
            for (String line: lines)
            {
                sum += d.score_rucksack(line);
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
