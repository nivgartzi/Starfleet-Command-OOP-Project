package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class AbstractCrewMember implements CrewMember 
{
	
	private int age, yearsInService;
	private String name;
	
	public AbstractCrewMember(int age, int yearsInService, String name){
		this.age = age;
		this.name = name;
		this.yearsInService = yearsInService;
	}


	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public int getYearsInService() {
		return this.yearsInService;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() +
				"\n\tName=" + this.name +
				"\n\tAge=" + this.age +
				"\n\tYears In Service=" + this.yearsInService;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearsInService;
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
		AbstractCrewMember other = (AbstractCrewMember) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearsInService != other.yearsInService)
			return false;
		return true;
	}
	

}
