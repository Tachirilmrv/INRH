package init;
import java.awt.EventQueue;

import processing.HydroNet;
import visual.MainFrame;


/**
 * Clase Controladora INRH
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/


public class INRH {
	private static INRH inrh;
	private HydroNet laHydroNet;
	
	
	
	public static void main (String [] args) {
		EventQueue.invokeLater (new Runnable () {
			public void run () {
				try {
					 new MainFrame ();
				} catch (Exception exception) {
					exception.printStackTrace ();
				}
			}
		} );
	}
	
	
	
	public static INRH getInstance () {
		if (inrh == null)
			inrh = new INRH ();
		return inrh;
	}
	
	public HydroNet getHydroNet () {
		return getInstance ().laHydroNet;
	}
	
	
	public void setHydroNet (HydroNet hydroNet) {
		getInstance ().laHydroNet = hydroNet;
	}
}
