package Main.View;
import Main.Controler.*;
import java.awt.*;
import javax.swing.*;

public class Graph extends JComponent
{
    private int[] x, y;
    private int moyenne;
    
    public Graph(int[] ypoints)
    {
        this.y = ypoints;
        this.x = new int[ypoints.length];
        int somme = 0;
        for(int n : ypoints)
        {
            somme += n;
        }
        this.moyenne = somme/ypoints.length;
    }
    
    public Graph()
    {
        this.y = new int[2];
        this.x = new int[2];
        this.y[0] = 1;
        this.y[1] = 1;
        this.moyenne = 1;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics clone = g.create();
        clone.setColor(Color.RED);
       
        int ytranslate[] = new int[y.length];
        
        int i = 0;
        int plot = 0;
        int increment = this.getParent().getWidth()/(this.y.length-1);
        for(i=0;i<this.x.length;i++)
        {
            this.x[i] = plot;
            plot += increment;
            
            ytranslate[i] = this.y[i] + (this.getHeight()/2 - this.moyenne);
        }
        
        clone.drawPolyline(this.x,ytranslate,this.y.length);
    }


}