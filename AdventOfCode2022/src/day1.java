import java.io.*;
import java.util.ArrayList;

public class day1 {
    private ArrayList<String> Lines;
    private TopList TopList;

    public day1()
    {
        Lines = new ArrayList<String>();
        TopList = new TopList(3);
    }
    public void ReadInput() throws IOException {
        String line;
        File fp = new File(System.getProperty("user.dir") + "\\AdventOfCode2022\\Day1\\input.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(fp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);

        while((line = br.readLine()) != null) { Lines.add(line); }

        fr.close();
    }

    public double MostCalories(int Top)
    {
        double CurrentCalories = 0.0;
        for (String line : Lines)
        {
            if (line.equalsIgnoreCase(""))
            {
                TopList.TryAdd(CurrentCalories);
                CurrentCalories = 0.0;
            }
            else
            {
                CurrentCalories += Double.parseDouble(line);
            }
        }
        return TopList.Sum(Top);
    }
}
