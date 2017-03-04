package Main.View;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import Main.Controler.*;
public class Sliders extends JPanel
{
    public GridBagConstraints constraints;
    
    public Sliders()
    {
        TreeMap<String,JSlider> list = new TreeMap<String,JSlider>();
        setLayout(new GridLayout(12,1));
        
        JSlider echo = new JSlider();
        list.put("Echo",echo);
        
        JSlider reverb = new JSlider();
        list.put("Réverbe",reverb);
        
        JSlider distortion = new JSlider();
        list.put("Distortion",distortion);
        
        JSlider pitch = new JSlider();
        list.put("Pitch",pitch);
        
        JSlider vitesse = new JSlider();
        list.put("Vitesse",vitesse);
        
        JSlider compression = new JSlider(8,64);
        list.put("Compression",compression);
        compression.setMinorTickSpacing(8);
        compression.setValueIsAdjusting(true);
        compression.setPaintTicks(true);
        compression.setPaintLabels(true);

        SliderControl slidercontrol = new SliderControl();
        
        for(String label : list.keySet())
        {
            add(new JLabel(label));
            add(list.get(label));
            ((JSlider)list.get(label)).setOpaque(false);
            ((JSlider)list.get(label)).addChangeListener(slidercontrol);
        }
        
        this.constraints = new GridBagConstraints();
        this.constraints.gridy = 0;
        this.constraints.gridx = 4;
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 5;
        this.constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        this.constraints.insets = new Insets(2,2,2,2);
    }
}