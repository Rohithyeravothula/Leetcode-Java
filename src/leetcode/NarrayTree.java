package leetcode;

public class NarrayTree {
    NarrayNode root;
    NarrayTree(int val){
        this.root = new NarrayNode(val);
    }

    public int getDepth(NarrayNode node){
        if(node == null){
            return 0;
        }
        int depth = 0;
        for(NarrayNode cur: node.children){
            depth = Math.max(getDepth(cur)+1, depth);
        }
        return depth;
    }
}
