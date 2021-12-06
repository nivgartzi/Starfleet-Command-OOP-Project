package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
	
	private static int counter  = 0;
	private static List<Weapon> listWeaponOfFighter;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		counter++;
		listWeaponOfFighter = createNewLst();
	}



	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name,commissionYear,maximalSpeed,crewMembers,listWeaponOfFighter);
	
	}

	private static List<Weapon> createNewLst() {
		listWeaponOfFighter = new ArrayList<Weapon>();
		Weapon w = new Weapon("Laser Cannons",10,100);
		listWeaponOfFighter.add(w);
		return listWeaponOfFighter;
	}
	
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + calcClockingDevice();
	}

	private int calcClockingDevice() {
		return counter * 50;
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
	
