package practice.solution;

import practice.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author : Vander
 * @date :   2021/2/22
 * @description : 判断是否是有效的二叉排序树，二叉排序树的特征是根节点大于左子树，小于右子树
 * 解决方法：中序遍历，
 */
public class Solution1 {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        List<Integer> list = new ArrayList<>(inOrderList);
        Collections.sort(list);
        if(list.equals(inOrderList)) {
            HashSet<Integer> set = new HashSet<>(list);
            return list.size() == set.size();
        }
        return false;
    }

    /**
     * 前序遍历
     * @param root
     * @param list
     */
    public static void preOrderTraversal(TreeNode root, List<Integer> list) {
        TreeNode curTreeNode = root;
        if (null == curTreeNode) {
            return;
        }
        list.add(curTreeNode.val);
        preOrderTraversal(curTreeNode.left, list);
        preOrderTraversal(curTreeNode.right, list);
    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    public static void inOrderTraversal(TreeNode root, List<Integer> list) {
        TreeNode curTreeNode = root;
        if (null == curTreeNode) {
            return;
        }
        inOrderTraversal(curTreeNode.left, list);
        list.add(curTreeNode.val);
        inOrderTraversal(curTreeNode.right, list);
    }

    /**
     * 后序遍历
     * @param root
     * @param list
     */
    public static void postOrderTraversal(TreeNode root, List<Integer> list) {
        TreeNode curTreeNode = root;
        if (null == curTreeNode) {
            return;
        }
        postOrderTraversal(curTreeNode.left, list);
        postOrderTraversal(curTreeNode.right, list);
        list.add(curTreeNode.val);
    }

}
