package src;

class Node{

    int data;
    Node left, right;
    public Node(int value){
        data = value;
        left = right = null;
    }
}

public class LCATree {

    Node root;

    Node findLCA(int value1, int value2){
        if(search(root, value1) == false){
            return null;
        }
        if(search(root, value2) == false){
            return null;
        }
        if(search(root, value1) == true && search(root, value2) == true) {
            return findLCA(root, value1, value2);
        }
        else{
            return null;
        }
    }

    boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        boolean result = (search(root.left, key));
        if(result){
            return true;
        }
        boolean result2 = search(root.right, key);
        return result2;
    }


    Node findLCA(Node node, int val1, int val2){
        // check for null node
        if (node == null) {
            return null;
        }

            //check if either input are the root node
            if (node.data == val1 || node.data == val2) {
                return node;
            }
            // Look for keys in left and right subtrees
            Node left_lca = findLCA(node.left, val1, val2);
            Node right_lca = findLCA(node.right, val1, val2);


            if (left_lca != null && right_lca != null) {
                return node;
            }

            return (left_lca != null) ? left_lca : right_lca;
        }

   /* public static void main(String[] args) {
        //create and fill tree
        LCATree tree = new LCATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(15);

        System.out.println("LCA for 13 and 15 is " + tree.findLCA(13, 15).data);
        System.out.println("LCA for 8 and 9 is " + tree.findLCA(8,9).data);
        System.out.println("LCA for 2 and 15 is " + tree.findLCA(2,15).data);

    }*/
}
