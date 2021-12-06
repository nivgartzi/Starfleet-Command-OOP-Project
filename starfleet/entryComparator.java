package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class entryComparator implements Comparator<Map.Entry<OfficerRank, Integer>>{

	@Override
	public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
		int compaRes = Integer.compare(o1.getValue(), o2.getValue());
		if(compaRes != 0)
			return compaRes;
		return o1.getKey().compareTo(o2.getKey());
	}

}
