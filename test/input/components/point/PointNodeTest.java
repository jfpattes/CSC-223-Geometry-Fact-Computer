package input.components.point;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
* Tests the methods from the pointNode class.
*@author Moultrie DangerField and Jack Patterson
*@version 9/8/23
*/
class PointNodeTest {
	
	@Test
	void testGetX() {
		//Create pointNode objects
		PointNode node1= new PointNode(0, 0);
		PointNode node2= new PointNode("node2", 45, 0);
		PointNode node3= new PointNode("hello", -45, 45);
		PointNode node4=new PointNode(Math.sqrt(2), -5);
		
		//Test actual x values
		assertTrue (node1.getX()==0);
		assertTrue (node2.getX()==45);
		assertTrue (node3.getX()==-45);
		assertTrue (node4.getX()==Math.sqrt(2));
		
		//Test non existent x values
		assertFalse(node3.getX()== 25);
		assertFalse(node1.getX()== 4);
	}

	@Test
	void testGetY() {
		PointNode node1= new PointNode( 0, 0);
		PointNode node2= new PointNode("node2", 0, -45);
		PointNode node3= new PointNode(-45, 45);
		PointNode node4=new PointNode(7, Math.sqrt(2));
		
		//test y values
		assertTrue (node1.getY()==0);
		assertTrue (node2.getY()==-45);
		assertTrue (node3.getY()==45);
		assertTrue (node4.getY()==Math.sqrt(2));
		
		//Test non y values
		assertFalse (node1.getY() == 45);
		assertFalse (node3.getY() == 100);
	}

	@Test
	void testGetName() {
		PointNode node1= new PointNode( 0, 1);
		PointNode node2= new PointNode("node2",0, 2);
		PointNode node3= new PointNode("node3", 0, 1);
		
		//Test real names
		assertEquals ("__UNNAMED", node1.getName());
		assertEquals ("node2", node2.getName());
		assertTrue (node2.getName()=="node2");
		
		//Test false names
		assertFalse (node1.getName()=="");
		assertFalse (node2.getName()=="node15");
		assertFalse (node3.getName()=="node2");
	}

	@Test
	void testEqualsObject() {
		//Test if same points different name equals, makes sure negative and positve values aren't held equal, tests the epsilon, tests irrational numbers
		PointNode node1= new PointNode("node1", 0, 1);
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
		
		//Base tests
		assertFalse (node1.equals(node2));
		assertTrue (node1.equals(node1));
		
		assertTrue (node1.equals(node3));
		assertFalse (node4.equals(node5));
		assertFalse (node6.equals(node7));
		assertTrue (node8.equals(node9));
		assertTrue (node10.equals(node11));
	}
}
