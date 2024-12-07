package LinkedList;

public class 203_RemoveLinkedListElements {
    public LinkedList RemoveLinkedListElements(LinkedList head,int target){
    LinkedList dummy=new LinkedList(Integer.MIN_VALUE);
    dummy.next=head;
    LinkedList cur=dummy;
    while(cur.next!=null){
        if(cur.next.val=target){
            cur.next=cur.next.next;
        }else{
            cur=cur.next;
        }
    }
    return dummy.next;
}

}
