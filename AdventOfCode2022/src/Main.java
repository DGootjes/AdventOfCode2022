import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String inputfile = System.getProperty("user.dir") + "\\AdventOfCode2022\\Day5\\input.txt";
        AdventInputReader reader = new AdventInputReader();

        try {
            ArrayList<String> lines;
            lines = reader.readLines(inputfile);
            run_day5(lines);
            //System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run_day5(ArrayList<String> lines)
    {
        day5 d;
        d = new day5();
        d.parse(lines);
        d.perform_actions();
        d.print_top_crates();
    }
}
