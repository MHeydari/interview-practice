package general.likedList;

public class ReverseTheLinkList {
    public ListNode doReverse(ListNode node){
        ListNode current = node;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }
}
