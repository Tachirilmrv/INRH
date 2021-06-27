package processing;

/**
 * Clase Embalse
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/

public class Reservoir implements Comparable{
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


	public void setId (String id) {
		this.id = id;
	}

	public void setMaxCap (double maxCap) {
		this.maxCap = maxCap;
	}

	public void setMinCap (double minCap) {
		this.minCap = minCap;
	}

	public void setWaterLevel (double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public double percentFill(){
		return this.waterLevel/this.maxCap * 100;
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
	public int compareTo(Object o) {
		Reservoir aux = (Reservoir) o;
		return this.getWaterLevel() > aux.getWaterLevel() ? 1 : this.getWaterLevel() < aux.getWaterLevel() ? -1 : 0;
	}
}


	
