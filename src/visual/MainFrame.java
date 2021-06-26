package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.visualgraph.VisualNotDirectedGraph;
import processing.HydroNet;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class MainFrame {
	private JMenu archiveMenu;
	private JFrame elFrame;
	private JMenuBar laMenuBar;
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
		archiveMenu = new JMenu ("Archivo");
		
		archiveMenu.setMnemonic ('A');
		laMenuBar.add (archiveMenu);
		
		initMenuItems ();
	}
	
	private void initMenuItems () {
		JMenuItem exitMItem = new JMenuItem ("Salir");
		
		exitMItem.setMnemonic ('S');
		
		exitMItem.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				System.exit (0);
			}
		} );
		
		archiveMenu.add (exitMItem);
	}
	
	private void initTabs () {
		elTabPane = new JTabbedPane (JTabbedPane.BOTTOM);
		
		elTabPane.addTab ("Gráfico", null);
		elTabPane.addTab ("Sumario", null);
		
		elTabPane.setComponentAt (0, visualGraph);
	}
	
	private void initGraph () {
		visualGraph = new VisualNotDirectedGraph (elFrame.getContentPane ().getWidth () / 2 + 550,
												  elFrame.getContentPane ().getHeight () / 2 + 350);
		visualGraph.setGraph (new HydroNet ().getHydroNet () );
	}
 }
