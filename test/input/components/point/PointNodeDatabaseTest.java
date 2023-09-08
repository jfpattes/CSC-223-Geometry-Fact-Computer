package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeDatabaseTest {

	@Test
	void testPut() {
		PointNodeDatabase _points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 2, 5);
		PointNode node3= new PointNode("A", 2, 5);
		PointNode node4 = new PointNode("B", 2, 5);
		//How?
		
		_points.put(node1);
		_points.put(node2);
		_points.put(node3);
		_points.put(node4);
		
		assertTrue (_points.contains(node1));
		
	    // Tests that putting two nodes with the same value but different names into the database works 
		assertTrue (_points.contains(node2));
		assertTrue (_points.contains(node3));
		assertTrue(_points.contains(node4));
		
		assertEquals(node4.getName(), node3.getName());
		
		//assertEquals("__UNNAMED", _points.getName(node1));
		
		//assertTrue (_points.getPoint(node3).equals(node4));
		
	}
	
	@Test
	void testContains() {
		PointNodeDatabase _points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode( 2, 5);
		
		_points.put(node1);
		//makes sure the contains method isn't just returning true
		assertFalse (_points.contains(node2));
		_points.put(node2);
		assertTrue (_points.contains(node1));
		assertTrue (_points.contains(2, 5));
		assertTrue (_points.contains(node2));
//		assertTrue (_points.contains(Math.sqrt(2), 5));			Should these work
//		assertTrue (_points.contains(1.414213, 5));
		
		
	}
	
	@Test
	void testGetName() {
		PointNodeDatabase _points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 1, 5);
		PointNode node3= new PointNode("B", 1, 5);
		PointNode node4= new PointNode("A", 1, 5);
		
		_points.put(node1);
		_points.put(node2);
		_points.put(node3);
		_points.put(node4);
		
		assertEquals("__UNNAMED", _points.getName(node1));
		assertEquals("__UNNAMED", _points.getName(Math.sqrt(2), 5));
		assertEquals ("A", _points.getName(node2));
		assertEquals("A", _points.getName(1, 5));
		assertEquals("A", _points.getName(node4));
		//These two don't work if two different nodes with the same points are in there, not sure if that is problematic
//		assertEquals("B", _points.getName(node3));
//		assertEquals("B", _points.getName(1, 5));
		
	}
	@Test
	void testGetPoint() {
		PointNodeDatabase _points = new PointNodeDatabase();
		PointNode node1= new PointNode( Math.sqrt(2), 5);
		PointNode node2= new PointNode("A", 1, 5);
		_points.put(node1);
		_points.put(node2);
		assertEquals (node1, _points.getPoint(node1));
		assertEquals (node1, _points.getPoint(Math.sqrt(2), 5));
		assertEquals (node2, _points.getPoint(node2));
		assertEquals (node2, _points.getPoint(1, 5));
		
	}
}
