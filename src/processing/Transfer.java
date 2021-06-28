package processing;

public class Transfer {

    private Reservoir from;
    private Reservoir to;
    private double volumeOfWater;
    private double transferRequiredTime;
    
    public Transfer(Reservoir from, Reservoir to, double volumeOfWater, double transferRequiredTime) {
        this.setFrom(from);
        this.setTo(to);
        this.setVolumeOfWater(volumeOfWater);
        this.setTransferRequiredTime(transferRequiredTime);
    }

    public double getTransferRequiredTime() {
        return transferRequiredTime;
    }

    private void setTransferRequiredTime(double transferRequiredTime) {
        this.transferRequiredTime = transferRequiredTime;
    }

    public double getVolumeOfWater() {
        return volumeOfWater;
    }

    private void setVolumeOfWater(double volumeOfWater) {
        this.volumeOfWater = volumeOfWater;
    }

    public Reservoir getTo() {
        return to;
    }

    private void setTo(Reservoir to) {
        this.to = to;
    }

    public Reservoir getFrom() {
        return from;
    }

    private void setFrom(Reservoir from) {
        this.from = from;
    }

    
    
}
