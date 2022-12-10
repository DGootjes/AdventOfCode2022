public class day4 {

    private int elf1_first_task;
    private int elf1_final_task;
    private int elf2_first_task;
    private int elf2_final_task;

    private boolean range_overlap(int a, int b, int c, int d)
    {
        boolean condition = false;
        if ((a >= c) && (a <= d))
        {
            condition = true;
        }
        else if ((b >= c ) && (b <= d))
        {
            condition = true;
        }
        else if ((c >= a) && (c <= b))
        {
            condition = true;
        }
        else if ((d >= a) && (d <= b))
        {
            condition = true;
        }

        return condition;
    }
    private boolean range_contain(int a, int b, int c, int d)
    {
        boolean condition = false;
        if ((a >= c) && (b <= d))
        {
            condition = true;
        }
        else if ((c >= a) && (d <= b))
        {
            condition = true;
        }
        return condition;
    }
    public boolean contains(String line)
    {
        parse(line);
        return range_contain(elf1_first_task, elf1_final_task, elf2_first_task, elf2_final_task);
    }

    public boolean overlap(String line)
    {
        parse(line);
        return range_overlap(elf1_first_task, elf1_final_task, elf2_first_task, elf2_final_task);
    }
    private void parse(String line) {
        String[] elves_tasks = line.split(",");
        String elf1_taskrange = elves_tasks[0];
        String elf2_taskrange = elves_tasks[1];

        String[] elf1_tasks = elf1_taskrange.split("-");
        elf1_first_task = Integer.parseInt(elf1_tasks[0]);
        elf1_final_task = Integer.parseInt(elf1_tasks[1]);

        String[] elf2_tasks = elf2_taskrange.split("-");
        elf2_first_task = Integer.parseInt(elf2_tasks[0]);
        elf2_final_task = Integer.parseInt(elf2_tasks[1]);
    }
}
