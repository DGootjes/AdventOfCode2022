import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @org.junit.jupiter.api.Test
    void test_basic_score() {
        day2 d2;
        int score;
        d2 = new day2();

        // Lose
        score = d2.score("A Z");
        assertEquals(3, score);

        score = d2.score("B X");
        assertEquals(1, score);

        score = d2.score("C Y");
        assertEquals(2, score);

        // Draw
        score = d2.score("A X");
        assertEquals(4, score);

        score = d2.score("B Y");
        assertEquals(5, score);
    }
}