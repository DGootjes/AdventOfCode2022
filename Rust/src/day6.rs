use std::fs;
use std::collections::VecDeque;

pub fn day6()
{
    let data = fs::read_to_string("day6\\input.txt")
        .expect("Unable to read file");
    println!("{}", data);

    find_start_of_packet_marker(&data);
    find_start_of_message(&data);
}


fn find_start_of_message(data: &String)
{
    find_word_unique_size(data,14);
}

fn find_start_of_packet_marker(data: &String)
{
    find_word_unique_size(data,4);
}

fn find_word_unique_size(data: &String, size: usize)
{
    // Parse the data. Create a queue, push string characters in front, remove from back.
    let mut deq = VecDeque::new();
    let mut count: i32 = 0;
    for c in data.chars()
    {
        if deq.len() < size
        {
            deq.push_back(c);
        }
        else
        {
            let bla : String;
            bla = (&deq).into_iter().collect();
            if unique_letters(&bla)
            {
                println!("{}", count);
                println!("{}", bla);
                break;
            }
            else
            {
                deq.pop_front();
                deq.push_back(c);
            }
        }

        count += 1;
    }
}

fn unique_letters(line: &String) -> bool
{
    let mut feasible: bool = true;
    for c in line.chars()
    {
        if line.matches(c).count() > 1
        {
            feasible = false;
        }
    }
    return feasible;
}
