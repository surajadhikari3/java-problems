package practisequestions.streams.should.look.once;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
* Things to understand when to use the Collectors.groupBy
*
* If you want to grp the element based on the certain criteria lets say same address, beginning with same character and more
* Its like putting the element in the bucket based on the certain criteria....
* By default it will collect to the list
*
* and Collectors.toMap --> It will only handle the single value for the single key if there is duplicate key u have to provide the merger function
* not so suitable
*
*  Summary:

Feature	                groupingBy	                                toMap
Purpose  	            Grouping by a key → collection of values	Mapping key to single value
Resulting Map Value	    Usually a List<T> per key (can customize)	One value per key
Duplicate Key Handling	Automatically groups values	                Requires a merge function or throws error
Common use-case	        Group items (e.g., people by age group)	    Map item properties (e.g., name to ID)
*
* */

//for doing the different operation convert the primitive type to the Non-primitive type with the box method.....
public class DivideListEvenAndOdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Map<Boolean, List<Integer>> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x % 2 == 0));
        System.out.println(collect);
    }
}
