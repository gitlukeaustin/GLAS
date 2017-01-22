package Main.Controler;
import java.awt.event.*;
import Keybord.Controler.*;
import RythmBox.Controler.*;
import javax.swing.JMenuItem;
public class MenuControl implements ActionListener
{
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
    	else
    		System.out.println("rien a faire");
	}
}