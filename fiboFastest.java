public class fiboFastest implements fiboInterface {
    public static void matrixMult(long[][] base, long[][] factor)
    {
        /*
         * [[0][0]][[0][1]]
         * [[1][0]][[1][1]]
         *  is the starting matrix */

        //finding the top left corner
        long hold = base[0][0] * factor[0][0];
        long hold2 = base[0][1] * factor[1][0];
        long topLeft = hold + hold2;

        //finding the top right corner
        hold = base[0][0] * factor[0][1];
        hold2 = base[0][1] * factor[1][1];
        long topRight = hold + hold2;

        // finding the bottom left of the matrix
        hold = base[1][0] * factor[0][0];
        hold2 = base[1][1] * factor[1][0];
        long bottomLeft = hold + hold2;

        //finding the bottom right of the matrix
        hold = base[1][0] * factor[0][1];
        hold2 = base[1][1] * factor[1][1];
        long bottomRight = hold + hold2;


        // putting all values in matrix
        base[0][0] = topLeft;
        base[0][1] = topRight;
        base[1][0] = bottomLeft;
        base[1][1] = bottomRight;

    }

    public long fiboFunction(long x)
    {
        // base cases
        if(x == 0 || x == 1)
        {
            return 1;
        }

        // the base matrix
        long[][] base = {{1, 1}, {1, 0}};

        // make an an array to store result
        long[][] result = new long[2][2];

        // setting index to x
        long i = x;

        // create varaible to use in if statement
        // like the log(n) pow function the first time through result must = base but there's not
        // an equivalent of 1 * base in matrices atleast that I know of so I made this variable to set result = base the first time there is an odd
        // the rest of the times through it matrix multiplies result by base to keep track of the odd powers
        long j = 0;
        // a loop to do arithmetic in
        while (i > 0)
        {
            // if i is even we multiply the base * base
            // j = i/2;  base = x ** j
            // (x**i/2) * (x**i/2) = x**i
            // using basic algebra we easily cut out half of the steps
            if (i % 2 ==0)
            {
                matrixMult(base, base);
                i = i/2;
            }
            else
            {

                if(j == 0)
                {
                    equalizeMatrix(result, base);
                    i--;
                }
                else {
                    matrixMult(result, base);
                    i--;
                }
                j++;

                // if i is greater than 1 after the decrement we multiply base * base and divide i by 2
                if (i > 1) {
                    matrixMult(base,base);
                    i = i / 2;
                }
            }
        }

        return result[0][0];
    }

    // simple double for loops to print matrix
    static void printMatrix(long[][] matrix)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix.length;j++)
            {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    // simple double for loop to do the operation matrix = matrixTwo (i. e. matrix <- matrixTwo)
    static void equalizeMatrix(long[][] matrix, long[][] matrixTwo)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix.length;j++)
            {
                matrix[i][j] = matrixTwo[i][j];
            }

        }
    }
}
