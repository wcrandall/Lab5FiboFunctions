public class fibSequenceSlow implements fiboInterface {
    // the slowest version of the fibonucci sequence
    public long fiboFunction(long x)
    {
        // if your finding the 0th element or 1st element return there's no need for calculation simply return x
        if (x <= 1)
        {
            return 1;
        }
        // recursively calling fibonacci sequence
        else
        {
            return fiboFunction(x-1) + fiboFunction(x-2);
        }
    }
}
