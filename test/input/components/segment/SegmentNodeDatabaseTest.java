package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;

/*
* Tests the methods from the SegmentNodeDatabase class.
*@author Moultrie DangerField and Jack Patterson
*@version 9/8/23
*/

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
		SegmentNodeDatabase db = build();
		
		assertEquals (10, db.numUndirectedEdges());	
		
		PointNode node1=new PointNode("node1", -58, Math.sqrt(2));
		PointNode node2=new PointNode("node2", 5, 37);
		db.addUndirectedEdge(node1, node2);
		assertEquals (11, db.numUndirectedEdges());
	}
	
    @Test
    void testAddDirectedEdge() {
    	SegmentNodeDatabase snd = new SegmentNodeDatabase();
    	PointNode node1=new PointNode("node1", 4, 5);
    	PointNode node2=new PointNode("node2", 2, 7);
    	PointNode node3= new PointNode("node3",-5, 8);
    	PointNode node4=new PointNode(2, 7);
    	
    	snd.addDirectedEdge(node1, node2);
    	assertTrue (snd._adjLists.containsKey(node1));
    	assertTrue (snd._adjLists.get(node1).contains(node2));
    	
    	snd.addDirectedEdge(node1, node4);
    	assertTrue (snd._adjLists.get(node1).contains(node4));
    	assertTrue (snd._adjLists.get(node1).contains(node2));
    	assertFalse(snd._adjLists.containsKey(node4));
    	
    	
    	snd.addDirectedEdge(node2, node3);
    	snd.addDirectedEdge(node2, node4);
    	assertTrue (snd._adjLists.containsKey(node2));
    	assertTrue (snd._adjLists.get(node2).contains(node3));
    	assertTrue (snd._adjLists.get(node2).contains(node4));
    	assertFalse (snd._adjLists.get(node2).contains(node1));
    	
    }
    
    @Test
    void testAddUndirectedEdges() {
    	SegmentNodeDatabase snd= new SegmentNodeDatabase();
    	//triangle works and offshoot line of triangle works
    	PointNode node1=new PointNode(0, 0);
    	PointNode node2=new PointNode(0, 6);
    	PointNode node3=new PointNode(3, 3);
    	PointNode node4=new PointNode(0,7);
    	PointNode node5=new PointNode(0,8);
    	
    	
    	
    	snd.addUndirectedEdge(node1, node2);
    	snd.addUndirectedEdge(node2, node3);
    	snd.addUndirectedEdge(node3, node1);
    	snd.addUndirectedEdge(node1, node5);
    	
    	
    
    	assertTrue (snd._adjLists.containsKey(node1));
    	assertTrue (snd._adjLists.get(node1).contains(node2));
    	assertTrue (snd._adjLists.get(node1).contains(node3));
    	assertTrue (snd._adjLists.containsKey(node2));
    	assertTrue (snd._adjLists.get(node2).contains(node1));
    	assertTrue (snd._adjLists.get(node2).contains(node3));
    	assertTrue (snd._adjLists.containsKey(node3));
    	assertTrue (snd._adjLists.get(node3).contains(node1));
    	assertTrue (snd._adjLists.get(node3).contains(node2));
    	//Tests that just because a segment intersects a line doesn't mean they are part of the values associated with it's key
    	assertTrue (snd._adjLists.get(node5).contains(node1));
    	assertFalse (snd._adjLists.get(node5).contains(node4));
    	
    	
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
    	
    	//Test adding a list when node A exists in the map with a value
    	List<PointNode> list2 = new ArrayList<PointNode>();
    	List<PointNode> list3 = new ArrayList<PointNode>();
    	
    	PointNode nodeA = new PointNode("A", 0, 1);
    	PointNode nodeB = new PointNode("B", 0, 2);
    	PointNode nodeC = new PointNode("C", 0, 3);
    	PointNode nodeD = new PointNode("D", 0, 4);
    	
    	list2.add(nodeB);
    	list2.add(nodeD);
    	
    	list3.add(nodeB);
    	list3.add(nodeC);
    	
    	
    	
    	SegmentNodeDatabase nodeMap= new SegmentNodeDatabase();
    	
    	
    	nodeMap.addAdjencyList(nodeA, list2);
    	nodeMap.addAdjencyList(nodeA, list3);
    	nodeMap.addAdjencyList(nodeC, list2);
    	assertEquals(3, nodeMap._adjLists.get(nodeA).size());
    	assertEquals(2, nodeMap._adjLists.get(nodeC).size());
  
    }
    
    @Test
    void testAsSegmentList() {
    	SegmentNodeDatabase db = build();
		assertEquals (20, (db.asSegmentList()).size());
    }
    
    @Test
    void testAsUnigueSegmentList() {
    	SegmentNodeDatabase db = build();
    	assertEquals (10, db.asUnigueSegmentList().size());
    }
}
