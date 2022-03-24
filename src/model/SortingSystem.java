package model;

import java.util.ArrayList;
import java.util.Collections;

public class SortingSystem {
	ArrayList<Country> countries;

	public SortingSystem() {
		countries = new ArrayList<>();		
	}
	
	public void addCountry(String name, int mGold, int mSilver, int mBronze, int fGold, int fSilver, int fBronze) {
		countries.add(new Country(name, mGold, mSilver, mBronze, fGold, fSilver, fBronze));
	}
	
	public String getListM() { // Se usa la clase comparator
		Collections.sort(countries, new ComparatorM());
		String s = "";
		for (Country c : countries) {
			s+=c.toStringM();
		}
		return s;
	}
	
	public String getListF() { // Se usa la interfaz comparable
		Collections.sort(countries);
		String s = "";
		for (Country c : countries) {
			s+=c.toStringF();
		}
		return s;
	}
	
	public String getListC() { // Se usa una adaptación de sorting manual (insertion)
		int n = countries.size();
		for (int i = 1; i < n; ++i) {
			Country key = countries.get(i);
		    int j = i - 1;
		    while (j >= 0 && countries.get(i).isGreaterThan(key)) {
		    	countries.set(j+1, countries.get(j));
		        j = j - 1;
		    }
		    countries.set(j+1, key);
		}
		
		String s = "";
		for (Country c : countries) {
			s+=c.toString();
		}
		return s;
	}
}
