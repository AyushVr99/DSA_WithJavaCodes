package com.Trees.BST;

import java.util.*;

public class BST {
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

    static Node buildBST(Node root, int val)
    {
        if (root==null)
        {
            return new Node(val);
        }
        if (root.data > val )
        {
            root.left = buildBST(root.left,val);
        }else
        {
            root.right = buildBST(root.right,val);
        }
        return root;
    }
    static void inorder(Node root)
    {
        if (root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static boolean search(Node root, int target)
    {
        if(root==null)
        {
            return false;
        }
        if (root.data==target)
        {
            return true;
        }
        if (root.data > target)
        {
            return search(root.left,target);
        }
        return search(root.right, target);
    }

    static Node delete(Node root, int target)
    {
        if (root.data > target)
        {
            root.left = delete(root.left,target);
        }
        else if (root.data < target)
        {
            root.right = delete(root.right,target);
        }
        else
        {
            if (root.left == null && root.right==null)
            {
                return null;
            }
            else if (root.left ==null)
            {
                return root.right;
            }
            else if (root.right ==null)
            {
                return root.left;
            }
            else
            {
                Node is = inorderSuceesor(root.right);
                root.data=is.data;
                root.right = delete(root.right,is.data);
            }
        }
        return root;
    }
    static Node inorderSuceesor(Node root)
    {
        while (root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    static List<List<Integer>> list = new ArrayList<>();
    static void roadtolead(Node root, List<Integer> ans)
    {
        if (root==null)
        {
            return;
        }
        ans.add(root.data);
        if (root.left == null && root.right ==null)
        {
            list.add(new ArrayList<>(ans));
        }
        else
        {
            roadtolead(root.left,ans);
            roadtolead(root.right,ans);
        }
        ans.remove(ans.size()-1);
    }
}
