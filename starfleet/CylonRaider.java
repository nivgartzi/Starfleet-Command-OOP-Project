package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	}

	public int getAnnualMaintenanceCost() {
		return  3500 + this.getCrewMembers().size()*500 + 
				(int)Math.floor(1200 * this.getMaximalSpeed()) + super.clacWeapon(this.getWeapon());
	}
	
	

	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
	


