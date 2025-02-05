package LinkedList;

/**
 * 插入节点：插在中间、头部、尾部
 * 就这三种位置类型
 */

public class Insert_Node_In_SortedArray {
    //插在中间
    public ListNode insertNode(ListNode head,int insertVal){
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode cur=dummy; //设置指针
        while(cur.next!=null && cur.next.val<=insertVal){ //这里不写等于也可以
            cur=cur.next; //移动
        }
        //停止时，cur的下一位是大于targetValue的，也就是找到插入位置了
        ListNode insertNode=new ListNode(insertVal);
        insertNode.next=cur.next;
        cur.next=insertNode;

        return dummy.next;
    }

    //插在尾部
    public ListNode insertNodeAtEnd(ListNode head,int insertVal){
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode cur=dummy;

        while(cur.next!=null){
            cur=cur.next;
        }
        ListNode insertNode=new ListNode(insertVal);
        cur.next=insertNode;
        insertNode.next=null;

        return dummy.next;

    }
}
