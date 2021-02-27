package practice.solution;

import practice.TreeNode;

import java.util.Stack;

/**
 * @author : Vander
 * @date :   2021/2/27
 * @description : 官方解法：在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值
 */
public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
