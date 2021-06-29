package processing;


/**
 * Clase Transferencia
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/


public class Transfer {

    private Reservoir from;
    private Reservoir to;
    private double volumeOfWater;
    private double transferRequiredTime;
    
    
    public Transfer (Reservoir from, Reservoir to, double volumeOfWater, double transferRequiredTime) {
        this.setFrom (from);
        this.setTo (to);
        this.setVolumeOfWater (volumeOfWater);
        this.setTransferRequiredTime (transferRequiredTime);
    }

    
    public Reservoir getFrom () {
        return from;
    }
    
    public Reservoir getTo () {
        return to;
    }
    
    public double getVolumeOfWater () {
        return volumeOfWater;
    }
    
    public double getTransferRequiredTime () {
        return transferRequiredTime;
    }


    private void setFrom (Reservoir from) {
    	this.from = from;
    }
    
    private void setTo (Reservoir to) {
    	this.to = to;
    }
    
    private void setVolumeOfWater (double volumeOfWater) {
    	this.volumeOfWater = volumeOfWater;
    }
    
    private void setTransferRequiredTime (double transferRequiredTime) {
        this.transferRequiredTime = transferRequiredTime;
    }
}
