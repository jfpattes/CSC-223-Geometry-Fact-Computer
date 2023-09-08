package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;

class SegmentNodeDatabaseTest
{
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }

	@Test
	void testNumUndirectedEdges()
	{
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);
		SegmentNodeDatabase db = build();
		db.addUndirectedEdge(a, b);
		db.addUndirectedEdge(a, c);
		db.addUndirectedEdge(b, c);
		db.addUndirectedEdge(x, b);
		db.addUndirectedEdge(d, b);
		db.addUndirectedEdge(x, c);
		db.addUndirectedEdge(e, c);
		db.addUndirectedEdge(d, e);
		db.addUndirectedEdge(d, x);
		db.addUndirectedEdge(x, e);
		assertEquals (10, db.numUndirectedEdges());
		
	}
    @Test
    void testAddDirectedEdge() {
    	SegmentNodeDatabase snd1= new SegmentNodeDatabase();
    	PointNode node1=new PointNode("node1", 4, 5);
    	PointNode node2=new PointNode("node2", 2, 7);
    	
    	PointNode node3= new PointNode(-5, 8);
    	PointNode node4=new PointNode("node2", 2, 7);
    	
    	
    	snd1.addDirectedEdge(node1, node2);
    	assertTrue (snd1._adjLists.containsKey(node1));
    	assertTrue (snd1._adjLists.get(node1).contains(node2));
    	
    	snd1.addDirectedEdge(node1, node4);
    	assertTrue (snd1._adjLists.get(node1).contains(node4));
    	//assertTrue (snd1._adjLists.get(node1).contains(node2));
    	
    	
   
    	
    }
    @Test
    void testAddUndirectedEdges() {
    	SegmentNodeDatabase snd1= new SegmentNodeDatabase();
    	PointNode node1=new PointNode(4, 5);
    	PointNode node2=new PointNode(2, 7);
    	
    	
    	snd1.addUndirectedEdge(node1, node2);
    	assertTrue (snd1._adjLists.containsKey(node1));
    	assertTrue (snd1._adjLists.get(node1).contains(node2));
    	assertTrue (snd1._adjLists.containsKey(node2));
    	assertTrue (snd1._adjLists.get(node2).contains(node1));
    }
    
    @Test
    void testaddAdjencyList() {
    	//Test adding a list when Node1 doesnt exist in the map
    	List<PointNode> list1 = new ArrayList<PointNode>();
    	
    	PointNode node1 = new PointNode("A", 0, 1);
    	PointNode node2 = new PointNode("B", 0, 2);
    	PointNode node3 = new PointNode("C", 0, 3);
    	PointNode node4 = new PointNode("D", 0, 4);
    	
    	list1.add(node2);
    	list1.add(node3);
    	list1.add(node4);
    	
    	SegmentNodeDatabase snd= new SegmentNodeDatabase();
    	
    	snd.addAdjencyList(node1, list1);
    	//Test if list elements are mapped to key node1
    	assertTrue (snd._adjLists.containsKey(node1));
    	assertTrue (snd._adjLists.get(node1).contains(node2));
    	assertTrue (snd._adjLists.get(node1).contains(node3));
    	assertTrue (snd._adjLists.get(node1).contains(node4));
    	//Test for invalid key
    	assertFalse (snd._adjLists.containsKey(node3));
    	
    	//Test adding a list when node 1 exists in the map with a value
    	List<PointNode> list2 = new ArrayList<PointNode>();
    	
    	PointNode nodeA = new PointNode("A", 0, 1);
    	PointNode nodeB = new PointNode("B", 0, 2);
    	PointNode nodeC = new PointNode("C", 0, 3);
    	PointNode nodeD = new PointNode("D", 0, 4);
    	
    	SegmentNodeDatabase nodeMap= new SegmentNodeDatabase();
    	
    	nodeMap.addAdjencyList(nodeA, list2);
    	
    	//assertTrue (nodeMap._adjLists.containsKey(nodeA));
//    	
//    	nodeMap.addUndirectedEdge(nodeA, nodeB);
//    	
//    	list2.add(nodeA);
//    	list2.add(node3);
//    	list2.add(node4);
    	
    }
    @Test
    void testAsSegmentList() {
    	SegmentNodeDatabase db = build();
		assertEquals (20, (db.asSegmentList()).size());
    }
    @Test
    void testAsUnigueSegmentList() {
    	SegmentNodeDatabase db = build();
    	assertEquals (10, db.asSegmentList().size());
    }
}
