package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class AbstractSpaceShip implements Spaceship {
	private String name;
	private int commissionYear;
	private float maximalSpeed;
	private Set<? extends CrewMember> crewMembers;
	
	
	public AbstractSpaceShip(String name,int commissionYear
			,float maximalSpeed,Set<? extends CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.crewMembers = crewMembers;
		this.maximalSpeed = maximalSpeed;
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCommissionYear() {
		return this.commissionYear;
	}

	@Override
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}

	@Override
	public Set<? extends CrewMember> getCrewMembers() {
		return this.crewMembers;
	}
	
	
	public  int getFirePower() {
		return 10;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commissionYear;
		result = prime * result + ((crewMembers == null) ? 0 : crewMembers.hashCode());
		result = prime * result + Float.floatToIntBits(maximalSpeed);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceShip other = (AbstractSpaceShip) obj;
		if (commissionYear != other.commissionYear)
			return false;
		if (crewMembers == null) {
			if (other.crewMembers != null)
				return false;
		} else if (!crewMembers.equals(other.crewMembers))
			return false;
		if (Float.floatToIntBits(maximalSpeed) != Float.floatToIntBits(other.maximalSpeed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return this.getClass().getSimpleName() + 
				"\n\tName=" + this.name +
				"\n\tCommissionYear=" + this.commissionYear +
				"\n\tMaximalSpeed=" + this.maximalSpeed +
				"\n\tFirePower=" + getFirePower()+
				"\n\tCrewMembers=" + getCrewMembers().size();
			
				
				
	}
}
