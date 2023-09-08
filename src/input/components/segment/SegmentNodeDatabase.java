package input.components.segment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import input.components.point.PointNode;
public class SegmentNodeDatabase {
		protected HashMap<PointNode, LinkedHashSet<PointNode>> _adjLists;
		
		public SegmentNodeDatabase() {
			_adjLists= new HashMap<PointNode, LinkedHashSet<PointNode>>();
		}
		public SegmentNodeDatabase(HashMap<PointNode, LinkedHashSet<PointNode>> map) {
			_adjLists= new HashMap<PointNode, LinkedHashSet<PointNode>>(map);
		}
		
	public int numUndirectedEdges() {
		if(_adjLists.isEmpty()){
			return 0;
		}
		int count=0;
		Set<PointNode> setKey = _adjLists.keySet();
		//loops through the keyset of the map
		for(PointNode pn1: setKey) {
			//loops through the values of the key equal to pn1
			for (PointNode pn2: (_adjLists.get(pn1))){
				//gets the values associated with the key pn2, and see if they contains pn1
				if ((_adjLists.get(pn2)).contains(pn1)) {
					count++;
				}
			}
		}
		return (count/2);
		
	}
	
	public void addDirectedEdge(PointNode pn1, PointNode pn2) {
		if (!_adjLists.containsKey(pn1)) {
			LinkedHashSet<PointNode> _pnSet1= new LinkedHashSet<PointNode>();
			_adjLists.put(pn1, _pnSet1);
		}
		if (_adjLists.containsKey(pn1)) {
			LinkedHashSet<PointNode> _pnSet1=_adjLists.get(pn1);
			if(!_pnSet1.contains(pn2)) {
				_adjLists.get(pn1).add(pn2);
			}
		}
	}
	public void addUndirectedEdge(PointNode pn1, PointNode pn2) {
		addDirectedEdge(pn1, pn2);	
		addDirectedEdge(pn2, pn1);	
	}
	public void addAdjencyList(PointNode pn, List<PointNode> valueList) {
		for (PointNode value: valueList) {
			addDirectedEdge(pn, value);
		}
		
	}
	public List<SegmentNode> asSegmentList() {
		List<SegmentNode> segList = new ArrayList<SegmentNode>();
		if(_adjLists.isEmpty()){
			return segList;
		}
		Set<PointNode> setKey = _adjLists.keySet();
		for(PointNode pn1: setKey) {
			//loops through the values of the key equal to pn1
			for (PointNode pn2: (_adjLists.get(pn1))){
				SegmentNode sn=new SegmentNode(pn1, pn2);
				segList.add(sn);
				}
			}
		return segList;
		}
	
	public List<SegmentNode> asUnigueSegmentList(){
		List<SegmentNode> segList = new ArrayList<SegmentNode>();
		if(_adjLists.isEmpty()){
			return segList;
		}
		Set<PointNode> setKey = _adjLists.keySet();
		for(PointNode pn1: setKey) {
			//loops through the values of the key equal to pn1
			for (PointNode pn2: (_adjLists.get(pn1))){
				SegmentNode sn=new SegmentNode(pn1, pn2);
				if (!segList.contains(sn)) {
					segList.add(sn);
				}
			}
		}
		return segList;
	}
	
}