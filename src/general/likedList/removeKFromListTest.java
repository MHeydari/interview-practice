package general.likedList;

public class removeKFromListTest {
    public ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if (l == null) {
            return l;
        }
        //handling head-node
        while (l.value == k && l != null) {
            l = l.next;
            if (l == null)
                break;
        }
        if (l == null) {
            return l;
        }
        // handling none head-nodes
        ListNode c = l;
        while (c.next != null) {
            if ((int) (c.next.value) == k) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return l;
    }
}
