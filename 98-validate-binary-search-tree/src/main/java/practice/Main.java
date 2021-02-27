package practice;

import practice.solution.Solution1;

import java.util.*;

/**
 * @author : Vander
 * @date :   2021/2/22
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTree(nums);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValidBST(root));
        nums = new int[]{10, 7, 15, 5, 8, 12, 18};
        root = buildTree(nums);
        System.out.println(solution1.isValidBST(root));
        nums = new int[]{10, 10};
        root = buildTree(nums);
        System.out.println(solution1.isValidBST(root));
    }

    /**
     * 输出前序、中序、后序、层序的结果
     *
     * @param root
     */
    public static void traversal(TreeNode root) {
        ArrayList<Integer> preOrderList = new ArrayList<>();
        Solution1.preOrderTraversal(root, preOrderList);
        System.out.println(preOrderList);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        Solution1.inOrderTraversal(root, inOrderList);
        System.out.println(inOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        Solution1.postOrderTraversal(root, postOrderList);
        System.out.println(postOrderList);
        levelOrderTraversal(root);
    }

    public static TreeNode buildTree(int[] nums) {
        Queue<Integer> numsQueue = new LinkedList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        for (int num : nums) {
            numsQueue.offer(num);
        }
        // 放入根节点
        TreeNode root = new TreeNode(numsQueue.poll());
        tempQueue.offer(root);
        while (!numsQueue.isEmpty()) {
            TreeNode curTreeNode = tempQueue.poll();
            if (!numsQueue.isEmpty()) {
                curTreeNode.left = new TreeNode(numsQueue.poll());
                tempQueue.offer(curTreeNode.left);
            }
            if (!numsQueue.isEmpty()) {
                curTreeNode.right = new TreeNode(numsQueue.poll());
                tempQueue.offer(curTreeNode.right);
            }
        }
        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.print(curNode.val + " ");
            if (null != curNode.left) {
                queue.offer(curNode.left);
            }
            if (null != curNode.right) {
                queue.offer(curNode.right);
            }
        }
        System.out.println();
    }

}
