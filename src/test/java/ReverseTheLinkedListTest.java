package test.java;

import general.likedList.ListNode;
import general.likedList.ReverseTheLinkList;
import general.likedList.addTwoHugeNumbers;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;

public class ReverseTheLinkedListTest {
    @Test
    public void test() throws Exception {

        Integer[] a = {1, 2, 3, 3,4,5};
        ListNode<Integer> node = new ListNode<Integer>(null).fromArray(a);
        ListNode.printNode(node);
        System.out.println();
        ListNode rNode = new ReverseTheLinkList().doReverse(node);
        ListNode.printNode(rNode);

    }
}

