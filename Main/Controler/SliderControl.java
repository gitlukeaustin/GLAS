package Main.Controler;
import javax.swing.event.*;
import javax.swing.*;
import Main.View.*;

public class SliderControl implements ChangeListener
{
	private Sliders sliders;

	public SliderControl(Sliders sl)
	{
		this.sliders = sl;
	}

    public void stateChanged(ChangeEvent e)
    {
	this.sliders.changerEffet(((JSlider)e.getSource()).getName(),((JSlider)e.getSource()).getValue());
    }
}
