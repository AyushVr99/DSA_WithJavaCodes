package com.Trees.BinaryTree;

public class MyTree {
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int d)
        {
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    static int pointer = -1;
    static Node createTree(int[] nodes)
    {
        pointer++;
        if (nodes[pointer] == -1)
        {
            return null;
        }

        Node node = new Node(nodes[pointer]);
        node.left = createTree(nodes);
        node.right = createTree(nodes);
        return node;
    }
    static void preoder(Node root)
    {
        if (root==null)
        {
            return;
        }
        System.out.print(root.data + " ");
        preoder(root.left);
        preoder(root.right);
    }
    static void inorder(Node root)
    {
        if (root==null)
        {
            return;
        }
        preoder(root.left);
        System.out.print(root.data + " ");
        preoder(root.right);
    }
    static void postorder(Node root)
    {
        preoder(root.left);
        preoder(root.right);
        System.out.print(root.data + " ");
    }
    static void print(Node root)
    {
        printfy(root,"");
    }
    static void printfy(Node root, String space)
    {
        if (root==null)
        {
            return;
        }
        System.out.println(space + root.data);
        printfy(root.left , space+"\t");
        printfy(root.right , space+"\t");
    }
    static int countNodes(Node root)
    {
        if (root==null)
        {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
    static int sumOfNodes(Node root)
    {
        if (root==null)
        {
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left+right+root.data;
    }
    static class info
    {
        int height;
        int diam;
        public info(int h, int d) {
            this.height = h;
            this.diam = d;
        }
    }
    static info diameter2(Node root)
    {
        if (root==null)
        {
            return new info(0,0);
        }
        info left = diameter2(root.left);
        info right = diameter2(root.right);
        int h = Math.max(left.height, right.height) + 1;

        int d = Math.max(left.diam, Math.max(right.diam, (left.height+ right.height+1)));

        return new info(h,d);
    }
}
