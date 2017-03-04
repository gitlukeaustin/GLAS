package Main.Controler;
import javax.swing.event.*;
import Main.View.*;

public class SliderControl implements ChangeListener
{
    public SliderControl()
    {
        
    }
    
    public void stateChanged(ChangeEvent e)
    {
        System.out.println(e.getSource().toString()+" changé");
    }
}