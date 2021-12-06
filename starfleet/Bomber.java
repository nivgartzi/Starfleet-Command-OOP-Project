package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Battleship{
	
	private int numberOfTechnicians;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		double discount = numberOfTechnicians * 0.1; 
		int newPrice = (int)(super.getAnnualMaintenanceCost() * (1-discount));
		return  newPrice + 5000; 
			
	}
	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}
	public String toString() {
		return super.toString()+
				"\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() +
				"\n\tWeapons=" + this.getWeapon() +
				"\n\tNumberOfTechnicians=" + this.numberOfTechnicians;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberOfTechnicians;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bomber other = (Bomber) obj;
		if (numberOfTechnicians != other.numberOfTechnicians)
			return false;
		return true;
	}
}
