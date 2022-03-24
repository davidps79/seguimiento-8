package model;

import java.util.Comparator;

public class ComparatorM implements Comparator<Country> {
	@Override
	public int compare(Country o1, Country o2) {
		int aux = -1;
		if (o1.getmGold() > o2.getmGold()) {
			aux = 1;
		} else if (o1.getmGold() == o2.getmGold()) {
			if (o1.getmSilver() > o2.getmSilver()) {
				aux = 1;
			} else if (o1.getmSilver() == o2.getmSilver()) {
				if (o1.getmBronze() > o2.getmBronze()) {
					aux = 1;
				} else if (o1.getmBronze() > o2.getmBronze()) {
					aux = 1;
				} else if (o1.getmBronze() == o2.getmBronze()) {
					aux = o1.getName().compareTo(o2.getName()) * -1;;
				}
			}
		}
		
		return aux*-1;
	}

}
