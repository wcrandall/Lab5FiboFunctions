public class myPow {

    public static long myPow(long x, int powerRaisingXTo)
    {

        long base = x;
        // initialize result to one so it will skip loop and return one if powerRaisingXTo is 0
        long result = 1;
        long i = powerRaisingXTo;

        // a loop to do arithmetic in
        while (i > 0)
        {
            // if i is even we multiply the base * base
            // j = i/2;  base = x ** j
            // (x**i/2) * (x**i/2) = x**i
            // using basic algebra we easily cut out half of the steps
            if (i % 2 ==0)
            {
                base = base * base;
                i = i/2;
            }
            else
            {
                // if the value of i is odd we make it even and multiply by the base once to make up for the odd we decrement
                result = result * base;
                i--;

                // if i is greater than 1 after the decrement we multiply base * base and divide i by 2
                if (i > 1) {
                    base = base * base;
                    i = i / 2;
                }
            }
        }
        return result;
    }
}
