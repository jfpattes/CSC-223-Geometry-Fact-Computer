package input.components.point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeTest {
	

//	@Test
//	void testHashCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetX() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetY() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPointNodeDoubleDouble() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPointNodeStringDoubleDouble() {
//		fail("Not yet implemented");
//	}

	@Test
	void testEqualsObject() {
		PointNode node1= new PointNode( 0, 1);
		PointNode node2= new PointNode("node2",0, 2);
		PointNode node3= new PointNode( 0, 1);
		PointNode node4= new PointNode( 3, 5.0000007);
		PointNode node5= new PointNode( 3, 5.00000002);
		PointNode node6= new PointNode( 0, 5);
		PointNode node7= new PointNode( 0, 5.000001);
		//tests that if the difference in values is less than .000001 then it doesn't get counted
		PointNode node8= new PointNode( 0, 5.0000009);
		PointNode node9= new PointNode( 0, 5);
		assertFalse (node1.equals(node2));
		assertTrue (node1.equals(node1));
		assertTrue (node1.equals(node3));
		assertTrue (node4.equals(node5));
		assertFalse (node6.equals(node7));
		assertTrue (node8.equals(node9));

	}
}
