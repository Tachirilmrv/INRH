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

public class MainFrame {
	private JFrame elFrame;
	private JMenuBar laMenuBar;
	private JMenu archiveMenu;

	
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
		
		elFrame.setJMenuBar (laMenuBar);
				
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
		
		laMenuBar.add (archiveMenu);
		
		initMenuItems ();
	}
	
	private void initMenuItems () {
		JMenuItem exitMItem = new JMenuItem ("Salir");
		
		exitMItem.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				elFrame.dispose ();
			}
		} );
		
		archiveMenu.add (exitMItem);
	}
 }
