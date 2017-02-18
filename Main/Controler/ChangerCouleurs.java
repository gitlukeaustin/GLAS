package Main.Controler;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ChangerCouleurs implements ActionListener
{
    private ArrayList<JPanel> panels;
    private ArrayList<Color> theme_a;
    private ArrayList<Color> theme_b;
    private ArrayList<Color> theme_c;
    private ArrayList<Color> theme_d;
    
    public ChangerCouleurs(ArrayList<JPanel> panels)
    {
        this.panels = panels;
        theme_a = new ArrayList<Color>();
        theme_a.add(new Color(0x878787));
        theme_a.add(new Color(0xBB7E8C));
        theme_a.add(new Color(0xD1BECF));

        theme_b = new ArrayList<Color>();
        theme_b.add(new Color(0xFFFFFF));
        theme_b.add(new Color(0x2D3142));
        theme_b.add(new Color(0xBFC0C0));
        
        theme_c = new ArrayList<Color>();
        theme_c.add(new Color(0x5E503F));
        theme_c.add(new Color(0xF2F4F3));
        theme_c.add(new Color(0x49111C));
        
        theme_d = new ArrayList<Color>();
        theme_d.add(new Color(0xAAD2BA));
        theme_d.add(new Color(0xD9FF5));
        theme_d.add(new Color(0xB9F5D8));

    }
    public void actionPerformed(ActionEvent e)
    {
        String nom = ((JRadioButtonMenuItem)e.getSource()).getText();
        ArrayList<Color> choix = theme_a;

        if(nom.equals("B"))
        {
            choix = theme_b;
        }
        else if(nom.equals("C"))
        {
            choix = theme_c;
        }
        else if(nom.equals("D"))
        {
            choix = theme_d;
        }
        int i = 0;
        for(Color c : choix)
        {
            this.panels.get(i).setBackground(c);
            i++;
        }
    }
}