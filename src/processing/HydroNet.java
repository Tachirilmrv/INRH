package processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;


/**
 * Clase Red Hidráulica
 * @author Jorge Miguel Haidar Martínez, Lázaro Michel Reyes Valdés
 * Inf. 22 #15 # 24
 **/

public class HydroNet {
	ILinkedWeightedEdgeNotDirectedGraph hydroNet;
	
	public HydroNet () {
		initHydroNet ();
		
	}	
	

	public ILinkedNotDirectedGraph getHydroNet () {
		return hydroNet;
	}
	
	
	public void setHydroNet (ILinkedWeightedEdgeNotDirectedGraph hydroNet) {
		this.hydroNet = hydroNet;
	}

	private void initHydroNet () {
		hydroNet = new LinkedGraph ();
		
		hydroNet.insertVertex (new Reservoir ("El Punto", 870903, 561994, 342900) );
		hydroNet.insertVertex (new Reservoir ("Guama", 461564, 22313, 524582) );
		hydroNet.insertVertex (new Reservoir ("El Patate", 521584, 103479, 56415) );
		hydroNet.insertVertex (new Reservoir ("San Julian", 659920,  58586, 554125) );
		hydroNet.insertVertex (new Reservoir ("Bahia Honda", 757475, 93463, 791362) );
		hydroNet.insertVertex (new Reservoir ("Mosquito", 204705, 16179, 62562) );
		hydroNet.insertVertex (new Reservoir ("El Bambu", 316522, 34017, 596236) );
		hydroNet.insertVertex (new Reservoir ("Ranier", 674320, 28967, 740543) );
		hydroNet.insertVertex (new Reservoir ("Jaruco", 7110, 3377, 2189) );
		hydroNet.insertVertex (new Reservoir ("Victoria", 865017, 100228, 314223) );
		hydroNet.insertVertex (new Reservoir ("Cuanavaco", 978509, 76098, 373139) );
		hydroNet.insertVertex (new Reservoir ("Cimarrones", 112384, 54848, 36858) );
		hydroNet.insertVertex (new Reservoir ("Las Brisas", 476440, 82078, 744631) );
		hydroNet.insertVertex (new Reservoir ("Palma Sola", 622175, 102462, 580755) );
		hydroNet.insertVertex (new Reservoir ("Voladura", 93600, 19189, 177637) );
		hydroNet.insertVertex (new Reservoir ("El Salto", 905240, 35526, 362571) );
		hydroNet.insertVertex (new Reservoir ("Los Leones", 666854, 86200, 487725) );
		hydroNet.insertVertex (new Reservoir ("Alacranes", 497591, 249698, 161333) );
		hydroNet.insertVertex (new Reservoir ("Damiji", 795920, 460252, 936145) );
		hydroNet.insertVertex (new Reservoir ("Palmarito", 444083, 81910, 667841) );
		hydroNet.insertVertex (new Reservoir ("El Negrito", 995000, 553423, 556274) );
		hydroNet.insertVertex (new Reservoir ("Hanabanilla", 816936, 1777, 993289) );
		hydroNet.insertVertex (new Reservoir ("Higuanojo", 934280, 629, 339866) );
		hydroNet.insertVertex (new Reservoir ("Zaza", 1621971, 235618, 714975) );
		hydroNet.insertVertex (new Reservoir ("El Calvario", 665281, 236970, 94713) );
		hydroNet.insertVertex (new Reservoir ("Siguaney", 160913, 22759, 75085) );
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

	public LinkedList <Vertex> getExhaustingReservoirs () {
		LinkedList <Vertex> exhaustedReservoirs = new LinkedList <> ();
		
		for (Vertex vertex : hydroNet.getVerticesList () ) {
			Reservoir r = (Reservoir) vertex.getInfo ();
			
			if (r.isExhausted () ) {
				exhaustedReservoirs.add (vertex);
			}
		}
		
		return exhaustedReservoirs;
	}
	
	public LinkedList <Vertex> getOverflowingReservoirs () {
		LinkedList <Vertex> overflodedReservoirs = new LinkedList <> ();
		
		for (Vertex vertex : hydroNet.getVerticesList () ) {
			Reservoir r = (Reservoir) vertex.getInfo ();
			
			if (r.isOverfloded () ) {
				overflodedReservoirs.add (vertex);
			}
		}
		
		return overflodedReservoirs;
	}

	public ArrayList <Transfer> eliminateExhaustingRisk (Object selectedItem) {
		Vertex vertex = (Vertex) selectedItem;
		Reservoir riskingReservoir = (Reservoir) vertex.getInfo ();
		LinkedList <Vertex> links = vertex.getAdjacents ();
		LinkedList <Reservoir> reservoirs = new LinkedList <> ();
		ArrayList <Transfer> transfers = new ArrayList <Transfer> (links.size () );
		
		for (Vertex l : links) {
			Reservoir r = (Reservoir) l.getInfo ();
			
			reservoirs.add (r);
		}
		
		reservoirs.sort (null);

		double diff = riskingReservoir.getMinCap () - riskingReservoir.getWaterLevel ();

		for (int i = reservoirs.size () - 1; diff > 0 && i > 0; i--) {
			if (diff > reservoirs.get (i).getAvaliableWater () ) {
				diff -= reservoirs.get (i).getAvaliableWater ();
				
				transfers.add (new Transfer (reservoirs.get (i), riskingReservoir, reservoirs.get (i).getAvaliableWater (), Double.NaN) );
			} else {				
				transfers.add (new Transfer (reservoirs.get (i), riskingReservoir, diff, Double.NaN) );
				
				diff = 0;
			}
		}
		
		return transfers;
	}
	
	public ArrayList<Transfer> eliminateOverflowingRisk (Object selectedItem) {
		Vertex v = new Vertex (selectedItem);
		Reservoir riskingReservoir = (Reservoir) selectedItem;
		
		ArrayList<Reservoir> reservoirs = new ArrayList<Reservoir>(v.getAdjacents().size());
		reservoirs.sort(null);

		ArrayList<Transfer> transfers = new ArrayList<Transfer>(v.getAdjacents().size());

		double volumeOfWater = riskingReservoir.getWaterLevel() - (0.98 * riskingReservoir.getMaxCap());

		for (int i = 0; volumeOfWater > 0 && i > 0; i++) {
			double volumeCanAssimilate = 0.90 * reservoirs.get (i).getMaxCap() - reservoirs.get(i).getWaterLevel();
			Pipe p = (Pipe) getPipe(v, reservoirs.get(i)).getWeight();
			if (volumeOfWater > volumeCanAssimilate) {
				volumeOfWater -= volumeCanAssimilate;
				transfers.add (new Transfer (riskingReservoir, reservoirs.get (i), volumeCanAssimilate, p.getRequiredTime() * volumeCanAssimilate));
			} else {				
				transfers.add (new Transfer (riskingReservoir, reservoirs.get (i), volumeCanAssimilate, p.getRequiredTime() * volumeCanAssimilate) );
				volumeOfWater= 0;
			}
		}

		return transfers;
	}

	private WeightedEdge getPipe (Vertex from, Reservoir to) {
		LinkedList <Edge> pipe = from.getEdgeList();

		Iterator <Edge> iterator = pipe.iterator ();
		Edge result = null;
		
		while (iterator.hasNext() && result == null) {
			Edge e = iterator.next();
			
			if (e.getVertex ().getInfo() == to){
				result = e;
			}
		}
		return (WeightedEdge) result;
	}

	
}
