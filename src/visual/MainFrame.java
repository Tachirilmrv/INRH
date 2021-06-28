package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.visualgraph.VisualNotDirectedGraph;
import processing.HydroNet;
import processing.Reservoir;

public class MainFrame {
	private JMenu riskMenu;
	private JMenu archiveMenu;
	private JFrame elFrame;
	private JMenuBar laMenuBar;
	private HydroNet laHydroNet;
	private JTabbedPane elTabPane;
	private VisualNotDirectedGraph visualGraph;

	
	public static void main (String [] args) {
		EventQueue.invokeLater (new Runnable () {
			public void run () {
				try {
					MainFrame window = new MainFrame ();
				} catch (Exception exception) {
					exception.printStackTrace ();
				}
			}
		} );
	}


	public MainFrame () {
		initMainFrame ();
	}

	
	private void initMainFrame () {
		elFrame = new JFrame ("Sistema de gestión de recursos hidráulicos");
		
		initMenus ();
		initGraph ();
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
	}
	
	private void initGraph () {
		laHydroNet = new HydroNet ();
		visualGraph = new VisualNotDirectedGraph (elFrame.getContentPane ().getWidth () / 2 + 550,
												  elFrame.getContentPane ().getHeight () / 2 + 350);
		
		visualGraph.setGraph (laHydroNet.getHydroNet () );
	}
	
	private void initExhaustingAction () {
		Object [] exhaustingReservoirs = laHydroNet.getExhaustingReservoirs ().toArray ();
		Reservoir [] exhaustingArray = new Reservoir [exhaustingReservoirs.length];
		
		for (int i = 0; i < exhaustingReservoirs.length; i++) {
			exhaustingArray [i] = (Reservoir) exhaustingReservoirs [i];
		}
		
		JFrame exhaustingIFrame = new JFrame ("Buscar embalses en riesgo de agotamiento");
		JPanel exhaustingPanel = new JPanel ();
		JLabel exhaustingLabel = new JLabel ("Seleccione un embalse: ");
		JButton exhaustingButton = new JButton ("Eliminar riesgo");
		JComboBox <Reservoir> exhaustingCBox = new JComboBox <> (exhaustingArray);
		
		
		exhaustingButton.addActionListener (new ActionListener() {	
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				laHydroNet.eliminateExhaustingRisk (exhaustingCBox.getSelectedItem () );
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
		Object [] overflowingReservoirs = laHydroNet.getOverflowingReservoirs ().toArray ();
		Reservoir [] overflowingArray = new Reservoir [overflowingReservoirs.length];
		
		for (int i = 0; i < overflowingReservoirs.length; i++) {
			overflowingArray [i] = (Reservoir) overflowingReservoirs [i];
		}
		
		JFrame overflowingIFrame = new JFrame ("Buscar embalses en riesgo de desbordamiento");
		JPanel overflowingPanel = new JPanel ();
		JLabel overflowingLabel = new JLabel ("Seleccione un embalse: ");
		JButton overflowingButton = new JButton ("Eliminar riesgo");
		JComboBox <Reservoir> overflowingCBox = new JComboBox <> (overflowingArray);
		
		
		overflowingButton.addActionListener (new ActionListener() {	
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				laHydroNet.eliminateOverflowingRisk (overflowingCBox.getSelectedItem () );
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
