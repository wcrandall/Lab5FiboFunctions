import java.util.Scanner;

public class testClass {
    public static fibSequenceSlow fibSlow = new fibSequenceSlow();
    public static fiboDynamicLoop fiboDynamicLoop = new fiboDynamicLoop();
    public static fiboDynamicRecursive fiboDynamicRecursive = new fiboDynamicRecursive();
    public static fiboFastest fiboFastest = new fiboFastest(); 
    
    //longs can only hold up to the 91st fib number so I made an array of all of those. This allows me to ensure the functions values are accurate
    public static long[] allTheFibNumbersLongsCanHold = {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,1134903170,1836311903,2971215073L,4807526976L,7778742049L,12586269025L,20365011074L,32951280099L,53316291173L,86267571272L,139583862445L,225851433717L,365435296162L,591286729879L,956722026041L,1548008755920L,2504730781961L,4052739537881L,6557470319842L,10610209857723L,17167680177565L,27777890035288L,44945570212853L,72723460248141L,117669030460994L,190392490709135L,308061521170129L,498454011879264L,806515533049393L,1304969544928657L,2111485077978050L,3416454622906707L,5527939700884757L,8944394323791464L,14472334024676221L,23416728348467685L,37889062373143906L,61305790721611591L,99194853094755497L,160500643816367088L,259695496911122585L,420196140727489673L,679891637638612258L,1100087778366101931L,1779979416004714189L,2880067194370816120L,4660046610375530309L};
    public static final String FIBODYNAMICLOOP = "FIBODYNAMICLOOP"; 
    public static final String FIBOSLOWRECURSIVE = "FIBOSLOWRECURSIVE"; 
    public static final String TESTFIBODYNAMICRECURSIVE = "FIBODYNAMICRECURSIVE";
    public static final String FIBOQUICKEST = "FIBOQUICKEST"; 
    public static final String EXITTESTING = "EXITTESTING";
    public static final String ENTERPROMPT = "valid inputs are " + TESTFIBODYNAMICRECURSIVE + ", " + FIBODYNAMICLOOP + ", " + FIBOSLOWRECURSIVE + ", " + FIBOQUICKEST + ", " + EXITTESTING
                                               + "\nEnter what kind of testing you want: ";
    public static final String ENTERHOWFARINFIBSEQUENCE = "How far do you want to go in the fibonacci sequence? ";
    public static Scanner scanner = new Scanner(System.in);
    // this function allows the user to decide if they want to test a single fib function or run all and compare results to see if they're the same
    // It is up to user to compare result with fib table to ensure it is actually the correct spot in the fib sequence
    // remember spot 2 in ours would be 3 in normal fibs because 0 in ours is 1
    
    public static void test()
    {

        String userInput = ""; 
        
        while(!userInput.equalsIgnoreCase(EXITTESTING)) {
            // prompting user to enter input and telling them what valid input is 
            System.out.printf(ENTERPROMPT);
            userInput = scanner.nextLine();

            // checks if input is valid if it is it commences with tests
            // if it is not isValidInput = false and we will tell user the input was not valid
            //if the user input Exittesting skip validation testing function and exit testing
            if(!userInput.equalsIgnoreCase(EXITTESTING)) {
                boolean isValidInput = isValidInput(userInput);

                // if input was not valid tell the user
                if (!isValidInput) {
                    System.out.println("Your input is not valid");
                }
            }
            
        }
    }


    public static long workWithFunction(long x, fiboInterface fiboFunctionCalling)
    {
        // looping and testing all numbers in sequence before x and testing x
        // the reason it also tests x even though we use < is because the original fib
        // sequence starts at 0 and ours starts at 1
        // so x in the original = x-1 in ours
        System.out.println("functionResult ArrayResult");
        for(long i = 0; i < x; i++)
        {
            // calling function and storing number found in result
            long result = fiboFunctionCalling.fiboFunction(i);
            // checks if the result our function got is equal to actual fib number
            // the definate fib numbers are stored in a static array in this class
            long checkIfEqual = compareFibFunctionResultWithFibArray(result, i);
            // if the function value was not valid return 0 so the calling function knows the function is not valid
            if(checkIfEqual != 1)
            {
                // tell the user the function is not working correctly
                System.out.println("The function is not working correctly");
                return 0;
            }

        }
        
        
        return 1; 
    }

