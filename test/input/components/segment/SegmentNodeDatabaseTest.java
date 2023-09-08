package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

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
    	PointNode node1=new PointNode(4, 5);
    	PointNode node2=new PointNode(2, 7);
    	SegmentNodeDatabase snd1= new SegmentNodeDatabase();
    	snd1.addDirectedEdge(node1, node2);
    	assertTrue (snd1._adjLists.containsKey(node1));
    	assertTrue (snd1._adjLists.get(node1).contains(node2));
    	
    }
    @Test
    void testAddUndirectedEdges() {
    	PointNode node1=new PointNode(4, 5);
    	PointNode node2=new PointNode(2, 7);
    	SegmentNodeDatabase snd1= new SegmentNodeDatabase();
    	snd1.addUndirectedEdge(node1, node2);
    	assertTrue (snd1._adjLists.containsKey(node1));
    	assertTrue (snd1._adjLists.get(node1).contains(node2));
    	assertTrue (snd1._adjLists.containsKey(node2));
    	assertTrue (snd1._adjLists.get(node2).contains(node1));
    	
    }
}
