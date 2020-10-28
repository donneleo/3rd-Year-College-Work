package src;

import org.junit.Test;
import static org.junit.Assert.*;

public class DAGTest {

    DAG test = new DAG(10);
    DAG test2 = new DAG(5);

    @Test(expected = IllegalArgumentException.class)
    public void testDAG(){
        DAG fakeDAG = new DAG(-5);
    }

    @Test
    public void testAddEdge(){
        buildAnotherGraph();
        test2.addEdge(2,3);
        assertEquals("Number of edges in this graph is now 2", 2, test2.edges());
        test2.addEdge(2,4);
        assertEquals("Number of edges in the DAG is now 3", 3, test2.edges());
        test2.addEdge(-5,-5);
        assertEquals("Number of edges has not changed as -5 is invalid", 3, test2.edges());
    }

    @Test
    public void testVertices(){
        buildGraph();
        assertEquals("DAG has 10 vertices", 10, test.vertices());
    }


    @Test
    public void test_number_edges_out(){
        buildGraph();
        assertEquals("Vertex 5 has 3 edges out", 3, test.number_edges_out(5));
        assertEquals("Vertex 1 has 2 edges out", 2, test.number_edges_out(1));
        assertEquals("Has no nodes out. Invalid input", -1, test.number_edges_out(-5));
    }

    @Test
    public void test_number_edges_in(){
        buildGraph();
        assertEquals("Vertex 6 has 2 edges coming in", 2, test.numbers_edges_in(6));
        assertEquals("Vertex 1 has 0 edges coming in", 0, test.numbers_edges_in(1));
        assertEquals("Vertex 2 has 1 edges coming in", 1, test.numbers_edges_in(2));
        assertEquals("Has no nodes in. Invalid Input", -1, test.numbers_edges_in(-5));
    }

    @Test
    public void testNumber_connections(){
        buildGraph();
        buildAnotherGraph();

        assertArrayEquals(new int[]{6,8,9}, test.number_connections(5));
        assertArrayEquals(new int[]{2}, test2.number_connections(1));
        assertArrayEquals(null, test.number_connections(-5));
    }

    @Test
    public void testFindLCA(){
        buildGraph();
        buildAnotherGraph();

        assertEquals("LCA of vertices 6 and 9 is 5", 5, test.findLCA(6,9));
    }


    public void buildGraph(){
        test.addEdge(0,1);
        test.addEdge(1,2);
        test.addEdge(2,3);
        test.addEdge(3,4);
        test.addEdge(4,5);
        test.addEdge(5,6);
        test.addEdge(6,7);
        test.addEdge(7,8);
        test.addEdge(8,9);
        test.addEdge(1,4);
        test.addEdge(2,7);
        test.addEdge(4,6);
        test.addEdge(5,9);
        test.addEdge(5,8);
    }

    public void buildAnotherGraph(){
        test2.addEdge(1,2);
    }
}
