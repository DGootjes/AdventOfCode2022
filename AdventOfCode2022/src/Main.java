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
            for (int i=0; i< lines.size(); i=i+3)
            {
                sum += d.score_badge(lines.get(i), lines.get(i+1), lines.get(i+2));
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
