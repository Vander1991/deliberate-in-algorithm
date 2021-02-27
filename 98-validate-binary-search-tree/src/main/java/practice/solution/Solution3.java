package practice.solution;

import practice.TreeNode;

/**
 * @author : Vander
 * @date :   2021/2/27
 * @description : 官方解法：设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以 root 为根的子树，判断子树中所有节点
 * 的值是否都在 (l,r)(l,r) 的范围内（注意是开区间）。如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，否则我们要继
 * 续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
 *
 * 那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 upper 改为 root.val，即调用 helper(root.left, lower, root.val)，因为
 * 左子树里所有节点的值均小于它的根节点的值。同理递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val, upper)。
 *
 * 函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。
 *
 */
public class Solution3 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 左子树要比root小，右子树要比root大
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
