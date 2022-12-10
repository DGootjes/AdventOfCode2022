import java.io.*;
import java.util.ArrayList;

public class AdventInputReader {
    public ArrayList<String> readLines(String path) throws IOException {
        ArrayList<String> Lines = new ArrayList<String>();
        String line;
        File fp = new File(path);
        FileReader fr = null;
        try {
            fr = new FileReader(fp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);

        while((line = br.readLine()) != null) {
            Lines.add(line);
        }

        fr.close();
        return Lines;
    }
}
