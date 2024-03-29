package main.java;

/**
 *  The <code>RandomNumber</code> class  offers facilities 
 *  for pseudorandom number generation.
 *  <p>
 *  An instance of this class is used to generate a stream of 
 *  pseudorandom numbers. The class uses a long seed, which is 
 *  modified using a linear congruential formula. See <ul>
 *  <li>Donald Knuth, <i>The Art of Computer Programming, 
 *  Volume 2</i>, Section 3.2.1. for general information about
 *  random number gerneration and 
 *  <li>S. Park and K. Miller, Random number generators: Good
 *  ones are hard to find, <i>Comm. ACM</i> 31 (1988) 1192-1201 
 *  for the specific one implemented here.  
 *  </ul>
 *  @see java.util.Random
 *  @see java.lang.Math#random()
 */
public class RandomNumber {
        private static final long MULTIPLIER = 16807;
        private static final long MODULUS =  2147483647;
        // Quotient of MODULUS / MULTIPLIER
        private static final long QUOT = 127773; 
        // Remainder of MODULUS / MULTIPLIER
        private static final long REM  = 2836;   

        /**
         * The current seed of the generator. 
         */
        private long CURRENTSEED;
    
        /**
         * Constructs a RandomNumber object and initializes it
         * with <code>System.currentTimeMillis()</code>
         */
        public RandomNumber() {
                CURRENTSEED = System.currentTimeMillis() % MODULUS;
        }
    
        /**
         * Constructs a RandomNumber object and initializes it
         * with the value <code>seed</code>
         * @param seed A value that permits a controlled 
         * setting of the start seed.
         */
        public RandomNumber(long seed) {
                CURRENTSEED = Math.abs(seed) % MODULUS;
        }
                
        
        /**
         * Generates the next random number in the interval [0,1]
         * @return The next random number in [0,1].
         */
        public double nextDoubleRand() {
                long temp = MULTIPLIER*(CURRENTSEED%QUOT) - 
                                REM*(CURRENTSEED/QUOT);
                CURRENTSEED = (temp > 0) ? temp : temp + MODULUS;
                return (double) CURRENTSEED / (double) MODULUS;
        }
        
        /**
         * Generates a random int value between the given limits.
         * @param lo The lower bound.
         * @param hi The upper bound.
         * @return An integer value in {lo,...,hi}
         * @throws InvalidOperationException if lo > hi     
         */
        public int nextIntRand(int lo, int hi) 
                                throws InvalidOperationException {
                if (lo > hi)
				{
                        throw new InvalidOperationException(
                           "invalid range: " + lo + " > " + hi);
				}
                return (int) (nextDoubleRand() * (hi - lo + 1)  + lo);
        }
}

