package input.components.point;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.lang.Throwable;

public class PointNodeDatabase {
	
	protected LinkedHashSet<PointNode> _points;
	
	public PointNodeDatabase() {
		_points = new LinkedHashSet<PointNode>();
	}
	
	public PointNodeDatabase(ArrayList<PointNode> _list) {
		_points = new LinkedHashSet<PointNode>(_list);
	}
	public void put(PointNode node) {
		_points.add(node);
	}
	public boolean contains(PointNode node) {
		return _points.contains(node);
	}
	public boolean contains(int x, int y) {
		return this.contains(new PointNode(x, y));
	}
	
	public PointNode getPoint(PointNode node) {
		for (PointNode p: _points) {
			if(p.getName().equals(node)) {
				return p;
			}
		}
		return null;
	}
	
	public PointNode getPoint(double x, double y) {
		for(PointNode p: _points) {
			if(p.getX() == x && p.getY() == y) {
				return p;
			}
		}
		return null;
	}
	
}