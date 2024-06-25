import java.util.ArrayList;
import java.util.List;

public class LinkedListToBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> ll = new ArrayList<>();
        while (head != null) {
            ll.add(head.val);
            head = head.next;
        }
        return buildBST(0, ll.size() - 1, ll);
    }

    public TreeNode buildBST(int lo, int hi, List<Integer> nums) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildBST(lo, mid - 1, nums);
        root.right = buildBST(mid + 1, hi, nums);

        return root;
    }
}
