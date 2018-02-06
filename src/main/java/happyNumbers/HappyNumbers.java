package happyNumbers;

import java.lang.Math;
import java.util.*;

/**
 * Happy Numbers
 *
 * @author Rafael Deleuze
 * @version 0.1.0
 */
public class HappyNumbers {

	/**
	 * Will print all the happy numbers between 1 and 1000
	 * @param args unused
	 */
	public static void main(String []args){

		for(int nb=0; nb<=1000; nb+=1){

			if(isHappy(nb)){

				System.out.println(nb);
			}
		}
	}

	/**
	 * Evaluates if the input integer is a Happy Number
	 * See https://en.wikipedia.org/wiki/Happy_number
	 * @param n integer
	 * @return Boolean telling if input is Happy or not
	 */
	public static Boolean isHappy(Integer n){

		if (n<1){

			return false;
		}

		Integer testValue = sumOfSquares(n);

		//loopProofValues will prevent looping. It will hold the known values of the summed squares
        // in order to make stop if the value has already been seen
		List<Integer> loopProofValues = new ArrayList<>();
		loopProofValues.add (testValue);

		boolean solutionFound = false;

		do{
			if (testValue == 1){

				solutionFound = true;
			}
			else{

				testValue = sumOfSquares(testValue);

				if (loopProofValues.contains(testValue)){
					solutionFound = true;
				}

				loopProofValues.add(testValue);
			}
		}while(!solutionFound);

		return (testValue == 1);
	}

    /**
     * Calculates the sum of the squares of all the digits
     * @param n integer
     * @return sum of the squares of every digit in the input n
     */
    public static Integer sumOfSquares(Integer n){

        Integer res = 0;
        while (n > 0) {

            res += ((Double)Math.pow(n%10, 2)).intValue();
            n = n/10;
        }
        return res;
    }
}
