package com.Trees.BST;
import java.util.ArrayList;
import java.util.List;

import static com.Trees.BST.BST.*;

public class Main {
    public static void main(String[] args) {
        int[] nodes = {8,4,2,7,6,10};
        Node root = null;
        //building tree
        for (int i = 0; i < nodes.length; i++)
        {
            root = buildBST(root,nodes[i]);
        }

        //printing inorder to check the increasing order sequence
        inorder(root);

        //search in a bst
        System.out.println(search(root,1));

        //delete in a bst
        delete(root,4);
        inorder(root);


        //path from root to lead nodes
        List<Integer> ans = new ArrayList<>();
        roadtolead(root,ans);

        for (List<Integer> l : list)
        {
            System.out.println(l);
        }
    }
}
