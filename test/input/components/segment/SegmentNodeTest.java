package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

/*
* Tests the methods from the SegmentNode class.
*@author Moultrie DangerField and Jack Patterson
*@version 9/8/23
*/
class SegmentNodeTest {

	@Test
	void testGetPoint1() {
		//test if getPoint1 works on pointnodes with rational and irrational values
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2=new PointNode("A", 3, 9);
		
		SegmentNode line1= new SegmentNode(node1, node2);
		SegmentNode line2= new SegmentNode(node2, node1);
		
		assertEquals (node1, line1.getPoint1());
		assertEquals (node2, line2.getPoint1());
	}

	@Test
	void testGetPoint2() {
		//test if getPoint2 works on pointnodes with rational and irrational values
		PointNode node1= new PointNode( 1, Math.sqrt(2));
		PointNode node2=new PointNode("A", 3, 9);
		
		SegmentNode line1= new SegmentNode(node1, node2);
		SegmentNode line2= new SegmentNode(node2, node1);
		
		assertEquals (node2, line1.getPoint2());
		assertEquals (node1, line2.getPoint2());
	}

	@Test
	void testEqualsObject() {
		//test if pointNodes with different names but same values insert into two 
		//different segment nodes with the other parameter being the same point are equal.
		PointNode node1= new PointNode( 1, 5);
		PointNode node2=new PointNode("A", 3, 9);
		PointNode node3=new PointNode( -9, Math.sqrt(2));
		PointNode node4=new PointNode("B", 1, 5);
		PointNode node5=new PointNode("C", 70, 25);
		
		SegmentNode line1= new SegmentNode(node1, node2);
		SegmentNode line2= new SegmentNode(node2, node1);
		SegmentNode line3= new SegmentNode(node2, node3);
		SegmentNode line4 = new SegmentNode(node4, node5);
		SegmentNode line5 = new SegmentNode(node4, node2);
		SegmentNode line6 = new SegmentNode(node2, node3);
		
		//base tests
		assertTrue (line1.equals(line1));
		assertFalse (line2.equals(line3));
		
		assertTrue (line1.equals(line2));
		assertTrue (line2.equals(line1));
		assertFalse (line4.equals(line3));
		assertFalse (line4.equals(line1));
		
		assertTrue (line5.equals(line1));
		assertTrue (line6.equals(line3));
		
	}

}
