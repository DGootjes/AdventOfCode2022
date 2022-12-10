import java.util.ArrayList;

public class TopList {
    public ArrayList<Double> list;
    private int Size = 0;
    public TopList(int Size)
    {
        list = new ArrayList<Double>();
        this.Size = Size;
        for (int i=0; i < Size; i++)
        {
            list.add(0.0);
        }
    }
    public void TryAdd(double Number)
    {
        // Is Number larger than ANY of them?
        for (int i=Size-1; i >= 0; i--)
        {
            if (list.get(i) < Number)
            {
                list.remove(0);
                list.add(i, Number);
                break;
            }
        }
    }
    public Double Sum(int Top)
    {
        double Sum = 0.0;
        for (int i=Size-1; i >= Size - Top; i--)
        {
            Sum += list.get(i);
        }
        return Sum;
    }
}
