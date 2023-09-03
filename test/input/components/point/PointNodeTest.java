package input.components.point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class PointNodeTest {
	

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testGetX() {
		PointNode node1= new PointNode( 0, 0);
		PointNode node2= new PointNode("node2", 45, 0);
		PointNode node3= new PointNode( -45, 45);
		assertTrue (0==node1.getX());
		assertTrue (45==node2.getX());
		assertTrue (-45==node3.getX());
	}

	@Test
	void testGetY() {
		PointNode node1= new PointNode( 0, 0);
		PointNode node2= new PointNode("node2", 0, -45);
		PointNode node3= new PointNode( -45, 45);
		assertTrue (0==node1.getY());
		assertTrue (-45==node2.getY());
		assertTrue (45==node3.getY());
		
		
	}

	@Test
	void testGetName() {
		PointNode node1= new PointNode( 0, 1);
		PointNode node2= new PointNode("node2",0, 2);
		PointNode node3= new PointNode("node3", 0, 1);
		assertEquals ("__UNNAMED", node1.getName());
		assertEquals ("node2", node2.getName());
		
	}

	@Test
	void testEqualsObject() {
		PointNode node1= new PointNode( 0, 1);
		PointNode node2= new PointNode("node2",0, 2);
		PointNode node3= new PointNode("node3", 0, 1);
		PointNode node4= new PointNode( 3, 5);
		PointNode node5= new PointNode( 3, -5);
		PointNode node6= new PointNode( 0, 5);
		PointNode node7= new PointNode( 0, 5.000001);
		//tests that if the difference in values is less than .000001 then it doesn't get counted
		PointNode node8= new PointNode( 0, 5.0000009);
		PointNode node9= new PointNode( 0, 5);
		PointNode node10= new PointNode( Math.sqrt(2), 5);
		PointNode node11= new PointNode( 1.414213, 5);
		assertFalse (node1.equals(node2));
		assertTrue (node1.equals(node1));
		assertTrue (node1.equals(node3));
		assertFalse (node4.equals(node5));
		assertFalse (node6.equals(node7));
		assertTrue (node8.equals(node9));
		assertTrue (node10.equals(node11));

	}
}
