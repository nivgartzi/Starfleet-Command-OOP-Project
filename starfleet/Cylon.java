package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends AbstractCrewMember{
	
	private int modelNumber;
	

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age,yearsInService,name);
		this.modelNumber = modelNumber;
	}
	
	public int getModelNumber() {
		return this.modelNumber;
	}
	
	public String toString() {
		return super.toString() + 
				"\n\tModelNumber=" + this.modelNumber;
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + modelNumber;
		return result;
		
	}
	public boolean equals(Object obj) {
		boolean superEq = super.equals(obj);
		if(!superEq)
			return false;
		Cylon other = (Cylon) obj;
		if(this.modelNumber!= other.getModelNumber())
			return false;
		return true;
	}
}
