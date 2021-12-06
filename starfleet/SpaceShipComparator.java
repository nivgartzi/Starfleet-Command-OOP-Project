package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;


public class SpaceShipComparator implements Comparator<Spaceship>{

	public int compare(Spaceship o1, Spaceship o2) {
		int compareRes = Integer.compare(o1.getFirePower(),
				o2.getFirePower());
		if(compareRes != 0)
			return compareRes;
		compareRes =  Integer.compare(o1.getCommissionYear(),
				o2.getCommissionYear());
		if(compareRes != 0)
			return compareRes;
		compareRes = o2.getName().compareTo(o1.getName());
		return compareRes;
		
	}
}
