package input.components.point;

import java.util.ArrayList;
import java.util.LinkedHashSet;
/*
* Allows us to put PointNode objects in a linkedHashSet.
*@author Moultrie DangerField and Jack Patterson
*@version 9/7/23
*/
public class PointNodeDatabase {
	
	protected LinkedHashSet<PointNode> _points;
	
	public PointNodeDatabase() {
		_points = new LinkedHashSet<PointNode>();
	}
	
	public PointNodeDatabase(ArrayList<PointNode> _list) {
		_points = new LinkedHashSet<PointNode>(_list);
	}
	/*
	* Adds unique PointNodes to a LinkedHashSet
	*@param PointNode
	*/
	public void put(PointNode node) {

		_points.add(node);
		
	}
	/*
	* Checks if the LinkedHashSet contains the Pointnode in the parameter
	*@param PointNode
	*@return boolean
	*/
	public boolean contains(PointNode node) {
		return _points.contains(node);
	}
	/*
	* Checks if the LinkedHashSet contains the x and y value in the parameter
	*@param double of the x value
	*@param double of the y value
	*@return a boolean
	*/
	public boolean contains(double x, double y) {
		return this.contains(new PointNode(x, y));
	}
	/*
	* gets the name of the pointnode in the parameters
	*@param pointnode
	*@return the name of the pointnode.
	*/
	public String getName(PointNode node) {
		
		for (PointNode p: _points) {
			if(p.equals(node)) {
				return p.getName();
			}
		}
		return null;
	}
	/*
	* gets the name of the pointnode described by the parameters
	*@param double of the x value
	*@param double of the y value
	*@return string of the pointnode associated with the parameter
	*/
	public String getName(double x, double y) {
		
		for(PointNode p: _points) {
			if(p.getX() == x && p.getY() == y) {
				return p.getName();
			}
		}
		return null;
	}
	/*
	* Checks if the LinkedHashSet contains the Pointnode in the parameter
	*@param double of the x value
	*@param double of the y value
	*@return string of the pointnode associated with the parameter
	*/
	public PointNode getPoint(PointNode node) {
		
		for (PointNode p: _points) {
			if(p.equals(node)) {
				return p;
			}
		}
		return null;
	}
	/*
	* returns the pointNode described by the parameter
	*@param double of the x value
	*@param double of the y value
	*@return the pointnode described by the parameters
	*/
	public PointNode getPoint(double x, double y) {
		
		for(PointNode p: _points) {
			if(p.getX() == x && p.getY() == y) {
				return p;
			}
		}
		return null;
	}
	
}
