package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class BinaryTree {
    TreeNode root;
    BinaryTree(int a){
        this.root = new TreeNode(a);
    }

    BinaryTree(int[] a){
        this.root = leetcodeTree(a);
    }

    private int getDepth(TreeNode cur){
        if(cur == null)
            return 0;
        return 1+Integer.max(getDepth(cur.left), getDepth(cur.right));
    }

    public int maxDepth(){
        return getDepth(this.root);
    }

    private static TreeNode buildLeetcodeTree(int[] numbers, int i, int l){
        if(i>=l)
            return null;
        TreeNode cur = new TreeNode(numbers[i]);
        cur.left = buildLeetcodeTree(numbers, 2*i+1, l);
        cur.right = buildLeetcodeTree(numbers, 2*i+2, l);
        return cur;
    }

    public static TreeNode leetcodeTree(int[] numbers){
        return BinaryTree.buildLeetcodeTree(numbers, 0, numbers.length);
    }

    private int treeBalenced(TreeNode cur){
        if(cur == null){
            return 0;
        }
        int left = treeBalenced(cur.left);
        if(left == -1)
            return left;
        int right = treeBalenced(cur.right);
        if(right == -1)
            return right;
        int diff = Math.abs(left - right);
        if(diff < 2){
            return 1+Math.max(left, right);
        }
        return -1;
    }

    public boolean isBalanced(){
        return treeBalenced(this.root) != -1;
    }

    public void _invertTree(TreeNode node){
        if(node != null){
            TreeNode leftChild = node.left;
            node.left = node.right;
            node.right = leftChild;
            invertTree(node.left);
            invertTree(node.right);
        }
    }

    public TreeNode invertTree(TreeNode node){
        _invertTree(node);
        return node;
    }

    private int[] getDiameter(TreeNode cur){
        int[] ans = {0,0};
        // diameter, height
        if(cur == null){
            return ans;
        }
        int[] left = getDiameter(cur.left);
        int[] right = getDiameter(cur.right);
        ans[0] = Math.max(left[0], right[0]);
        ans[1] = 1+Math.max(left[1], right[1]);
        ans[0] = Math.max(ans[0], 1+left[1]+right[1]);
        return ans;
    }

    public int getTreeDepth(TreeNode cur){
        if(cur == null)
            return 0;
        int left = getTreeDepth(cur.left);
        int right = getTreeDepth(cur.right);
        max = Math.max(max, left+right);
        return 1+Math.max(left, right);
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getTreeDepth(root);
        return max;
    }

    public void inorder(TreeNode cur, ArrayList<TreeNode> list){
        if(cur != null){
            inorder(cur.left, list);
            list.add(cur);
            inorder(cur.right, list);
        }
    }

    public List<TreeNode> inorder(TreeNode root){
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public TreeNode increasingBST1(TreeNode root) {
        List<TreeNode> inList = inorder(root);
        TreeNode node, cur, head = new TreeNode(-1);
        cur = head;
        for(TreeNode lnode: inList){
            node = new TreeNode(lnode.val);
            cur.right = node;
            cur = cur.right;
        }
        return head;
    }

    public List<TreeNode> buildBST(TreeNode root){
        if(root == null) {
            return null;
        }

        List<TreeNode> ans = new ArrayList<>();
        if(root.left == null && root.right == null){
            ans.add(root);
            ans.add(root);
            return ans;
        }
        else if(root.left == null){
            List<TreeNode> right = buildBST(root.right);
            root.right = right.get(0);
            ans.add(root);
            ans.add(right.get(1));
            return ans;
        }
        else if(root.right == null){
            List<TreeNode> left = buildBST(root.left);
            root.left = null;
            left.get(1).right = root;
            ans.add(left.get(0));
            ans.add(root);
            return ans;
        }
        else{
            List<TreeNode> left = buildBST(root.left);
            List<TreeNode> right = buildBST(root.right);
            root.left = null;
            left.get(1).right = root;
            root.right = right.get(0);
            ans.add(left.get(0));
            ans.add(right.get(1));
            return ans;
        }
    }

    public TreeNode increasingBST(TreeNode root){
        if(root == null)
            return root;
        List<TreeNode> list = buildBST(root);
        return list.get(0);
    }

    public void testIsBalenced(){
        int[] a = {1,2,3,4,5,6,7,8};
        BinaryTree bt = new BinaryTree(a);
        System.out.println(bt.isBalanced());
    }

    private TreeNode buildBST(int[] nums, int left, int right){
        if(left > right)
            return null;
        int mid = (left+right)/2;
        TreeNode curnode = new TreeNode(nums[mid]);
        curnode.left = buildBST(nums, left, mid-1);
        curnode.right = buildBST(nums, mid+1, right);
        return curnode;
    }

    public TreeNode sortedArrayToBST(int[] nums){
        return buildBST(nums, 0, nums.length-1);
    }

    public int sumTwo(int a, int b){
        Stack<String> stack = new Stack<>();
        int ans=0;
        int carry=0;
//        while(a!=0 && b!=0){
            //
//        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
