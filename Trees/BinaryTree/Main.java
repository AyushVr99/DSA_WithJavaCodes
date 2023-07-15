package com.Trees.BinaryTree;

import static com.Trees.BinaryTree.MyTree.*;

public class Main {
    public static void main(String[] args) {
        int[] nodes = {2,5,4,-1,-1,3,-1,-1,10,-1,-1};
        MyTree.Node root = createTree(nodes);

        //preorder
//        preoder(root);
//        System.out.println();
//        //inoder
//        inorder(root);
//        System.out.println();
//        //postorder
//        postorder(root);
//        System.out.println();
//
//        //printing tree
//        print(root);
//        //counting the number of nodes present in the tree
//        System.out.println(countNodes(root));
//        //calculating the total sum of nodes
//        System.out.println(sumOfNodes(root));

        //height and diameter of a tree
        System.out.println( "Diameter is: " + diameter2(root).diam);
        System.out.println("Height is: " + diameter2(root).height);
    }
}
