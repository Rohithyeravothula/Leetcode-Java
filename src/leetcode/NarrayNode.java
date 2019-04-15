package leetcode;

import java.util.Collections;
import java.util.List;

public class NarrayNode {
    int val;
    List<NarrayNode> children;
    NarrayNode(int val){
        this.val = val;
        children = Collections.emptyList();
    }
}
