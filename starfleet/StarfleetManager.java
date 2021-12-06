package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StarfleetManager {
	
	

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> lstOfSpaceShip = new ArrayList<>();
		List<String> lstOfSpaceShipString = new ArrayList<>();
		
		lstOfSpaceShip.addAll(fleet);
		Collections.sort(lstOfSpaceShip, new SpaceShipComparator());
		Collections.reverse(lstOfSpaceShip);
		for(Spaceship s: lstOfSpaceShip)
			lstOfSpaceShipString.add(s.toString());
	
		return lstOfSpaceShipString;
		
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(Spaceship s: fleet) {
			if(m.containsKey(s.getClass().getSimpleName()))
				m.replace(s.getClass().getSimpleName(), m.get(s.getClass().getSimpleName())+ 1);
			else
				m.put(s.getClass().getSimpleName(), 1);
		}
		return m;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for(Spaceship s: fleet)
			sum += s.getAnnualMaintenanceCost();
		return sum;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> names = new HashSet<>();
		Battleship tmp;
		
		for(Spaceship s: fleet)
			if(s instanceof Battleship) {
				tmp = (Battleship)s;
				addNames(names, tmp.getWeapon());
			}
		return names;
	}

	private static void addNames(Set<String> names, List<Weapon> weapon) {
		for(Weapon w: weapon)
			names.add(w.getName());
		
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int numOfCrew = 0;
		for(Spaceship s: fleet)
			numOfCrew += s.getCrewMembers().size();
		return numOfCrew;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		double sumOfAge = 0.0;
		int numberOfOfficers = 0;
		
		for(Spaceship s: fleet)
			for(CrewMember m: s.getCrewMembers()) {
				if(m.getClass() == Officer.class) {
					numberOfOfficers++;
					sumOfAge+= m.getAge();
				}		
			}
		return (float)sumOfAge/numberOfOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> m = new HashMap<Officer, Spaceship>();
		OfficerRank maxRank = null;
		Officer keepOfficer = null;
		
		for(Spaceship s: fleet) {
			for(CrewMember member: s.getCrewMembers())
				if(member.getClass() ==  Officer.class) {
					if(maxRank == null) {
						maxRank = ((Officer) member).getRank();
						keepOfficer = (Officer) member;
					}
					else
						if(maxRank.compareTo(((Officer) member).getRank()) < 0) {
							maxRank = ((Officer) member).getRank();
							keepOfficer = (Officer) member;
						}
						
				}
			if(maxRank != null) {
				m.put(keepOfficer,s);	
				maxRank = null;
			}
				
		}
		return m;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		List<Map.Entry<OfficerRank, Integer>> listOfRanks = new ArrayList<Map.Entry<OfficerRank, Integer>>();
		Map<OfficerRank, Integer> mapOfRanks = new HashMap<OfficerRank, Integer>();
		Set<Map.Entry<OfficerRank, Integer>> setOfEntrys = new HashSet<Map.Entry<OfficerRank, Integer>>();
		
		for(Spaceship s: fleet) {
			for(CrewMember member: s.getCrewMembers())
				if(member instanceof Officer) {
					if(mapOfRanks.containsKey(((Officer)member).getRank()))
							mapOfRanks.replace(((Officer)member).getRank(), mapOfRanks.get(((Officer)member).getRank()) + 1);
					else
						mapOfRanks.put(((Officer)member).getRank(), 1);
				}
		}
	
		setOfEntrys = mapOfRanks.entrySet();
		listOfRanks.addAll(setOfEntrys);
		Collections.sort(listOfRanks, new entryComparator());
		return listOfRanks;
			

	}

}
