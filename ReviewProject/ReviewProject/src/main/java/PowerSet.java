
package main.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * A collection of different implementations solving the 
 * same problem of generating a powerset from a given array
 */


public class PowerSet
{
	
	/**
     * Generates a power set from a given array
     * 
     * Returns a NullPointerException when the array is empty
     * Returns all possible sets formed from a given array
     * 
     * @param S the array from which powerset is to be generated
     * @exception NullPointerException if <code>S</code> 
     * is not initialized
     */
    public static void powerSetImplementation1(int[] S) throws NullPointerException
    {
        if(S == null) {
        	throw new NullPointerException();
        }
    	// N stores total number of subsets
        int N = (int)Math.pow(2, S.length);
        Set<String> set = new HashSet<>();

        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            String subset = "";

            // check every bit of i
            for (int j = 0; j < S.length; j++) {
                // if j'th bit of i is set, append S[j] to subset
                if ((i & (1 << j)) != 0) {
                    subset += (S[j]) + " ";
                }
            }

            // insert the subset into the set
            set.add(subset);
        }

        // print all subsets present in the set
        printElements(set);
    }
    
    /**
     * prints all elements from the given Set
     * @param set
     */
    private static void printElements(Set<String> set) 
    {
    	for (String subset: set) {
            System.out.print("[ " + subset + "] ");
        }
    }
    
  
    /**
     * Generates a power set from a given array
     * @param S the array from which powerset is to be generated
     * @exception NullPointerException if <code>S</code> 
     * is not initialized
     */
    public static List<List<Integer>> powerSetImplementation2(int[] myArray) throws NullPointerException
    {

        if (myArray == null) return null;

            Arrays.sort(myArray);

           List<List<Integer>> res = new ArrayList<>();
           List<Integer> each = new ArrayList<>();
           buildSubsets(res, each, 0, myArray);
           return res;
    }
    
    
    /**
     * builds subsets from the given array
     * @param res the result list of list which stores 
     * all the subsets generated
     * @param each is the every subset formed
     * @param pos is the position pointer
     * @param nums is the array we are given from the user
     */
    public static void buildSubsets(List<List<Integer>> res, List<Integer> each, int pos, int[] nums) {
       if (pos <= nums.length) 
       {
           res.add(each);
       }else {
    	   // do nothing
       }
       int i = pos;
       while (i < nums.length) 
       {
           each.add(nums[i]);
           buildSubsets(res, new ArrayList<>(each), i + 1, nums);
           each.remove(each.size() - 1);
           i++;
           while (i < nums.length && nums[i] == nums[i - 1]) {i++;}
       }
       return;
   }
        
        
    /**
     * Generates a power set from a given array
     * @param S the array to from which powerset is to be generated
     * @exception NullPointerException if <code>S</code> 
     * is not initialized
     */
    // implementation 3
        public static Set<Set<Integer>> powerSetImplementation3(int[] S) 
        {
        	if(S == null) 
        	{
        		return new HashSet<Set<Integer>>();
        	}
            List<Integer> arrayList = new ArrayList<Integer>();
            for (int index = 0; index < S.length; index++)
            {
                arrayList.add(S[index]);
            }
            Set<Set<Integer>> ps = new HashSet<Set<Integer>>();
              ps.add(new HashSet<Integer>());   // add the empty set

              // for every item in the original list
              for (Integer item : arrayList) 
              {
                  Set<Set<Integer>> newPs = new HashSet<Set<Integer>>();

                for (Set<Integer> subset : ps) 
                {
                  // copy all of the current powerset's subsets
                  newPs.add(subset);

                  // plus the subsets appended with the current item
                  Set<Integer> newSubset = new HashSet<Integer>(subset);
                  newSubset.add(item);
                  newPs.add(newSubset);
                }

                // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
                ps = newPs;
              }
              return ps;
        }
}
// end of file