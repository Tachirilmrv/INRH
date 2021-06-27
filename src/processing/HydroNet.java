package processing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

/**
 * Clase Red Hidráulica
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/

public class HydroNet {
	ILinkedNotDirectedGraph hydroNet;
	
	public HydroNet () {
		initHydroNet ();
	}

	public void reservoirsExahustion(){
		Iterator<Vertex> iter = this.hydroNet.getVerticesList().iterator();

		while(iter.hasNext()){
			Vertex v = iter.next();
			if(((Reservoir)v.getInfo()).getWaterLevel() < ((Reservoir)v.getInfo()).getMinCap()){
				deleteRisk(v);
			}
		}
	}


	private void deleteRisk(Vertex v) {
		LinkedList<Reservoir> reservoirs = new LinkedList<Reservoir>(); 

		Iterator<Vertex> iterator = v.getAdjacents().iterator();
		while (iterator.hasNext()) {
			reservoirs.offer((Reservoir)iterator.next().getInfo());
		}
		
		
	}

	public ILinkedNotDirectedGraph getHydroNet () {
		return hydroNet;
	}
	
	
	public void setHydroNet (ILinkedNotDirectedGraph hydroNet) {
		this.hydroNet = hydroNet;
	}

	private void initHydroNet () {
		hydroNet = new LinkedGraph ();
		
		hydroNet.insertVertex (new Reservoir ("El Punto", 870903, 561994, 64492) );
		hydroNet.insertVertex (new Reservoir ("Guama", 46564, 22313, 34855) );
		hydroNet.insertVertex (new Reservoir ("El Patate", 521584, 103479, 190034) );
		hydroNet.insertVertex (new Reservoir ("San Julian", 659920,  58586, 75470) );
		hydroNet.insertVertex (new Reservoir ("Bahia Honda", 757475, 93463, 149541) );
		hydroNet.insertVertex (new Reservoir ("Mosquito", 204705, 16179, 145425) );
		hydroNet.insertVertex (new Reservoir ("El Bambu", 316522, 34017, 118090) );
		hydroNet.insertVertex (new Reservoir ("Ranier", 174320, 28967, 99424) );
		hydroNet.insertVertex (new Reservoir ("Jaruco", 7110, 3377, 5899) );
		hydroNet.insertVertex (new Reservoir ("Victoria", 865017, 100228, 286442) );
		hydroNet.insertVertex (new Reservoir ("Cuanavaco", 978509, 76098, 605105) );
		hydroNet.insertVertex (new Reservoir ("Cimarrones", 112384, 54848, 68943) );
		hydroNet.insertVertex (new Reservoir ("Las Brisas", 476440, 82078, 123411) );
		hydroNet.insertVertex (new Reservoir ("Palma Sola", 622175, 102462, 161363) );
		hydroNet.insertVertex (new Reservoir ("Voladura", 93600, 19189, 37771) );
		hydroNet.insertVertex (new Reservoir ("El Salto", 905240, 35526, 186654) );
		hydroNet.insertVertex (new Reservoir ("Los Leones", 666854, 86200, 174928) );
		hydroNet.insertVertex (new Reservoir ("Alacranes", 497591, 249698, 313153) );
		hydroNet.insertVertex (new Reservoir ("Damiji", 795920, 460252, 746977) );
		hydroNet.insertVertex (new Reservoir ("Palmarito", 444083, 81910, 362247) );
		hydroNet.insertVertex (new Reservoir ("El Negrito", 995000, 553423, 650993) );
		hydroNet.insertVertex (new Reservoir ("Hanabanilla", 816936, 1777, 2514) );
		hydroNet.insertVertex (new Reservoir ("Higuanojo", 934280, 629, 339866) );
		hydroNet.insertVertex (new Reservoir ("Zaza", 1621971, 235618, 714975) );
		hydroNet.insertVertex (new Reservoir ("El Calvario", 665281, 236970, 318629) );
		hydroNet.insertVertex (new Reservoir ("Siguaney", 160913, 22759, 151819) );
		hydroNet.insertVertex (new Reservoir ("El Nispero", 633208, 1103, 6733) );
		
		hydroNet.insertEdgeNDG (0, 1);
		hydroNet.insertEdgeNDG (0, 2);
		hydroNet.insertEdgeNDG (1, 2);
		hydroNet.insertEdgeNDG (2, 3);
		hydroNet.insertEdgeNDG (3, 4);
		hydroNet.insertEdgeNDG (4, 5);
		hydroNet.insertEdgeNDG (5, 6);
		hydroNet.insertEdgeNDG (5, 7);
		hydroNet.insertEdgeNDG (6, 7);
		hydroNet.insertEdgeNDG (6, 8);
		hydroNet.insertEdgeNDG (7, 8);
		hydroNet.insertEdgeNDG (7, 9);
		hydroNet.insertEdgeNDG (8, 9);
		hydroNet.insertEdgeNDG (8, 10);
		hydroNet.insertEdgeNDG (9, 10);
		hydroNet.insertEdgeNDG (10, 11);
		hydroNet.insertEdgeNDG (11, 12);
		hydroNet.insertEdgeNDG (12, 13);
		hydroNet.insertEdgeNDG (12, 14);	
		hydroNet.insertEdgeNDG (14, 15);
		hydroNet.insertEdgeNDG (15, 16);
		hydroNet.insertEdgeNDG (15, 18);
		hydroNet.insertEdgeNDG (15, 19);
		hydroNet.insertEdgeNDG (16, 17);
		hydroNet.insertEdgeNDG (19, 20);
		hydroNet.insertEdgeNDG (20, 21);
		hydroNet.insertEdgeNDG (21, 22);
		hydroNet.insertEdgeNDG (22, 23);
		hydroNet.insertEdgeNDG (23, 24);
		hydroNet.insertEdgeNDG (23, 25);
		hydroNet.insertEdgeNDG (24, 25);
		hydroNet.insertEdgeNDG (25, 26);
	}
}
