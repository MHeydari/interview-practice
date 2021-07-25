package general.likedList;

// Singly-linked lists are already defined with this interface:
public class ListNode<T> {
    public ListNode<T> fromArray(T[] arr){
        ListNode<T> tmpNode = new ListNode<T>(arr[0]);
        final ListNode<T> f = tmpNode;
        for(int i=1; i< arr.length ; i++){
            tmpNode.next = new ListNode<>(arr[i]);
            tmpNode = tmpNode.next;
        }
        return f;
    }

    public static void printNode(ListNode node){
        System.out.print('[');
        while(node != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.print(']');
    }

    public ListNode(T x) {
        value = x;
    }

    public T value;
    public ListNode<T> next;
}
