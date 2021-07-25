package test.java;

import general.likedList.addTwoHugeNumbers;
import general.likedList.ListNode;
import org.junit.jupiter.api.Test;

public class addTwoHugeNumbersTest {
    @Test
    public void test() throws Exception {

        Integer[] aa = {1};
        Integer[] ba = {9999, 9999, 9999, 9999, 9999, 9999};

        System.out.print("aa = [");
        for (int i : aa) System.out.print(i + ", ");
        System.out.print("]");
        System.out.println("");

        System.out.print("ba = [");
        for (int i : ba) System.out.print(i + ", ");
        System.out.print("]");
        System.out.println("");

        ListNode aNode = new ListNode<Integer>(null).fromArray(aa);
        ListNode bNode = new ListNode<Integer>(null).fromArray(ba);

        System.out.print("result node: ");
        ListNode.printNode(new addTwoHugeNumbers().addTwoHugeNumbers(aNode , bNode));
        System.out.println();

    }
}

