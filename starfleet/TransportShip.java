package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceShip{
	private int cargoCapacity,passengerCapacity, annualMaintenanceCost;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,
				crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
		this.annualMaintenanceCost = calcAnnualMaintenanceCost();
	}


	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}
	
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost;
	}
	
	private int calcAnnualMaintenanceCost() {
		int annualMaint = 3000 + getCargoCapacity() * 5 +
				3 * getPassengerCapacity();
		return annualMaint;
	
	}
	
	public String toString() {
		return super.toString()+
				"\n\tAnnualMaintenanceCost=" + this.annualMaintenanceCost +
				"\n\tCargoCapacity=" + this.cargoCapacity +
				"\n\tPassengerCapacity=" + this.passengerCapacity;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + annualMaintenanceCost;
		result = prime * result + cargoCapacity;
		result = prime * result + passengerCapacity;
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
		TransportShip other = (TransportShip) obj;
		if (annualMaintenanceCost != other.annualMaintenanceCost)
			return false;
		if (cargoCapacity != other.cargoCapacity)
			return false;
		if (passengerCapacity != other.passengerCapacity)
			return false;
		return true;
	}
}
