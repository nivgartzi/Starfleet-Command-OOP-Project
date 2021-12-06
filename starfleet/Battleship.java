package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Battleship extends AbstractSpaceShip {
	
	private int firePower,annualMaintenanceCost;
	private List<Weapon> listWeapon;
	
	public Battleship(String name,int commissionYear,float maximalSpeed,
			Set<? extends CrewMember> crewMembers,List<Weapon> listWeapon) {
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.listWeapon = listWeapon;
		calcFirePowerAnnMain();
	}


	public List<Weapon> getWeapon() {
		return this.listWeapon;
	}


	@Override
	public int getFirePower() {
		return super.getFirePower() + this.firePower;
			
	}
	
	private void calcFirePowerAnnMain() {
		for(Weapon w:listWeapon) {
			this.firePower += w.getFirePower();
			this.annualMaintenanceCost += w.getAnnualMaintenanceCost();
		}
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost;
	}

	public String toString() {
		return super.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + annualMaintenanceCost;
		result = prime * result + firePower;
		result = prime * result + ((listWeapon == null) ? 0 : listWeapon.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Battleship other = (Battleship) obj;
			if (annualMaintenanceCost != other.annualMaintenanceCost)
				return false;
			if (firePower != other.firePower)
				return false;
			if (listWeapon == null) {
				if (other.listWeapon != null)
					return false;
			} else if (!listWeapon.equals(other.listWeapon))
				return false;
		}
			return true;
	}
	
	}

