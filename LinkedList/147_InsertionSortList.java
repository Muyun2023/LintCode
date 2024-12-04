package LinkedList;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        //dummy.next=head; 为什么不能这么写，非常重要!
        //dummy目前是指向null的，和原本的链表尚未有任何关系，我们本身就是要两者分开的，原链表的节点取过来，在dummy这边重新排序和形成新的链表
        ListNode pre=dummy;
        ListNode cur=head;

        while(cur!=null){
            ListNode next=cur.next;
            // 这里pre.next!=null非常重要，因为原链表head节点是第一个过来dummy这边进行判断的
            // 不写这个，首先会报错，因为pre.next.val<cur.val中pre.next=null，无法比较
            // 其次，写了这个，就会跳出while循环，先把head节点进行安置，成为dummy这边新的head（暂时head）
            while(pre.next!=null && pre.next.val<cur.val){
                pre=pre.next; //pre指针一直在移动遍历
            }
            cur.next=pre.next; 
            pre.next=cur;

            pre=dummy; //pre指针回归到dummy位置
            cur=next; //cur指针移动到下一个节点
        }
        return dummy.next;  
    }
}
/**Java 的对象引用机制
在 Java 中，pre 和 dummy 其实是引用类型变量，它们都指向了同一个 ListNode 对象。
pre = dummy 的含义是：pre 和 dummy 指向了相同的内存地址。
因此，当通过 pre 修改该对象的属性（如 pre.next），实际上修改的是 dummy 所指向对象的属性。
*/

