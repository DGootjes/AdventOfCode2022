import java.util.*;

class CrateAction {
    int from_crate;
    int move_crate_count;
    int to_crate;
}
public class day5 {
    public day5(){
        stack_list = new ArrayList<Stack<Character>>();
        crate_actions = new ArrayDeque <CrateAction>();
    }
    private ArrayList<Stack<Character>> stack_list;
    private Queue<CrateAction> crate_actions;

    private void invert_stacks(String line)
    {
        // Reverse stacks
        Stack<Character> temp = new Stack<Character>();
        for (Stack<Character> s : stack_list)
        {
            while (!s.empty())
            {
                temp.push(s.pop());
            }
            s.addAll(temp);
            temp.clear();
        }
    }

    private void parse_action(String line)
    {
        CrateAction action = new CrateAction();

        line = line.replace("move ", "");
        line = line.replace("from ", "");
        line = line.replace("to ", "");
        String[] values = line.split(" ");

        action.move_crate_count = Integer.parseInt(values[0]);
        action.from_crate = Integer.parseInt(values[1]) -1;
        action.to_crate = Integer.parseInt(values[2]) -1;
        crate_actions.add(action);
    }
    private void parse_crate(String line)
    {
        Character c;
        for (int i =1; i < line.length(); i=i+4)
        {
            c = line.charAt(i);
            if (c != ' ')
            {
                stack_list.get((i-1)/4).push(c);
            }
        }
    }
    private void parse_line(String line)
    {
        // Three types of lines
        // 1. Crate rows
        // 2. Crate numbers (1 .. 9)
        // 3. Action line
        if (line.contains("["))
        {
            parse_crate(line);
        }
        else if (line.contains("1   2"))
        {
            invert_stacks(line);
        }
        else if (line.contains("move"))
        {
            // parse action
            parse_action(line);
        }
        else
        {
            // do nothing
        }

    }
    public void parse(ArrayList<String> lines)
    {
        int line_length = lines.get(0).length();
        int stack_count = (line_length + 1) / 4;
        for (int i =0; i < stack_count; i++)
        {
            stack_list.add(new Stack<Character>());
        }

        for (String line : lines)
        {
            parse_line(line);
        }
    }
    public void perform_actions()
    {
        for (CrateAction action : crate_actions)
        {
            perform_crate_action(action);
        }
    }

    public void print_top_crates()
    {
        StringBuilder output = new StringBuilder();
        for (Stack<Character> s : stack_list)
        {
            output.append(s.peek());
        }
        System.out.println(output);
    }
    private void perform_crate_action(CrateAction action) {
        Stack<Character> from_stack = stack_list.get(action.from_crate);
        Stack<Character> to_stack = stack_list.get(action.to_crate);

        Stack<Character> inbetween = new Stack<Character>();
        for (int i = 0; i < action.move_crate_count; i++)
        {
            inbetween.add(from_stack.pop());
        }
        while (!inbetween.empty())
        {
            to_stack.push(inbetween.pop());
        }

        // algo for part 1
        //for (int i = 0; i < action.move_crate_count; i++)
        //{
            // to_stack.add(from_stack.pop());
        //}
    }
}
