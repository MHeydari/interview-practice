/*
You're given 2 huge integers represented by linked lists.
Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits.
The represented number might have leading zeros.
Your task is to add up these huge integers and return the result in the same format.

Example:
For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].
Explanation: 987654321999 + 18001 = 987654340000.
For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].
Explanation: 12300040005 + 10001000100 = 22301040105.


 */
package general.likedList;

import java.util.ArrayList;

/*
You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999
that represents a number with exactly 4 digits.
The represented number might have leading zeros.
Your task is to add up these huge integers and return the result in the same format.

Example
For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].
Explanation: 987654321999 + 18001 = 987654340000.

For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].
Explanation: 12300040005 + 10001000100 = 22301040105.

 */


public class addTwoHugeNumbers {

    public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        if (a == null && b == null) return null;
        if (a == null && b != null) return b;
        if (a != null && b == null) return a;

        ArrayList<Integer> aa = new ArrayList<Integer>();
        ArrayList<Integer> ba = new ArrayList<Integer>();

        while (a != null || b != null) {
            if (a != null) aa.add(a.value);
            if (b != null) ba.add(b.value);
            if (a == null) a = null;
            else a = a.next;
            if (b == null) b = null;
            else b = b.next;
        }

        if (aa.size() > ba.size()) {
            int dif = aa.size() - ba.size();
            for (int i = 0; i < dif ; i++) {
                ba.add(0, 0);
            }
        } else if (ba.size() > aa.size()) {
            int dif = ba.size() - aa.size();
            for (int j = 0; j < dif ; j++) {
                aa.add(0, 0);
            }
        }


        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < aa.size(); i++) {
            ar.add(aa.get(i) + ba.get(i));
        }


        for (int i = ar.size() - 1; i >= 0; i--) {
            int temp = ar.get(i);

            if (temp != (temp % 10000)) {
                ar.set(i, temp % 10000);
                if (i - 1 >= 0)
                    ar.set(i - 1, (int) temp / 10000 + ar.get(i - 1));
                else
                    ar.add(0,(int) temp / 10000);
            }
        }

        ListNode<Integer> c = new ListNode<Integer>(ar.get(0));
        final ListNode<Integer> result = c;

        for (int i = 1; i < ar.size(); i++) {
            c.next = new ListNode<Integer>(ar.get(i));
            c = c.next;
        }
        return result;
    }
}