    // compares the result from the functions I made to the actual fib result to ensure my functions are getting the correct results
    public static long compareFibFunctionResultWithFibArray(long functionResult, long whatValueInFibonacciSequence)
    {
        // comparing number gotten by function to static array of
        // fib numbers to ensure the functions found value is valid
        System.out.printf("%d %13d\n",functionResult,allTheFibNumbersLongsCanHold[(int)whatValueInFibonacciSequence]);
        if(allTheFibNumbersLongsCanHold[(int)whatValueInFibonacciSequence] == functionResult)
        {
            return 1;
        }

        return 0;
    }

    public static long getUserNumberInput()
    {
        // prompting user to enter number
        System.out.printf(ENTERHOWFARINFIBSEQUENCE);
        //getting the number the user wants to go to in sequence
        long whatValueInFibonacciSequence = scanner.nextInt();
        // clearing newline character
        scanner.nextLine();
        return whatValueInFibonacciSequence;
    }

    // this function uses the value found with compareFibFunctionResultWithFibArray to tell
    // the user whether or not the function is working correctly
    public static void validInputCheckIfFunctionWorked(long returnValue, String functionName)
    {
        if(returnValue == 0)
        {
            System.out.println("The input was valid but " + functionName +" is not working properly");
        }
        else{
            System.out.println("the function " + functionName + " is working correctly");
        }
    }

    // this function checks if input is valid
    // if it is it commences with function tests
    public static boolean isValidInput(String userInput)
    {
            // a series of if statements checking to see if user input was valid
            // if it is valid it will get a number from the user
            // the number tests the fib function up to it
            // ex. if 5 is entered
            // the function will find the 1st fib number compare it to the one in the array
            // that is pre found fib numbers in it then it will find the second, third, fourth, and fifth repeating the comparison process
            // if the comparison is invalid 0 will be returned and the user will be told the input was valid but the function is not working correctly
            if(userInput.equalsIgnoreCase(FIBODYNAMICLOOP))
            {
                // getting the number of how far into the fib sequence the user wants to go and test
                long howFarInTheSequenceToTest = getUserNumberInput();

                // testing the return value will be 0 if the function didn't work and 1 if it did
                long returnValue = workWithFunction(howFarInTheSequenceToTest,fiboDynamicLoop);

                // telling user whether or not the function worked correctly
                validInputCheckIfFunctionWorked(returnValue, userInput);

                // returning to main whether or not the user's input was valid
                return true;
            }
            // see first if statement in series for explanation of what is happening
            else if(userInput.equalsIgnoreCase(FIBOSLOWRECURSIVE))
            {
                long howFarInTheSequenceToTest = getUserNumberInput();
                long returnValue = workWithFunction(howFarInTheSequenceToTest,fibSlow);
                validInputCheckIfFunctionWorked(returnValue, userInput);
                return true; 
            }
            // see first if statement in series for explanation of what is happening
            else if(userInput.equalsIgnoreCase(TESTFIBODYNAMICRECURSIVE))
            {
                long howFarInTheSequenceToTest = getUserNumberInput();
                long returnValue = workWithFunction(howFarInTheSequenceToTest,fiboDynamicRecursive);
                validInputCheckIfFunctionWorked(returnValue, userInput);
                return true;
            }
            // see first if statement in series for explanation of what is happening
            else if(userInput.equalsIgnoreCase(FIBOQUICKEST))
            {
                long howFarInTheSequenceToTest = getUserNumberInput();
                long returnValue = workWithFunction(howFarInTheSequenceToTest,fiboFastest);
                validInputCheckIfFunctionWorked(returnValue, userInput);
                return true; 
            }
            // the input was not valid return false
            else
            {
                return false; 
            }
    }

}
