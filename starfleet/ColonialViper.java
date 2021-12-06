package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {
	

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		
	}
	
	public int getAnnualMaintenanceCost() {
		return 4000 +
				this.getCrewMembers().size()*500 + 
				(int)Math.floor(500 * this.getMaximalSpeed()) + super.clacWeapon(this.getWeapon());
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

