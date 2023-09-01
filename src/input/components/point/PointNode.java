package input.components.point;

import utilities.math.MathUtilities;

/**
 * A 2D Point (x, y).
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y)
	{
		this(ANONYMOUS, x, y);
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y)
	{
		_x= x;
		_y= y;
		_name= name;
	}

	@Override
	public int hashCode()
	{
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PointNode)) {
			return false;
		}
		
		PointNode that = (PointNode)obj;
		
		//check if objects are equal
		MathUtilities.removeLessEpsilon(that._x);
		MathUtilities.removeLessEpsilon(this._x);
		MathUtilities.removeLessEpsilon(that._y);
		MathUtilities.removeLessEpsilon(this._y);
	
		if(!MathUtilities.doubleEquals(that._x, this._x)) {
			return false;
		}
		if(!MathUtilities.doubleEquals(that._y, this._y)) {
			return false;
		}
		return true;
	}

//    @Override
//    public String toString()
//    {
//		// TODO
//	}
}