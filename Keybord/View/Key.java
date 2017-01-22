package Keybord.View;

import javax.swing.*;
import java.awt.Rectangle;
import javax.sound.midi.*;
public class Key extends Rectangle
{
	private int num;
	private int longueur = 400;
	private boolean on = false;
	public Key(int posX,int posY,int largeur,int hauteur,int num)
	{
		super(posX,posY,largeur,hauteur);
		this.num = num;
	}
	public boolean isNoteOn()
	{
		//test si touche cliquée 
		return this.on;
	}
	public int getNum()
	{
		return this.num;
	}
	public void setOn()
	{
		this.on = true;
		//this.mc[channel].noteOn(this.num,this.longueur);
	}
	public void setOff()
	{
		this.on=false;
		//this.mc[channel].noteOff(this.num,this.longueur);
	}
	
}