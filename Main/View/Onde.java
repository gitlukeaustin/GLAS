package Main.View;
import Main.Model.*;
import java.io.File;
import javax.swing.*;
import java.awt.*;

public class Onde extends JPanel
{
    public GridBagConstraints constraints;
	
	private Son son;   
 	
    public Onde()
    {
        /*ImageIcon image = new ImageIcon("Image/GlasImage.png");
        JLabel label = new JLabel("",image,JLabel.LEFT);
        add(label,BorderLayout.WEST);*/
        setLayout(new GridLayout(2,1));
        int[] ypoints = {8,-3,5,-1,16,-3,4,6,-1,4,6,3,7,-8,3,2,-7,4,2,4,-7,5,-3,8};     
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

	public void setSon(Son s)
	{
		this.son = s;
		add(new Graph(son.createWaveForm(this.getSize())));
		this.repaint();
	} 

    public void draw()
    {
	File f = new File("C:\\Users\\Ackincolor\\Desktop\\GLAS-master\\test1.wav");	
	
	if(f.exists())
	{
        	this.son = new Son(f);
		add(new Graph(son.createWaveForm(this.getSize())));
		add(new Graph());
		this.repaint();
	}
	else
	{
		System.out.println("Ce fichier n'existe pas.");
	}
    }
}
