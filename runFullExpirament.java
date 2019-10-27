import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class runFullExpirament {



    /* define constants */

    static int numberOfTrials = 10000000;

    static int MAXFIBNUMBERSIZE  = 50;

    static int MINFIBNUMBERSIZE  =  0;

    // static int SIZEINCREMENT =  10000000; // not using this since we are doubling the size each time



    static String ResultsFolderPath = "/home/wyatt/Results/lab5/"; // pathname to results folder

    static FileWriter resultsFile;

    static PrintWriter resultsWriter;

    //function to run full experiment
    static void runFullExperiment(String resultsFileName, fiboInterface fibFunctionRuntimeTesting){


        //trying to write to file and displaying error message if it fails
        try {

            resultsFile = new FileWriter(ResultsFolderPath + resultsFileName);

            resultsWriter = new PrintWriter(resultsFile);

        } catch(Exception e) {

            System.out.println("*****!!!!!  Had a problem opening the results file "+ResultsFolderPath+resultsFileName);

            return; // not very foolproof... but we do expect to be able to create/open the file...

        }


        // instantiating stopwatch class
        threadCpuStopWatch BatchStopwatch = new threadCpuStopWatch(); // for timing an entire set of trials

        threadCpuStopWatch TrialStopwatch = new threadCpuStopWatch(); // for timing an individual trial


        //printing to file
        resultsWriter.println("#InputSize    AverageTime    HowManyBitsInputSizeIs"); // # marks a comment in gnuplot data
        //flushing so it immediately goes to file and not a queue
        resultsWriter.flush();

        // start at fib number 0 and goes to the number in the sequence specified by MAXFIBONUMBERSIZE
        for(int fibNumberAt=MINFIBNUMBERSIZE;fibNumberAt<=MAXFIBNUMBERSIZE; fibNumberAt+=1) {

            // progress message...
            System.out.println("Running test for fibNumberAt "+fibNumberAt+" ... ");

            long batchElapsedTime = 0;

            //forcing garbage collection
            System.gc();

            // run the trials
            for (int trial = 0; trial < numberOfTrials; trial++) {
                TrialStopwatch.start();
                for (int spin = 0; spin < 100000000; spin++)
                {
                    int count = 0;
                    count++;
                }

                fibFunctionRuntimeTesting.fiboFunction(fibNumberAt);
                batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();

            }

            // calculate the average time per trial in this batch
            double averageTimePerTrialInBatch = (double) batchElapsedTime / (double)numberOfTrials;



            /* print data for this size of input */

            resultsWriter.printf("%12d  %15.2f %d\n",fibNumberAt, averageTimePerTrialInBatch, countBits(fibNumberAt));
            //using flush so it immediately writes to file and does not go to queue
            resultsWriter.flush();

            System.out.println(" ....done.");

        }

    }

    // a function to find the amount of bits of x (i. e. find n)
    public static long countBits(long numberToCountBitsOf)
    {
        if(numberToCountBitsOf == 0)
        {
            return 1;
        }
        return (long)(Math.log(numberToCountBitsOf)/Math.log(2)+1);
    }
}
