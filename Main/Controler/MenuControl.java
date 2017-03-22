package Main.Controler;
import Main.Model.*;
import Main.View.*;
import java.awt.event.*;
import Keybord.Controler.*;
import RythmBox.Controler.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class MenuControl implements ActionListener
{
    	private Playback playback;
	private Son son;
	private TreeMap<String, JPanel> panels;    

	public MenuControl(TreeMap<String,JPanel> panels, Playback p)
	{
        	this.playback = p;
		this.panels = panels;
	}
    
	public MenuControl()
	{
		
	}
    
	public void actionPerformed(ActionEvent e) 
	{ 
		//afficher la fenetre du piano
		if(((JMenuItem)e.getSource()).getText().startsWith("Piano"))
			javax.swing.SwingUtilities.invokeLater(new KeybordMain());
		else if(((JMenuItem)e.getSource()).getText().startsWith("RythmBox"))
		    javax.swing.SwingUtilities.invokeLater(new RythmBoxMain());
		else if(((JMenuItem)e.getSource()).getText().startsWith("Ouvrir"))
		{
		    JFileChooser choixwindow = new JFileChooser();
		    choixwindow.setCurrentDirectory(new File("."));
		    int retour = choixwindow.showOpenDialog((JMenuItem)e.getSource());
		    if(retour == JFileChooser.APPROVE_OPTION)
		    {
			File file = choixwindow.getSelectedFile();
			System.out.println(file.getName()+"opened");
			this.son = new Son(file);
			((Playback)this.panels.get("Playback")).getPlayController().setSon(son);
			((Onde)this.panels.get("Onde")).setSon(son);
		    }
		}
		else if(((JMenuItem)e.getSource()).getText().startsWith("Sauvegarder"))
		{
		    JFileChooser choixwindow = new JFileChooser();
		    choixwindow.setCurrentDirectory(new File("."));
		    int retour = choixwindow.showSaveDialog((JMenuItem)e.getSource());
		    if(retour == JFileChooser.APPROVE_OPTION)
		    {
			File file = choixwindow.getSelectedFile();
			System.out.println(file.getName()+"opened");
		    }
		}
		else
			System.out.println("rien a faire");
		}
}
