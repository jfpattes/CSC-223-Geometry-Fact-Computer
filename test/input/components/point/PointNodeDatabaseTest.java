package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeDatabaseTest {

	@Test
	void testPut() {
		PointNodeDatabase points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 2, 5);
		PointNode node3= new PointNode(3, 8);
		PointNode node4 = new PointNode("C", 5, 9);
		
		points.put(node1);
		points.put(node2);
		points.put(node3);
		points.put(node4);
		
		assertEquals(4, points._points.size());
		
	    //All the values get added
		assertTrue (points.contains(node1));
		assertTrue (points.contains(node2));
		assertTrue (points.contains(node3));
		assertTrue(points.contains(node4));
		
		//Add another node with the same coordinates
		PointNode node5 = new PointNode("D", 5, 9);
		points.put(node5);
		assertEquals(4, points._points.size());
		assertTrue (points.contains(node5));
		
		//Makes sure duplicate keys aren't added as size doesn't change
		points.put(node4);
		assertEquals(4, points._points.size());
	}
	
	@Test
	void testContains() {
		PointNodeDatabase _points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode( 2, 5);
		
		_points.put(node1);
		_points.put(node2);
		//makes sure the contains method isn't just returning true
		
		assertTrue (_points.contains(node2));
		assertTrue (_points.contains(node1));
		
		//Test double values
		assertTrue (_points.contains(2, 5));
		assertTrue (_points.contains(Math.sqrt(2), 5));
		assertFalse (_points.contains(1.414213, 5));
	}
	
	@Test
	void testGetName() {
		PointNodeDatabase points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 1, 5);
		PointNode node3= new PointNode("B", 2, 7);
		
		points.put(node1);
		points.put(node2);
		points.put(node3);
		
		//Confirm no name
		assertEquals("__UNNAMED", points.getName(node1));
		assertEquals("__UNNAMED", points.getName(Math.sqrt(2), 5));
		
		
		assertEquals ("A", points.getName(node2));
		assertEquals("A", points.getName(1, 5));
		assertFalse(points.getName(node3)== "b");
		assertTrue(points.getName(node3)== "B");
	}
	@Test
	void testGetPoint() {
		PointNodeDatabase points = new PointNodeDatabase();
		PointNode node1= new PointNode(Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 1, 5);
		
		points.put(node1);
		points.put(node2);
		
		assertEquals (node1, points.getPoint(node1));
		assertEquals (node1, points.getPoint(Math.sqrt(2), 5));
		assertEquals (node2, points.getPoint(node2));
		assertEquals (node2, points.getPoint(1, 5));
		
	}
}
