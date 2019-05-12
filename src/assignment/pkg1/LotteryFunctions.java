package assignment.pkg1;

//********************************************************************************
// PantherID:  4138075
// CLASS: COP 2210 – Spring 2018
// ASSIGNMENT # 1
// DATE: 1/20/2018
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//********************************************************************************

import java.util.Random;

public class LotteryFunctions
{
    //Declaring constants and variables.
    private static final int LENGTH_OF_FANTASY5 = 5;
    private static final int LENGTH_OF_LOTTERY = 6;
    private static final int MAXIMUM_OF_FANTASY5 = 36;
    private static final int MAXIMUM_OF_LOTTERY = 53;
    private final Random RNG = new Random();
    private final int[] fantasy5_nums = new int[5];
    private final int[] lottery_nums = new int[6];

    //Fill the fantasy5_nums array with random numbers
    public int[] get_fantasy5_nums()
    {
        for (int i = 0; i < LENGTH_OF_FANTASY5; i++)
        {
            fantasy5_nums[i] = 1 + RNG.nextInt(MAXIMUM_OF_FANTASY5);
        } 
        
        //Calling the duplicate checker. 
        check_for_dups(fantasy5_nums, LENGTH_OF_FANTASY5, MAXIMUM_OF_FANTASY5);
        return fantasy5_nums;
    }
    
    //Fill the lottery_nums array with random numbers
    public int[] get_lottery_nums()
    {
        for (int i = 0; i < LENGTH_OF_LOTTERY; i++)
        {
            lottery_nums[i] = 1 + RNG.nextInt(MAXIMUM_OF_LOTTERY);
        }
        
        //Calling the duplicate checker.
        check_for_dups(lottery_nums, LENGTH_OF_LOTTERY, MAXIMUM_OF_LOTTERY);
        return lottery_nums;
    }
    
    //Recursive function used to check and replace duplicates.
    private void check_for_dups(int[] checker, int length_of_array, int maximum_range)
    {
        //Double loop used to look through the entire array and compare them against each value
        for (int i = 0; i < length_of_array; i++)
            for (int j = 1 + i; j < length_of_array; j++)
                if (checker[i] == checker[j])
                {
                    checker[i] = 1 + RNG.nextInt(maximum_range);
                    check_for_dups(checker, length_of_array, maximum_range);                   
                }
    }
}
