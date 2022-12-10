import java.util.Set;

public class day3 {
    int score_rucksack(String rucksack)
    {
        int half_index = rucksack.length()/2 - 1;
        String compartment1 = rucksack.substring(0, rucksack.length()/2);
        String compartment2 = rucksack.substring(rucksack.length()/2, rucksack.length());
        char misplaced_item = '`';
        for (char c : compartment1.toCharArray())
        {
            if (compartment2.contains(Character.toString(c)))
            {
                misplaced_item = c;
                break;
            }
        }
        int ascii = misplaced_item - 'a' + 1;
        if (ascii < 0)
        {
            ascii += 'a' - 'A' + 26;
        }
        return ascii;
    }
}

