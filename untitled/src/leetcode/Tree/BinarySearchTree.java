package leetcode.Tree;

import java.util.*;

public class BinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public void insert(int val) {
        insertRec(root, val);
    }

    public TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        if (val < root.val)
            root.left = insertRec(root.left, val);
        else
            root.right = insertRec(root.right, val);

        return root;
    }

    public int getMin() {
        TreeNode minNode = getMinRec(root);
        return minNode.val;
    }

    public TreeNode getMinRec(TreeNode root) {
        if (root.left != null) {
            root = getMinRec(root.left);
        }
        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public void deleteNode(int val) {
        if (root.val == val)
            root = root.left;
        else
            deleteNodeRec(root, val);
    }

    public TreeNode deleteNodeRec(TreeNode root, int val) {
        if (root.val < val)
            root.right = deleteNodeRec(root.right, val);
        else if (root.val > val)
            root.left = deleteNodeRec(root.left, val);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            else {
                int deleteVal = getMinRec(root.right).val;
                root.val = deleteVal;
                root.right = deleteNodeRec(root.right, val);
            }
        }
        return root;
    }

    //https://leetcode.com/problems/validate-binary-search-tree/description/
    //important : the prev node should be outside the method.
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (prev != null && prev.val >= root.val)
            return false;
        prev = root;

        return isValidBST(root.right);
        //return true;
    }

    //Lowest Common Ancestor of a BST (235)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int siz = queue.size();
            for (int i = 0; i < siz; i++) {
                TreeNode cur = queue.poll();
                levelValues.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(levelValues);
        }
        return res;
    }
   // Serialize and Deserialize Binary Tree leetcode (297)
    public String serialize(TreeNode root) {
        String s = "";
        serializeHelper(root, s);
        return s;
    }

    void serializeHelper(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
            return;
        }
        s += root.val + ",";
        serialize(root.left);
        serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deSerializeHelper(queue);
    }
//
    public TreeNode deSerializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val == "null")
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deSerializeHelper(queue);
        root.right = deSerializeHelper(queue);

        return root;
    }
}
