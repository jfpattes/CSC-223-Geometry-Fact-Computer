package input.components.segment;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import input.components.point.PointNode;

public class SegmentNodeDatabase {
		protected HashMap<PointNode, LinkedHashSet<PointNode>> _adjLists;
		
		public SegmentNodeDatabase() {
			_adjLists= new HashMap<PointNode, LinkedHashSet<PointNode>>();
		}
		public SegmentNodeDatabase(HashMap<PointNode, LinkedHashSet<PointNode>> map) {
			_adjLists= new HashMap<PointNode, LinkedHashSet<PointNode>>(map);
		}
		
	
}
