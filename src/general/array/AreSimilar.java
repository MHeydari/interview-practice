/*
        Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.
        Given two arrays a and b, check whether they are similar.

        Example:
        For a = [1, 2, 3] and b = [1, 2, 3], the output should be
        areSimilar(a, b) = true.
        The arrays are equal, no need to swap any elements.
        For a = [1, 2, 3] and b = [2, 1, 3], the output should be
        areSimilar(a, b) = true.
        We can obtain b from a by swapping 2 and 1 in b.
        For a = [1, 2, 2] and b = [2, 1, 1], the output should be
        areSimilar(a, b) = false.
        Any swap of any two elements either in a or in b won't make a and b equal.
        Input/Output
        [execution time limit] 3 seconds (java)
        [input] general.array.integer a
        Array of integers.

        Guaranteed constraints:
        3 ≤ a.length ≤ 105,
        1 ≤ a[i] ≤ 1000.

        [input] general.array.integer b
        Array of integers of the same length as a.

        Guaranteed constraints:
        b.length = a.length,
        1 ≤ b[i] ≤ 1000.
        [output] boolean

        true if a and b are similar, false otherwise.
*/
        package general.array;

import java.util.Map;
import java.util.TreeMap;

public class AreSimilar {

    boolean areSimilar(int[] a, int[] b) {
        if(a.length != b.length) return false;

        TreeMap<Integer , Integer> a_map = new TreeMap<Integer, Integer>();
        TreeMap<Integer , Integer> b_map = new TreeMap<Integer, Integer>();
        int i=0;
        boolean found = false;
        int cnt = 0;

        for(i = 0; i< a.length; i++){
            if(a[i] != b[i]){
                a_map.put(i, a[i]);
                b_map.put(i, b[i]);
                cnt ++;
                if(cnt > 2) return false;
            }

        }

        //cheking values
        found = false;
        for(Map.Entry<Integer, Integer> aEntry : a_map.entrySet()){
            for(Map.Entry<Integer, Integer> bEntry : b_map.entrySet()){
                if(aEntry.getValue().equals(bEntry.getValue())) found = true;;
            }
            if(!found) return false;
            found = false;
        }


        if(a_map.keySet().size() == 0) return true;
        if(a_map.keySet().size() > 2) return false;

        if(a_map.keySet().size() == 1){
            int distance = Math.abs( (int)a_map.keySet().toArray()[0] - (int) b_map.keySet().toArray()[0]);
            return distance == 1;
        }
        //key size == 2
        if(a_map.keySet().size() == 2){
            int a1_to_b1_distance = Math.abs( (int)a_map.keySet().toArray()[0] - (int) b_map.keySet().toArray()[0]);
            int a2_to_b2_distance = Math.abs( (int)a_map.keySet().toArray()[1] - (int) b_map.keySet().toArray()[1]);
            int a_elemants_distance = Math.abs( (int)a_map.keySet().toArray()[0] - (int) a_map.keySet().toArray()[1]);
            int b_elemants_distance = Math.abs( (int)b_map.keySet().toArray()[0] - (int) b_map.keySet().toArray()[1]);
            return  a1_to_b1_distance  == 0 & a2_to_b2_distance == 0 & (a_elemants_distance == b_elemants_distance) ;
        }
        return false;
    }
}
