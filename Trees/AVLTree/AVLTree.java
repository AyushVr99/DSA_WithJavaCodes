public class AVLTree {
    public static class Node
    {
        int data;
        int height;
        Node left;
        Node right;
        public Node(int d)
        {
            this.data=d;
            this.height = 0;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;

    public AVLTree(){
        this.root = null;
    }



    public void build(int val){
        root = buildTree(root, val);
    }
    private Node buildTree(Node root, int val)
    {
        if (root==null)
        {
            return new Node(val);
        }
        if (root.data > val )
        {
            root.left = buildTree(root.left,val);
        }else
        {
            root.right = buildTree(root.right,val);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balanceTree(root);
    }

    private Node balanceTree(Node node){
        if(height(node.left) - height(node.right) > 1){
            //Height of left part is more
            if (height(node.left.left) - height(node.left.right) > 0){
                //Left-Left Insertion --- Rotate Left
                return rightRotate(node);
            }
            else if(height(node.left.left) - height(node.left.right) < 0){
                //Left-Right Insertion --- Rotate Left then Right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        else if(height(node.left) - height(node.right) < -1){
            //Height of right part is more
            if (height(node.right.left) - height(node.right.right) > 0){
                //Right-Left Insertion --- Rotate Right then Left
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            else if(height(node.right.left) - height(node.right.right) < 0){
                //Right-Right Insertion --- Rotate Right
                return leftRotate(node);
            }
        }
        return node;
    }
    private Node rightRotate(Node parent){
        Node childPart = parent.left;
        Node childOfChildPart = childPart.right;

        childPart.right = parent;
        parent.left = childOfChildPart;

        //update their heights
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        childPart.height = Math.max(height(childPart.left), height(childPart.right)) + 1;

        return childPart;
    }
    private Node leftRotate(Node child){
        //do opposite of right rotate
        Node parent = child.right;
        Node parentLeftPart = parent.left;

        parent.left = child;
        child.right = parentLeftPart;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return parent;
    }


    public int getHeight(){
        return height(root);
    }

    private int height(Node node){
        if (node==null)
        {
            return -1;
        }
        return node.height;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 1; i <= 32; i++) {
            avlTree.build(i);
        }
        System.out.println(avlTree.getHeight());
    }
}
