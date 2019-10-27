import java.io.InputStream;
import java.util.Scanner;


public class main {


    //creating instance of the classes that hold fib functions
    public static fibSequenceSlow fibSlow = new fibSequenceSlow();
    public static fiboDynamicLoop fiboDynamicLoop = new fiboDynamicLoop();
    public static fiboDynamicRecursive fiboDynamicRecursive = new fiboDynamicRecursive();
    public static fiboFastest fiboFastest = new fiboFastest();

    public static final String EXIT = "exit";
    public static final String TESTPROMPT = "Enter how far in the sequence you want to go: ";
    public static final String TESTFUNCTIONS = "function tests";
    public static final String RUNTIMETESTS = "runtime tests";
    public static final String FUNCTIONORRUNTIMETESTS = "Would you like to do function tests, runtime tests, or exit? ";
    public static final String VALIDINPUTSARE = "Your input is invalid \nValid inputs are function tests, runtime tests, or exit";
    public static final String RUNTIMETESTSCOMPLETE = "runtime tests are completed";


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String whatUserWantsToDo = "";

        while (!whatUserWantsToDo.equalsIgnoreCase(EXIT)) {

            System.out.print(FUNCTIONORRUNTIMETESTS);
            whatUserWantsToDo = scanner.nextLine();

            // a series of statements that will test functions if the user wants
            // or it will do runtime testing, or it will prompt them with valid inputs if what they typed was invalid
            if (whatUserWantsToDo.equalsIgnoreCase(TESTFUNCTIONS)) {
                testClass.test();
            } else if (whatUserWantsToDo.equalsIgnoreCase(RUNTIMETESTS)) {
                // this function calls the testing function 3 times so we get three data files
                // multiple calls optimizes our results
                // I'm doing this for each fib function
                //callingTesterThreeTimesForOptimizedResults(testClass.FIBOSLOWRECURSIVE,fibSlow);
                callingTesterThreeTimesForOptimizedResults(testClass.FIBODYNAMICLOOP, fiboDynamicLoop);
                callingTesterThreeTimesForOptimizedResults(testClass.TESTFIBODYNAMICRECURSIVE,fiboDynamicRecursive);
                callingTesterThreeTimesForOptimizedResults(testClass.FIBOQUICKEST, fiboFastest);
                System.out.println(RUNTIMETESTSCOMPLETE);

            } else if (!whatUserWantsToDo.equalsIgnoreCase(EXIT)) {
                System.out.println(VALIDINPUTSARE);
            }
        }

        System.exit(0);
    }


    public static void callingTesterThreeTimesForOptimizedResults(String functionName,fiboInterface functionRunTimeChecking) {
        for(int i = 0; i < 3; i++)
        {
            runFullExpirament.runFullExperiment(functionName + "exp" + i + ".txt",functionRunTimeChecking);
        }

    }
}