
package main.java;
//PowerSetData.java


import java.util.*;   // for class StringTokenizer



public class PowerSetData {

    public int[] myArray;
    public String algo;

    public PowerSetData(){
        myArray = null;
    }


    // read numbers from input to array myArray
    // duplicates should be removed
    public void initializeArray(String string) throws NumberFormatException,
    NoSuchElementException, NegativeArraySizeException{

            StringTokenizer inputTokens = new StringTokenizer(string);
            String[] RESULT = string.split("\s");

            String str = "";

            int n; // will be the length of myArray
            if (inputTokens.hasMoreTokens()) {
                    n = inputTokens.countTokens();
            } else {
                    throw new NoSuchElementException();
            }

            // define the array of the right length n
            if (n == 1) {

                    // interpret the next number as number of entries and
                    // generate a random vector with entries 1 ... n
                    str = inputTokens.nextToken();
                    n = Integer.valueOf(str).intValue();
                    // may throw NegativeArraySizeException
                    myArray = new int[n];
                    boolean[] tempArray = new boolean[n + 1];
                    RandomNumber randGen = new RandomNumber();
                    int randNr;
                    for (int i = 0; i < n; i++) {
                            do
                                    randNr = randGen.nextIntRand(1, n);
                            while (tempArray[randNr]);
                            tempArray[randNr] = true;
                            myArray[i] = randNr;
                    }
            } else {
                    int [] array = new int[n];
                    int count =0;

                    for (int i = 0; i < n; i++) { // read the n numbers into the array

                            str = RESULT[i];

                            array[i-count] = Integer.valueOf(str).intValue();

                    }
                    myArray = new int[n-count];
                    myArray = Arrays.copyOfRange(array, 0, n-count);


           }
    }




    /**
	 * All methods should have a Javadoc according to STYLE.
	 * @param choice: chosen powerset algorithm, needs to be a number between 0 and 2. If the number is out of range, 2 should be chosen
	 * The attribute algo should always contain the choosen algorithm as string
	 * @return prints the output of the implementation chosen for powerset
	 * @throws Exception as per typical main specifications
	 */
    public void runAlgo(int choice) {
        System.out.println();
        int[] copyOfMyArray = new int[myArray.length];
        System.arraycopy(
                myArray, 0, copyOfMyArray, 0, myArray.length);

        switch (choice) {
        case 0 : {

                    PowerSet.powerSetImplementation1(myArray);
                    break;

                  }
        case 1 : {
                    List<List<Integer>> ans = PowerSet.powerSetImplementation2(myArray);

                    for (List<Integer> item : ans) {
                        System.out.print("[ ");
                        for (Integer item2 : item) {
                            System.out.print(item2 + " ");
                    }
                        System.out.print("]");


                    }
                    break;
        }
        case 2 : {
                    Set<Set<Integer>> ans = PowerSet.powerSetImplementation3(myArray);

                    for (Set<Integer> item : ans) {
                    System.out.print("[ ");
                    for (Integer item2 : item) {
                        System.out.print(item2 + " ");
                        }
                            System.out.print("] ");

                        }


                            break;
                    }
        default:
            List<List<Integer>> ans = PowerSet.powerSetImplementation2(myArray);

                for (List<Integer> item : ans) {
                System.out.print("[ ");
                for (Integer item2 : item) {
                    System.out.print(item2 + " ");
                    }
                        System.out.print("] ");

                    }

                    break;
                }

        }
    }







