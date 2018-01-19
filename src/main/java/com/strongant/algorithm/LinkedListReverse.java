package com.strongant.algorithm;

/**
 * 单链表的反转
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class LinkedListReverse {


    public static void main(String[] args) {

        int count = 9;

        ListNode t = initListNode(count, count);

        ListNode t1 = reverse(t);

        printLinkedList(t1);

    }

    private static ListNode initListNode(int len, int count) {
        ListNode t = new ListNode(1);
        ListNode x = t;
        for (int i = 2; i <= len; i++) {
            x = (x.next = new ListNode(i));
        }
        return t;
    }

    private static void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    /*
单链表反转分析过程：
1->2->3->4

prev = null

curr  = head(值为1的节点)

nextTemp -> next (值为2的节点)

curr.next  = prev(当curr的值为1时，它的next为null)

设置完毕后，将当前节点(值为1的节点)缓存起来，供下一次循环到的节点进行使用

prev -> curr

最后，将当前节点的引用指向 next (值为2的节点)

第一次循环之后，可以得到如下数据：

2-->1-->null

第二次循环

此时，curr是值为2的节点

nextTemp -> next (值为3的节点)

curr.next  = prev(当curr的值为2时，它的next为prev，即：next指向上一次循环时缓存下来的值为1的节点)

再讲prev引用指向当前遍历的值为2的节点，供下一次循环使用,即
prev = curr (值为2的节点)
接着将当前值为2的节点指向值为3的节点

第二次循环之后，结果变为：
3->2->1->null

以此类推，当遍历到节点为4的值时，curr=null，循环结束，具体结果为：
4->3->2->1->null

通过以上的分析，可以深刻理解单链表的反转操作套路。

*/
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //save next node
            ListNode nextTemp = curr.next;
            //change
            curr.next = prev;
            //cache prev node
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


}

class ListNode {

    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
