package Keybord.View;

import javax.swing.*;
import java.awt.*;
import Keybord.Model.*;
import Keybord.Controler.*;
public class FenetreKeybord extends JFrame
{
	private PianoView piano;
	private OptionPanel optionPanel;
	private SynthModel synthModel;
	final int hauteur = 100;
	final int largeur = 22;
	public FenetreKeybord()
	{
		this.synthModel = new SynthModel();
		this.setLayout(new GridLayout(2,0));
		this.setSize(42*largeur+18,450);
		this.optionPanel = new OptionPanel(this.synthModel);
		this.piano = new PianoView(this.synthModel,this.optionPanel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(this.piano);
		this.add(this.optionPanel);
	}
	public PianoView getPianoView()
	{
		return this.piano;
	}
}