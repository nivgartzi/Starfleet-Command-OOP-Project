package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman {
	private OfficerRank rank;
		
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.rank = rank;
	}
	
	public OfficerRank getRank() {
		return this.rank;
	}
	
	public String toString() {
		return super.toString() + 
				"\n\tRank=" + this.rank;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}
	
	
	public boolean equals(Object obj) {
		boolean superEq = super.equals(obj);
		if(!superEq)
			return false;
		Officer other = (Officer) obj;
		if(this.rank!= other.getRank())
			return false;
		return true;
	}
}
