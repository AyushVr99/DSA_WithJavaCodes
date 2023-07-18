package com.N_AryTree;

import static com.N_AryTree.N_AryTree.*;

public class Main {
    public static void main(String[] args) {
        int[] values = {10,1,3,-1,5,-1,7,-1,-1,2,4,5,-1,-1,-1,9,-1,15,22,-1,23,-1,24};
        Node root = null;
        root = buildTree(values,root);
//        display(root);

//        System.out.println(calculateSize(root));

//        System.out.println(height(root));
//        System.out.println(MaxNodeValue(root));
//        preorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
        levelorder(root);
    }
}
