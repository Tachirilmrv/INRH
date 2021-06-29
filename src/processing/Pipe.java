package processing;


/**
 * Clase Tubería
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/


public class Pipe {
    
    private double length;
    private double radio;
    private double requiredTime; //en segundos
    
    public Pipe(double length, double radio, double requiredTime) {
        this.setLength(length);
        this.setRadio(radio);
        this.setRequiredTime(requiredTime);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        this.length = length;
    }

    public double getRadio() {
        return radio;
    }

    private void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRequiredTime() {
        return requiredTime;
    }

    private void setRequiredTime(double requiredTime) {
        this.requiredTime = requiredTime;
    }

    public double getTransferRequiredTime(double volumeOfWater){
        return this.requiredTime * volumeOfWater;
    }




}
