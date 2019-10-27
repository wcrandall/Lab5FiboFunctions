public class fiboDynamicLoop implements fiboInterface {
    public long fiboFunction(long x)
    {
        //initializing first values of fibonacci sequence
        long valueNMinusOne = 1;
        long valueNMinusTwo = 0;
        long value = 0;

        // if it is one of the first two values in fibonacci sequence (i.e 0 or one return 1)
        // this is because we're starting at 1 rather than 0 in the sequence as the instructions indicate
        if(x <= 1)
        {
            return 1;
        }
        else {
            /* if the value entered into this function is not 0 or 1
             * we will loop x times to get the xth term
             * the loop calculates the new value from the previous two values
             * we have that the previous two values at the start are 0 and 1 since the 0th term = 1
             * we then move valueNMinus one to valueNMinusTwo and store the new value in it
             * this prepares us for finding the next value */
            for (long i = 0; i < x; i++) {
                value = valueNMinusOne + valueNMinusTwo;
                valueNMinusTwo = valueNMinusOne;
                valueNMinusOne = value;
            }
        }


        return value;
    }
}
