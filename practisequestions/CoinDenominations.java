package practisequestions;


import java.util.*;


/**
 * You are given a list of coin denominations (e.g., [1, 5, 10, 25]). You are also given a total amount (e.g., 11, 13, 4, 65). Your task is to determine
 * the minimum number of coins required to make up the given total amount using any combination of the available denominations.
 * If it is not possible to make up the amount with the given coins, return -1.
 * Note:
 * You may assume you have an infinite supply of each coin denomination.
 * The coin denominations can be changed and are not limited to [1, 5, 10, 25].
 */
public class CoinDenominations {

    private static final List<Integer> minimumSequenceCombination = new ArrayList<>();


    public static void main(String[] args) {

//        int[] denomination = {2, 5, 10, 25};
//        int totalAmount = 57;
//        int totalAmount = 65;
//        int totalAmount = 11;
//        int totalAmount = 13;
//        int totalAmount = 4;

        int[] denomination = {2, 3, 5};
        int totalAmount = 99;
            System.out.println(calculateMinimumCoinDenominations(denomination, 10));
    }


    public static boolean calculateMinimumCoinDenominations(int[] denomination, int totalAmount) {
        int[] sortedDenomination = Arrays.stream(denomination).sorted().toArray();
        List<Integer> sortedDividedList = new ArrayList<>();

        if(totalAmount == 0) return false;

        for (int i = sortedDenomination.length - 1; i >= 0; i--) {
            if (sortedDenomination[i] <= totalAmount) {
                sortedDividedList.add(sortedDenomination[i]);
            }
        }

//        sortedDividedList.forEach(data -> System.out.println("check " + data));

        double divisor;
        int remainder = 0;
        int remainderHolder;

        for (int i = 0; i < sortedDividedList.size(); i++) {
            int z = Math.min(i + 1, sortedDividedList.size() - 1);
            int currentFace = sortedDividedList.get(i);
//            System.out.println("currentFace " + currentFace);
            //case 1 --> Directly divisible by the first biggest element
            if (i == 0) {
                if (totalAmount % currentFace == 0) {
                    setSequence(((double) totalAmount / currentFace), currentFace);
                    break;
                }
            }

            //case 2 combination of the divisor and checking the sequence

            if (i == 0) {
                divisor = Math.floor((double) totalAmount / currentFace);
                remainder = totalAmount % currentFace;
            } else {
                //if the remainder is present in the coinSequence then adding and exiting the loop
                if (sortedDividedList.contains(remainder)) {
                    minimumSequenceCombination.add(remainder);
                    break;
                }
                remainderHolder = remainder;
                divisor = Math.floor((double) remainderHolder / currentFace);
                remainder = remainderHolder % currentFace;
                if (divisor < 1) continue;
                if (remainder == 0) {
                    setSequence(divisor, currentFace);
                    break;
                }
            }
            int checkCondition = Math.min(z+1, sortedDividedList.size()-1);
            //Check for the corner cases like 19,21,31,51......
            if (remainder < sortedDividedList.get(z)) {
               int  tempRemainder = (currentFace + remainder);
                if (tempRemainder % sortedDividedList.get(z) == 0 || tempRemainder % sortedDividedList.get(checkCondition) == 0){
                    divisor = divisor - 1;
                    remainder = (currentFace + remainder);
                }
            }

            setSequence(divisor, currentFace);

        }
        System.out.println("Comb for "+ totalAmount + ": "  + minimumSequenceCombination);
//        minimumSequenceCombination.forEach(test -> System.out.println("All the coins Combination " + test));
        System.out.println("Minimum coin combination " + minimumSequenceCombination.size());

        return minimumSequenceCombination.stream().reduce(0, Integer::sum).equals(totalAmount);

    }

    private static void setSequence(double divisor, int currentFace) {
        for (int k = 0; k < divisor; k++) {
            minimumSequenceCombination.add(currentFace);
        }
    }

}
