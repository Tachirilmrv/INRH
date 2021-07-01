package processing;

import java.util.ArrayList;
import java.util.LinkedList;


import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
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
	

	public ILinkedWeightedEdgeNotDirectedGraph getHydroNet () {
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
		
		hydroNet.insertWEdgeNDG (0, 1, new Pipe (24882, 2, 12481) );
		hydroNet.insertWEdgeNDG (0, 2, new Pipe (38047, 1, 38047) );
		hydroNet.insertWEdgeNDG (1, 2, new Pipe (26499, 1, 26499) );
		hydroNet.insertWEdgeNDG (2, 3, new Pipe (48291, 3, 16097) );
		hydroNet.insertWEdgeNDG (3, 4, new Pipe (91942, 3, 30647.3) );
		hydroNet.insertWEdgeNDG (4, 5, new Pipe (91593, 5, 18318.6) );
		hydroNet.insertWEdgeNDG (5, 6, new Pipe (86706, 2, 43353) );
		hydroNet.insertWEdgeNDG (5, 7, new Pipe (96180, 2, 48090) );
		hydroNet.insertWEdgeNDG (6, 7, new Pipe (18526, 2, 9263) );
		hydroNet.insertWEdgeNDG (6, 8, new Pipe (1586, 3, 528.6) );
		hydroNet.insertWEdgeNDG (7, 8, new Pipe (29104, 2, 14552) );
		hydroNet.insertWEdgeNDG (7, 9, new Pipe (23535, 3, 7845) );
		hydroNet.insertWEdgeNDG (8, 9, new Pipe (41485, 4, 10371.2) );
		hydroNet.insertWEdgeNDG (8, 10, new Pipe (707, 2, 353.5) );
		hydroNet.insertWEdgeNDG (9, 10, new Pipe (60998, 2, 30499) );
		hydroNet.insertWEdgeNDG (10, 11, new Pipe (81271, 2, 40635.5) );
		hydroNet.insertWEdgeNDG (11, 12, new Pipe (75013, 4, 18753.2) );
		hydroNet.insertWEdgeNDG (12, 13, new Pipe (8703, 2, 4351.5) );
		hydroNet.insertWEdgeNDG (12, 14, new Pipe (73457, 4, 18364.2) );	
		hydroNet.insertWEdgeNDG (14, 15, new Pipe (83979, 3, 27993) );
		hydroNet.insertWEdgeNDG (15, 16, new Pipe (19773, 5, 3945.6) );
		hydroNet.insertWEdgeNDG (15, 18, new Pipe (15081, 2, 7540.5) );
		hydroNet.insertWEdgeNDG (15, 19, new Pipe (38162, 1, 38162) );
		hydroNet.insertWEdgeNDG (16, 17, new Pipe (21312, 3, 7104) );
		hydroNet.insertWEdgeNDG (19, 20, new Pipe (10654, 1, 10654) );
		hydroNet.insertWEdgeNDG (20, 21, new Pipe (52837, 3, 17612.3) );
		hydroNet.insertWEdgeNDG (21, 22, new Pipe (77746, 2, 38873) );
		hydroNet.insertWEdgeNDG (22, 23, new Pipe (70063, 3, 23354.3) );
		hydroNet.insertWEdgeNDG (23, 24, new Pipe (87185, 1, 87185) );
		hydroNet.insertWEdgeNDG (23, 25, new Pipe (85000, 1, 85000) );
		hydroNet.insertWEdgeNDG (24, 25, new Pipe (39368, 4, 9842) );
		hydroNet.insertWEdgeNDG (25, 26, new Pipe (11721, 4, 2930.2) );
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
			double availableWater = reservoirs.get (i).getAvaliableWater ();
			
			if (availableWater > 0) {
				if (diff > availableWater) {
					diff -= reservoirs.get (i).getAvaliableWater ();
					
					transfers.add (new Transfer (reservoirs.get (i), riskingReservoir, reservoirs.get (i).getAvaliableWater (), Double.NaN) );
				} else {				
					transfers.add (new Transfer (reservoirs.get (i), riskingReservoir, diff, Double.NaN) );
					
					diff = 0;
				}
			}
		}
		
		return transfers;
	}
	
	public ArrayList <Transfer> eliminateOverflowingRisk (Object selectedItem) {
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

		double volumeOfWater = riskingReservoir.getWaterLevel () - (0.95 * riskingReservoir.getMaxCap () );

		for (int i = 0; volumeOfWater > 0 && i < links.size (); i++) {
			double volumeCanAssimilate = 0.90 * reservoirs.get (i).getMaxCap () - reservoirs.get (i).getWaterLevel ();
			Pipe p = getPipe (vertex, links.get (i) );
			
			if (volumeCanAssimilate > 0) {
				if (volumeOfWater > volumeCanAssimilate && volumeCanAssimilate > 0) {
					volumeOfWater -= volumeCanAssimilate;

					transfers.add (new Transfer (riskingReservoir, reservoirs.get (i), volumeCanAssimilate, p.getRequiredTime () * volumeCanAssimilate / 10000) );
				} else if (volumeOfWater <= volumeCanAssimilate && volumeCanAssimilate > 0) {				
					transfers.add (new Transfer (riskingReservoir, reservoirs.get (i), volumeCanAssimilate, p.getRequiredTime () * volumeCanAssimilate / 10000) );

					volumeOfWater = 0;
				}
			}
		}

		return transfers;
	}

	private Pipe getPipe (Vertex from, Vertex to) {
		LinkedList <Edge> toPipes = to.getEdgeList ();
		Reservoir fromR = (Reservoir) from.getInfo ();
		Pipe result = null;
		
		for (int i = 0; i < toPipes.size (); i++) {
			WeightedEdge toWe = (WeightedEdge) toPipes.get (i);
			Reservoir toR = (Reservoir) toWe.getVertex ().getInfo ();
			
			if (fromR.equals (toR) ) {
				WeightedEdge we = (WeightedEdge) toPipes.get (i);
				result = (Pipe) we.getWeight ();
				
				break;
			}
		}
		
		return result;
	}
}
