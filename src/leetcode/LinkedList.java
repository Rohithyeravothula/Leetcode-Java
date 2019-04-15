package leetcode;

import java.util.HashSet;

public class LinkedList {
    ListNode head;
    LinkedList(){};

    LinkedList(int val){
        this.head = new ListNode(val);
    }

    LinkedList(int[] a){
        this.head = buildList(a);
    }

    public ListNode buildList(int[] a){
        int l = a.length;
        if(l==0)
            return null;
        ListNode prev, cur, head = new ListNode(a[0]);
        prev = head;
        for(int i=1;i<l;i++){
            cur = new ListNode(a[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev=null, cur=head, next=head.next;
        while(cur!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode tmp, cur = ans;
        while(l1 != null || l2 != null){
            if(l1 == null || (l2 != null && l1.val > l2.val)){
                tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = null;
        }
        return ans.next;
    }

    public static ListNode mergeTowListRecr(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        Integer a = 4;
        return null;
    }

    // reverse rest of linked list, cur node reverse head, next node
    public ListNode reverseRecur(ListNode node){
        if(node.next == null)
            return node;
        ListNode cur = node, next = node.next;
        ListNode reverseHead = reverseRecur(next);
        next.next = cur;
        cur.next = null;
        return reverseHead;
    }

    public static void printList(ListNode root){
        StringBuffer sb = new StringBuffer();
        while(root != null){
            sb.append(root.val);
            sb.append("->");
            root = root.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public void printList(){
        printList(this.head);
    }

    public boolean hasCycle1(ListNode head){
        HashSet<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(seen.contains(cur))
                return true;
            seen.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head, slow = head, next;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        next = slow.next;
        slow.next=null;
        slow = reverseList(next);
        fast = head;
        while(slow != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,5,2,1};
        LinkedList linkedList = new LinkedList(a);
        System.out.println(linkedList.isPalindrome(linkedList.head));
    }
}
