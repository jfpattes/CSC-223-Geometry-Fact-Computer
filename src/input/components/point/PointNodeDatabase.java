package input.components.point;

import java.util.ArrayList;
import java.util.LinkedHashSet;

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
		PointNode node = new PointNode(x, y);
		for (PointNode nodes: _points) {
			if 
		}
	}

}
