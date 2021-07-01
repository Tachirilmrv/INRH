package visual;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import model.visualgraph.VisualNotDirectedGraph;
import processing.HydroNet;
import processing.Reservoir;
import processing.Transfer;
import init.INRH;

public class MainFrame {
	private JMenu riskMenu;
	private JMenu archiveMenu;
	private JFrame elFrame;
	private JTable laTable;
	private JPanel tablePanel;
	private JMenuBar laMenuBar;
	private JTabbedPane elTabPane;
	private DefaultTableModel elDefaultTMod;
	private VisualNotDirectedGraph visualGraph;

	
	public MainFrame () {
		initMainFrame ();
	}

	
	private void initMainFrame () {
		elFrame = new JFrame ("Sistema de gestión de recursos hidráulicos");
		
		initMenus ();
		initGraph ();
		initTable ();
		initTabs ();
		
		elFrame.setJMenuBar (laMenuBar);
		elFrame.getContentPane().add (elTabPane, BorderLayout.CENTER);
				
		try {
			UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | 
				 IllegalAccessException	| UnsupportedLookAndFeelException exception) {
			exception.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI (elFrame);
		elFrame.setPreferredSize (new Dimension (500, 500) );
		elFrame.pack ();
		elFrame.setLocationRelativeTo (null);
		elFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		elFrame.setVisible (true);
	}

	private void initMenus () {
		laMenuBar = new JMenuBar ();
		riskMenu = new JMenu ("Riesgo");
		archiveMenu = new JMenu ("Archivo");

		riskMenu.setMnemonic ('R');
		archiveMenu.setMnemonic ('A');
		
		laMenuBar.add (archiveMenu);
		laMenuBar.add (riskMenu);
		
		initMenuItems ();
	}
	
	private void initMenuItems () {
		JMenuItem exitMItem = new JMenuItem ("Salir");
		JMenuItem exhaustingMItem = new JMenuItem ("Embalses en riesgo de agotamiento");
		JMenuItem overflowMItem = new JMenuItem ("Embalses en riesgo de desbordamiento");
		
		exitMItem.setMnemonic ('S');
		exhaustingMItem.setMnemonic ('G');
		overflowMItem.setMnemonic ('D');
		
		exitMItem.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				System.exit (0);
			}
		} );
		
		exhaustingMItem.addActionListener (new ActionListener() {	
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				initExhaustingAction ();
			}
		} );
		
		overflowMItem.addActionListener (new ActionListener() {		
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				initOverflowingAction ();
			}
		} );
		
		riskMenu.add (exhaustingMItem);
		riskMenu.add (overflowMItem);
		archiveMenu.add (exitMItem);
	}
	
	private void initTabs () {
		elTabPane = new JTabbedPane (JTabbedPane.BOTTOM);
		
		elTabPane.addTab ("Gráfico", null);
		elTabPane.addTab ("Sumario", null);
		
		elTabPane.setComponentAt (0, visualGraph);
		elTabPane.setComponentAt (1, tablePanel);
	}
	
	private void initGraph () {
		INRH.getInstance ().setHydroNet (new HydroNet () );
		visualGraph = new VisualNotDirectedGraph (elFrame.getContentPane ().getWidth () / 2 + 550,
												  elFrame.getContentPane ().getHeight () / 2 + 350);
		
		visualGraph.setGraph (INRH.getInstance ().getHydroNet ().getHydroNet () );
	}
	
	private void initTable () {
		elDefaultTMod = new DefaultTableModel () {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable (int row, int column) {
				return false;
			}
		};	
		tablePanel = new JPanel ();
		laTable = new JTable (elDefaultTMod);
		
		
		fillTable ();
		
		
		tablePanel.setLayout (new CardLayout () );
		tablePanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createTitledBorder ("Sumario de embalses") ) );
		
		tablePanel.add (new JScrollPane (laTable) );
	}
	
	private void fillTable () {
		LinkedList <Vertex> vert = INRH.getInstance ().getHydroNet ().getHydroNet ().getVerticesList ();

		elDefaultTMod.addColumn ("Embalse");
		elDefaultTMod.addColumn ("Capacidad Mínima");
		elDefaultTMod.addColumn ("Capacidad Máxima");
		elDefaultTMod.addColumn ("Nivel de agua");
		elDefaultTMod.addColumn ("Porciento de llenado");
		
		elDefaultTMod.setRowCount (0);
		
		for (Vertex v: vert) {
			Reservoir r = (Reservoir) v.getInfo ();
			
			elDefaultTMod.addRow (new Object [] {r.getId (), r.getMinCap (), r.getMaxCap (),
												 r.getWaterLevel (), String.format ("%.2f%c", r.getfillPercent (), '%' ) } );
		}
	}
 	
	private void initExhaustingAction () {
		Vertex [] exhaustingReservoirs = INRH.getInstance ().getHydroNet ().getExhaustingReservoirs ().toArray (new Vertex [INRH.getInstance ().getHydroNet ().getExhaustingReservoirs ().size () ] );
		Reservoir [] exhaustingArray = new Reservoir [exhaustingReservoirs.length];
		
		for (int i = 0; i < exhaustingReservoirs.length; i++) {
			exhaustingArray [i] = (Reservoir) exhaustingReservoirs [i].getInfo ();
		}
		
		JFrame exhaustingIFrame = new JFrame ("Buscar embalses en riesgo de agotamiento");
		JPanel exhaustingPanel = new JPanel ();
		JLabel exhaustingLabel = new JLabel ("Seleccione un embalse: ");
		JButton exhaustingButton = new JButton ("Eliminar riesgo");
		JComboBox <Reservoir> exhaustingCBox = new JComboBox <> (exhaustingArray);
		
		
		exhaustingButton.addActionListener (new ActionListener() {	
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				ArrayList <Transfer> transList = INRH.getInstance ().getHydroNet ().eliminateExhaustingRisk (exhaustingReservoirs [exhaustingCBox.getSelectedIndex () ] );
				String message = "";
				
				if (!transList.isEmpty () ) { 					
					for (int i = 0; i < transList.size (); i++) {
						Transfer t = transList.get (i);
						
						message = String.format ("Transferencias sugeridas: \n"
											   + "%d) %.2f m3 desde %s", 
												 i + 1, t.getVolumeOfWater (), t.getFrom () ) ;
					}
				} else {
					message = "No hay disponibilidad en los embalses cercanos como para eliminar el riesgo";
				}
				
				JOptionPane.showMessageDialog (exhaustingIFrame, message);
			}
		} );
		
		
		exhaustingPanel.add (exhaustingLabel, BorderLayout.WEST);
		exhaustingPanel.add (exhaustingCBox, BorderLayout.CENTER);
		exhaustingPanel.add (exhaustingButton, BorderLayout.EAST);
		
		exhaustingPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createTitledBorder ("Embalses con riesgo de agotamiento") ) ); 
		
		
		exhaustingIFrame.setContentPane (exhaustingPanel);
		exhaustingIFrame.pack ();
		exhaustingIFrame.setLocationRelativeTo (elFrame);
		exhaustingIFrame.setVisible (true);
	}
	
	private void initOverflowingAction () {
		Vertex [] overflowingReservoirs = INRH.getInstance ().getHydroNet ().getOverflowingReservoirs ().toArray (new Vertex [INRH.getInstance ().getHydroNet ().getOverflowingReservoirs ().size () ] );
		Reservoir [] overflowingArray = new Reservoir [overflowingReservoirs.length];
		
		for (int i = 0; i < overflowingReservoirs.length; i++) {
			overflowingArray [i] = (Reservoir) overflowingReservoirs [i].getInfo ();
		}
		
		JFrame overflowingIFrame = new JFrame ("Buscar embalses en riesgo de desbordamiento");
		JPanel overflowingPanel = new JPanel ();
		JLabel overflowingLabel = new JLabel ("Seleccione un embalse: ");
		JButton overflowingButton = new JButton ("Eliminar riesgo");
		JComboBox <Reservoir> overflowingCBox = new JComboBox <> (overflowingArray);
		
		
		overflowingButton.addActionListener (new ActionListener() {	
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				ArrayList <Transfer> transList = INRH.getInstance ().getHydroNet ().eliminateOverflowingRisk (overflowingReservoirs [overflowingCBox.getSelectedIndex () ] );
				String message = "";
				
				if (!transList.isEmpty () ) { 					
					for (int i = 0; i < transList.size (); i++) {
						Transfer t = transList.get (i);
						
						message = String.format ("Transferencias sugeridas: \n"
											   + "%d) %.2f m3 hacia %s en un tiempo aproximado de %.2f minutos", 
												 i + 1, t.getVolumeOfWater (), t.getTo (),  t.getTransferRequiredTime () / 60) ;
					}
				} else {
					message = "No hay disponibilidad en los embalses cercanos como para eliminar el riesgo";
				}
				
				JOptionPane.showMessageDialog (overflowingIFrame, message);
			}
		} );
	
		
		overflowingPanel.add (overflowingLabel, BorderLayout.WEST);
		overflowingPanel.add (overflowingCBox, BorderLayout.CENTER);
		overflowingPanel.add (overflowingButton, BorderLayout.EAST);
		
		overflowingPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createTitledBorder ("Embalses con riesgo de desbordamiento") ) ); 
		
		
		overflowingIFrame.setContentPane (overflowingPanel);
		overflowingIFrame.pack ();
		overflowingIFrame.setLocationRelativeTo (elFrame);
		overflowingIFrame.setVisible (true);
	}
 }
