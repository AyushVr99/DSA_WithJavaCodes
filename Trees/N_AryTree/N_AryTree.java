package com.N_AryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N_AryTree {
    static class Node
    {
        int data;
        ArrayList<Node> children;
        public Node(int d)
        {
            this.data=d;
            this.children=new ArrayList<Node>();
        }
    }
    static Node buildTree(int[] values, Node root)
    {
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < values.length; i++)
        {
            if (values[i]== -1)
            {
                st.pop();
            }
            else
            {
                Node node = new Node(values[i]);
                if (st.size() > 0)
                {
                    st.peek().children.add(node);
                }else
                {
                    root = node ;
                }
                st.push(node);
            }
        }
        return root;
    }
    static void display(Node root)
    {
        System.out.print(root.data + "->");
        for (Node n : root.children)
        {
            System.out.print(n.data + " ");
        }
        System.out.println("---");
        for (Node n : root.children)
        {
            display(n);
        }
    }
    static int calculateSize(Node root)
    {
        int s = 0;
        for (Node child : root.children) {
            int internal = calculateSize(child);
            s = s + internal;
        }
        s=s+1;
        return s;
    }
    static int height(Node root)
    {
        int ht =0;
        for (Node child : root.children)
        {
            int h = height(child);
            ht = Math.max(ht,h);
        }
        ht=ht+1;
        return ht;
    }
    static int MaxNodeValue(Node root)
    {
        int max = Integer.MIN_VALUE;
        for (Node child : root.children)
        {
            int m = MaxNodeValue(child);
            max = Math.max(m,max);
        }
        max = Math.max(root.data,max);
        return max;
    }

    static void preorder(Node root)
    {
        System.out.print(root.data + " ");
        for (Node child : root.children)
        {
            preorder(child);
        }
    }
    static void postorder(Node root)
    {
        for (Node child : root.children)
        {
            postorder(child);
        }
        System.out.print(root.data + " ");
    }
    static void levelorder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty())
        {
            Node curr = q.remove();
            if (curr==null)
            {
                System.out.println();
                if (q.isEmpty())
                {
                    break;
                }else
                {
                    q.add(null);
                }
            }else
            {
                System.out.print(curr.data + " ");
                for (Node child : curr.children)
                {
                    q.add(child);
                }
            }

        }
    }

}
