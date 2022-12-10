import java.util.ArrayList;
import java.util.Set;

public class day3 {
    int score_rucksack(String rucksack)
    {
        int half_index = rucksack.length()/2 - 1;
        String compartment1 = rucksack.substring(0, rucksack.length()/2);
        String compartment2 = rucksack.substring(rucksack.length()/2, rucksack.length());
        char misplaced_item = '`';
        misplaced_item = find_common_item(compartment1, compartment2);
        return score_item(misplaced_item);
    }

    private char find_common_item(String compartment1, String compartment2) {
        char common_item = '`';
        for (char c : compartment1.toCharArray())
        {
            if (compartment2.contains(Character.toString(c)))
            {
                common_item = c;
                break;
            }
        }
        return common_item;
    }

    private ArrayList<Character> find_common_items (String items1, String items2)
    {
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : items1.toCharArray())
        {
            if (items2.contains(Character.toString(c)))
            {
                if (!list.contains(c))
                {
                    list.add(c);
                }
            }
        }
        return list;
    }


    private int score_item(char misplaced_item) {
        int ascii = misplaced_item - 'a' + 1;
        if (ascii < 0)
        {
            ascii += 'a' - 'A' + 26;
        }
        return ascii;
    }

    int score_badge(String rucksack1, String rucksack2, String rucksack3)
    {
        ArrayList<Character> common_items = find_common_items(rucksack1, rucksack2);
        common_items = find_common_items(common_items.toString(), rucksack3);
        char badge = common_items.get(0);
        return score_item(badge);
    }
}

