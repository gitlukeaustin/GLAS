package Main.View;
import javax.swing.*;
import java.awt.*;


public class Sliders extends JPanel
{
    public GridBagConstraints constraints;
    
    public Sliders()
    {
        setLayout(new GridLayout(12,1));
        JLabel echolabel = new JLabel("Echo");
        JSlider echo = new JSlider();
        JLabel reverblabel = new JLabel("Réverbe");
        JSlider reverb = new JSlider();
        JLabel distortionlabel = new JLabel("Distortion");
        JSlider distortion = new JSlider();
        JLabel pitchlabel = new JLabel("Pitch");
        JSlider pitch = new JSlider();
        JLabel vitesselabel = new JLabel("Vitess");
        JSlider vitesse = new JSlider();
        JLabel compressionlabel = new JLabel("Compression");
        JSlider compression = new JSlider(8,64);
        compression.setMinorTickSpacing(8);
        compression.setPaintTicks(true);
        compression.setPaintLabels(true);

        add(echolabel);
        add(echo);
        add(reverblabel);
        add(reverb);
        add(distortionlabel);
        add(distortion);
        add(pitchlabel);
        add(pitch);
        add(vitesselabel);
        add(vitesse);
        add(compressionlabel);
        add(compression);
        
        this.constraints = new GridBagConstraints();
        this.constraints.gridy = 0;
        this.constraints.gridx = 4;
        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 5;
        this.constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        this.constraints.insets = new Insets(2,2,2,2);
    }
}