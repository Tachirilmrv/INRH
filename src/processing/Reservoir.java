package processing;

/**
 * Clase Embalse
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/

public class Reservoir implements Comparable {
	private String id;
	private double maxCap;
	private double minCap;
	private double waterLevel;
	
	
	public Reservoir (String id, double maxCap, double minCap, double waterLevel) {
		setId (id);
		setMaxCap (maxCap);
		setMinCap (minCap);
		setWaterLevel (waterLevel);
	}
	
	
	public String getId () {
		return id;
	}

	public double getMaxCap () {
		return maxCap;
	}

	public double getMinCap () {
		return minCap;
	}

	public double getWaterLevel () {
		return waterLevel;
	}
	
	public boolean isExhausted () {
		return waterLevel < minCap;
	}
	
	public boolean isOverfloded () {
		return waterLevel > maxCap;
	}
	

	private void setId (String id) {
		this.id = id;
	}

	private void setMaxCap (double maxCap) {
		this.maxCap = maxCap;
	}

	private void setMinCap (double minCap) {
		this.minCap = minCap;
	}

	private void setWaterLevel (double waterLevel) {
		this.waterLevel = waterLevel;
	}
	

	public double getfillPercent () {
		return getWaterLevel () * 100 / getMaxCap ();
	}

	public double getAvaliableWater (){
		return getWaterLevel () - getMinCap ();
	}

	public void transferWater (double volumeOfWater) {
		setWaterLevel (getWaterLevel () + volumeOfWater);
	}

	@Override
	public boolean equals (Object obj) {
		Reservoir reservoir = (Reservoir) obj;
		
		return reservoir.getId ().equalsIgnoreCase (id);
	}
	
	@Override
	public String toString () {
		return getId ();
	}


	@Override
	public int compareTo (Object obj) {
		Reservoir r = (Reservoir) obj;
		
		return this.getfillPercent() > r.getfillPercent () ? 1 : this.getfillPercent () < r.getfillPercent() ? -1 : 0;
	}
}


	
