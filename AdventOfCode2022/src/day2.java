import java.io.*;
import java.util.ArrayList;

// A | X = ROCK = 1 point
// B | Y = PAPER = 2 points
// C | Z = SCISSORS = 3 points

// Win = 6 points
// Draw = 3 points
// Lose = 0 points

enum RockPaperScissors
    {
        rock, paper, scissors, undefined
    };

enum GameResult
{
    lose, draw, win
}
public class day2 {
    public day2()
    {
        Lines = new ArrayList<String>();
    }
    public ArrayList<String> Lines;
    public void ReadInput() throws IOException {
        String line;
        File fp = new File(System.getProperty("user.dir") + "\\AdventOfCode2022\\Day2\\input.txt");
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

    private RockPaperScissors parse_naive_code(String code)
    {
        if (code.equalsIgnoreCase("A")| code.equalsIgnoreCase("X"))
        {
            return RockPaperScissors.rock;
        }
        if (code.equalsIgnoreCase("B")| code.equalsIgnoreCase("Y"))
        {
            return RockPaperScissors.paper;
        }
        if (code.equalsIgnoreCase("C")| code.equalsIgnoreCase("Z"))
        {
            return RockPaperScissors.scissors;
        }
        return RockPaperScissors.undefined;
    }

    private RockPaperScissors parse_opponent(String code)
    {
        if (code.equalsIgnoreCase("A"))
        {
            return RockPaperScissors.rock;
        }
        else if (code.equalsIgnoreCase("B"))
        {
            return RockPaperScissors.paper;
        }
        else
        {
            return RockPaperScissors.scissors;
        }
    }

    private GameResult parse_desired_result(String code)
    {
        if (code.equalsIgnoreCase("X"))
        {
            return GameResult.lose;
        }
        else if (code.equalsIgnoreCase("Y"))
        {
            return GameResult.draw;
        }
        else
        {
            return GameResult.win;
        }
    }

    private RockPaperScissors response(RockPaperScissors opponent, GameResult desired)
    {
        if (desired.equals(GameResult.draw))
        {
            return opponent;
        }
        else if(desired.equals(GameResult.win))
        {
            if (opponent.equals(RockPaperScissors.rock)) {
                return RockPaperScissors.paper;
            }
            else if (opponent.equals(RockPaperScissors.paper))
            {
                return RockPaperScissors.scissors;
            }
            else
            {
                return RockPaperScissors.rock;
            }
        }
        else
        {
            if (opponent.equals(RockPaperScissors.rock)) {
                return RockPaperScissors.scissors;
            }
            else if (opponent.equals(RockPaperScissors.paper))
            {
                return RockPaperScissors.rock;
            }
            else
            {
                return RockPaperScissors.paper;
            }
        }
    }
    private GameResult play(RockPaperScissors me, RockPaperScissors opponent)
    {
        if (me.equals(RockPaperScissors.rock))
        {
            if (opponent.equals(RockPaperScissors.rock))
            {
                return GameResult.draw;
            }
            else if (opponent.equals(RockPaperScissors.paper))
            {
                return  GameResult.lose;
            }
            else
            {
                return GameResult.win;
            }
        }
        else if (me.equals(RockPaperScissors.paper))
        {
            if (opponent.equals(RockPaperScissors.rock))
            {
                return GameResult.win;
            }
            else if (opponent.equals(RockPaperScissors.paper))
            {
                return  GameResult.draw;
            }
            else
            {
                return GameResult.lose;
            }
        }
        else
        {
            if (opponent.equals(RockPaperScissors.rock))
            {
                return GameResult.lose;
            }
            else if (opponent.equals(RockPaperScissors.paper))
            {
                return  GameResult.win;
            }
            else
            {
                return GameResult.draw;
            }
        }
    }
    public int score(String line) {
        String[] splits = line.split(" ");
        RockPaperScissors opponent = parse_opponent(splits[0]);
        GameResult result = parse_desired_result(splits[1]);

        RockPaperScissors me = response(opponent, result);

        //GameResult result = play(me, opponent);
        int score = 0;
        if (me.equals(RockPaperScissors.rock)) {
            score += 1;
        } else if (me.equals(RockPaperScissors.paper)) {
            score += 2;
        } else {
            score += 3;
        }

        if (result.equals(GameResult.win))
        {
            score += 6;
        }
        else if (result.equals(GameResult.draw))
        {
            score += 3;
        }

        return score;
    }

    public int play_entire_game()
    {
        int score = 0;
        for (String line : Lines)
        {
            score += score(line);
        }
        return score;
    }
}
