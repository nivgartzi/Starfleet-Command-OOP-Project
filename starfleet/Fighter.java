package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends Battleship{
	
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	

	}
	
	protected int clacWeapon(List<Weapon> weapons) {
		int sum =  0;
		for(Weapon w: this.getWeapon()) {
			sum += w.getAnnualMaintenanceCost();
		}
		return sum;
	}

	public int getAnnualMaintenanceCost() {
		
		return super.getAnnualMaintenanceCost() + 2500 + (int)
				Math.floor(1000 * this.getMaximalSpeed());
	}
	
	
	public String toString() {
		return super.toString()+
				"\n\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost() +
				"\n\tWeapons=" + this.getWeapon();
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
