package model;

public class Country implements Comparable<Country>{
	public String getName() {
		return name;
	}

	public int getmGold() {
		return mGold;
	}

	public int getmSilver() {
		return mSilver;
	}

	public int getmBronze() {
		return mBronze;
	}

	public int getfGold() {
		return fGold;
	}

	public int getfSilver() {
		return fSilver;
	}

	public int getfBronze() {
		return fBronze;
	}

	public int getcGold() {
		return cGold;
	}

	public int getcSilver() {
		return cSilver;
	}

	public int getcBronze() {
		return cBronze;
	}

	private String name;
	private int mGold;
	private int mSilver;
	private int mBronze;
	private int fGold;
	private int fSilver;
	private int fBronze;
	private int cGold;
	private int cSilver;
	private int cBronze;
	
	public Country(String name, int mGold, int mSilver, int mBronze, int fGold, int fSilver, int fBronze) {
		this.name = name;
		this.mGold = mGold;
		this.mSilver = mSilver;
		this.mBronze = mBronze;
		this.fGold = fGold;
		this.fSilver = fSilver;
		this.fBronze = fBronze;
		this.cGold = mGold + fGold;
		this.cSilver = mSilver + fSilver;
		this.cBronze = mBronze+ fBronze;
	}
	
	@Override
	public int compareTo(Country o2) {
		int aux = -1;
		if (this.getfGold() > o2.getfGold()) {
			aux = 1;
		} else if (this.getfGold() == o2.getfGold()) {
			if (this.getfSilver() > o2.getfSilver()) {
				aux = 1;
			} else if (this.getfSilver() == o2.getfSilver()) {
				if (this.getfBronze() > o2.getfBronze()) {
					aux = 1;
				} else if (this.getfBronze() > o2.getfBronze()) {
					aux = 1;
				} else if (this.getfBronze() == o2.getfBronze()) {
					aux = this.getName().compareTo(o2.getName()) * -1;
				}
			}
		}
		
		return aux;
	}
	
	public boolean isGreaterThan(Country o2) {
		int aux = -1;
		if (this.getcGold() > o2.getcGold()) {
			aux = 1;
		} else if (this.getcGold() == o2.getcGold()) {
			if (this.getcSilver() > o2.getcSilver()) {
				aux = 1;
			} else if (this.getcSilver() == o2.getcSilver()) {
				if (this.getcBronze() > o2.getcBronze()) {
					aux = 1;
				} else if (this.getcBronze() > o2.getcBronze()) {
					aux = 1;
				} else if (this.getcBronze() == o2.getcBronze()) {
					aux = this.getName().compareTo(o2.getName()) * -1;;
				}
			}
		}
		
		aux*=-1;
		
		return aux>0?true:false;
	}

	
	@Override
	public String toString() {
		return name + " " + cGold + " " + cSilver + " " + cBronze +"\n"; 
	}
	
	public String toStringM() {
		return name + " " + mGold + " " + mSilver + " " + mBronze +"\n"; 
	}
	
	public String toStringF() {
		return name + " " + fGold + " " + fSilver + " " + fBronze +"\n"; 
	}
}
