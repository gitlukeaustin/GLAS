package Main.View;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import Main.Controler.*;
import Main.Model.*;

public class Sliders extends JPanel
{
    public GridBagConstraints constraints;
	private Son son;   
	TreeMap<String,JSlider> list;
 
    public Sliders()
    {
        list = new TreeMap<String,JSlider>();
        setLayout(new GridLayout(12,1));
        
        JSlider echo = new JSlider();
        this.list.put("Echo",echo);
        
        JSlider reverb = new JSlider();
        this.list.put("Réverbe",reverb);
        
        JSlider distortion = new JSlider();
        this.list.put("Distortion",distortion);
        
        JSlider pitch = new JSlider();
        this.list.put("Pitch",pitch);
        
        JSlider vitesse = new JSlider();
        this.list.put("Vitesse",vitesse);
        
        JSlider compression = new JSlider(8,64);
        compression.setMinorTickSpacing(8);
	compression.setSnapToTicks(true);
	this.list.put("Compression",compression);
        
	SliderControl slidercontrol = new SliderControl(this);
        
        for(String label : list.keySet())
        {
		this.list.get(label).setName(label);
		this.list.get(label).setPaintTicks(true);
		
		this.list.get(label).setPaintTrack(true);
		
		this.list.get(label).setPaintLabels(true);
        	((JSlider)this.list.get(label)).setOpaque(false);
            ((JSlider)this.list.get(label)).addChangeListener(slidercontrol);

	    add(new JLabel(label));
            add(list.get(label));
        }
        
        this.constraints = new GridBagConstraints();
        this.constraints.gridy = 0;
        this.constraints.gridx = 4;
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 5;
        this.constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        this.constraints.insets = new Insets(2,2,2,2);
    }

	
	public void setSon(Son s)
	{
		this.son = s;
	}

	public void changerEffet(String nom, int val)
	{	
		if(son != null)
		{
			son.changerEffet(nom, val);
		}	
		else
		{
			System.out.println("Son non défini ");
		}
	}
}
