package medium;

public class No_0002_AddTwoNumbers {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    public void print(){
      ListNode cur = this;
      while(cur != null){
        System.out.println(cur.val);
        cur = cur.next;
      }
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode ret = null;
    ListNode link = null;
    // WARN || 写成了 &&
    while (l1 != null || l2 != null) {
      /**
       * INFO 比较好的做法，归并不需要跳出，而是如果为空或无效则略过/取单位元（这里就是0，指不影响操作的值）
       * 不要忘记归并的三个部分：1. 取值；2. 计算； 3.前进一步；
       *
        */
      int d1 = l1 == null ? 0 : l1.val;
      int d2 = l2 == null ? 0 : l2.val;
      int sum = d1 + d2 + carry;
      carry = sum >= 10 ? 1 : 0;
      int remainder = sum % 10;
      if (ret == null) {
        ret = new ListNode(remainder);
        link = ret;
      } else {
        link.next = new ListNode(remainder);
        link = link.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry == 1) {
      //WARN 写成了ret.next，比较蠢的错误
      link.next = new ListNode(1);
    }
    return ret;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    ListNode ret = addTwoNumbers(l1, l2);
    ret.print();

  }
}

