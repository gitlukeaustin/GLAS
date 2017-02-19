package Main.View;
import javax.swing.*;
import java.awt.*;

public class Onde extends JPanel
{
    public GridBagConstraints constraints;
    
    public Onde()
    {
        /*ImageIcon image = new ImageIcon("Image/GlasImage.png");
        JLabel label = new JLabel("",image,JLabel.LEFT);
        add(label,BorderLayout.WEST);*/
        setLayout(new GridLayout(2,1));
        int[] ypoints = {50,40,60,30,34,13,42,42,13,32,12,34,33,42,23,12,43,12,51,62,43,14};
        add(new Graph(ypoints));
        add(new Graph());
        this.setBackground(Color.BLACK);
        this.constraints = new GridBagConstraints();
        this.constraints.fill = GridBagConstraints.BOTH;
        this.constraints.gridy = 0;
        this.constraints.gridx = 0;
        this.constraints.weightx = 5.0;
        this.constraints.weighty = 5.0;
        this.constraints.gridwidth = 4;
        this.constraints.gridheight = 4;
        this.constraints.insets = new Insets(2,2,2,2);
    }
}