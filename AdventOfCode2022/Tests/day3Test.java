import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class Day3Test {

    private day3 d;

    @BeforeEach
    void setUp() {
        d = new day3();
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void test_compartments_scores()
    {
        int score;
        score = d.score_rucksack("aa");
        assertEquals(1, score);

        score = d.score_rucksack("bb");
        assertEquals(2, score);

        score = d.score_rucksack("AA");
        assertEquals(27, score);

        score = d.score_rucksack("ZZ");
        assertEquals(52, score);
    }

    @org.junit.jupiter.api.Test
    void test_nonidentical_compartments()
    {
        int score;

        score = d.score_rucksack("");
        assertEquals(0, score);

        score = d.score_rucksack("baca");
        assertEquals(1, score);

        score = d.score_rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        assertEquals(16, score);

        score = d.score_rucksack("vJrwzWtwJgWrhcsFMMfFFhFz");
        assertEquals(26, score);
    }

    @org.junit.jupiter.api.Test
    void test_sum()
    {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        lines.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        lines.add("PmmdzqPrVvPwwTWBwg");
        lines.add("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        lines.add("ttgJtRGJQctTZtZT");
        lines.add("CrZsJsPPZsGzwwsLwLmpwMDw");
        int score = 0;
        for (String line: lines)
        {
            score += d.score_rucksack(line);
        }
        assertEquals(157, score);
    }
}