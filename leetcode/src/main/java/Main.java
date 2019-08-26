import com.logact.tool.ListNode;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author: logact
 * @date: Created in 2019/8/19 14:48
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        head1.next=node1;
        node1.next=node2;
        node2.next=node3;

        ListNode head2=new ListNode(10);
        ListNode node4=new ListNode(11);
        ListNode node5=new ListNode(12);
        ListNode node6=new ListNode(13);
        head2.next=node4;
        node4.next=node5;
        node5.next=node6;

        ListNode res = new ListNode(0);
        ListNode h=res;
        while(head1!=null||head2!=null){
            if(head1==null){
                h.next=head2;
                break;
            }
            if(head2==null){
                h.next=head1;
                break;
            }
            if(head1.val<head2.val){
                h.next=head1;
                h=head1;
                head1=head1.next;
            }else{
                h.next=head2;
                h=head2;
                head2=head2.next;
            }
        }
    }

}
