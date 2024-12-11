package LinkedList;

class solution {
    ListNode RemoveLinkedListElements(ListNode head,int target){
    ListNode dummy=new ListNode(-1);
    dummy.next=head;
    ListNode cur=dummy;
    while(cur.next!=null){
        if(cur.next.val==target){
            cur.next=cur.next.next;
        }else{
            cur=cur.next;
        }
    }
    return dummy.next;
    }

}
