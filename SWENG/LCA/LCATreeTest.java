package src;

import org.junit.Test;
import static org.junit.Assert.*;

public class LCATreeTest {

    @Test
    public void testFindLCA() {

        //create and fill tree
        LCATree testTree = new LCATree();
        testTree.root = new Node(1);
        testTree.root.left = new Node(2);
        testTree.root.right = new Node(3);
        testTree.root.left.left = new Node(8);
        testTree.root.left.right = new Node(9);
        testTree.root.right.left = new Node(13);
        testTree.root.right.right = new Node(15);

        assertEquals("LCA of nodes 15 and 13 is ", 3, testTree.findLCA(13,15).data);
        assertEquals("LCA of nodes 8 and 15 is ", 1, testTree.findLCA(8,15).data);
        assertEquals("LCA of nodes 0 and 18 is ", null, testTree.findLCA(0,18));

        assertEquals("LCA of nodes -5 and -6 is ", null, testTree.findLCA(-5, -6));
        assertEquals("LCA of nodes null and 9 is ", null, testTree.findLCA(null, 9, 13));
        assertEquals("LCA of nodes 2 and 150 is null", null, testTree.findLCA(2, 150));
    }

    @Test
    public void testSearch() {

        LCATree testTree = new LCATree();
        testTree.root = new Node(1);
        testTree.root.left = new Node(2);
        testTree.root.right = new Node(3);
        testTree.root.left.left = new Node(8);
        testTree.root.left.right = new Node(9);
        testTree.root.right.left = new Node(13);
        testTree.root.right.right = new Node(15);

        assertEquals("Node 8 exists in the tree", true, testTree.search(testTree.root, 8));
        assertEquals("Node 200 does not exist in the tree", false, testTree.search(testTree.root, 200));
    }
}
