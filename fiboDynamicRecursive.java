import java.util.Arrays;

public class fiboDynamicRecursive implements  fiboInterface {

    // wrapper for fiboDynamicRecursive
    public long fiboFunction(long x)
    {
        int convert = (int)x;
        long[] dynamicTable = new long[convert];
        Arrays.fill(dynamicTable, -1);

        long result = fiboDynamicRecursive(x,dynamicTable);

        return result;

    }

    public static long fiboDynamicRecursive(long x, long[] dynamicTable)
    {
        int convert = (int)x - 1;
        // if your finding the 0th element or 1st element return there's no need for calculation simply return x
        if (x <= 1)
        {
            return 1;
        }
        else if (dynamicTable[convert]!=-1)
        {
            return dynamicTable[convert];
        }
        // recursively calling fibonacci sequence
        else
        {
            long result = fiboDynamicRecursive(x-1, dynamicTable) + fiboDynamicRecursive(x-2, dynamicTable);
            dynamicTable[convert] = result;
            return dynamicTable[convert];
        }
    }


}
