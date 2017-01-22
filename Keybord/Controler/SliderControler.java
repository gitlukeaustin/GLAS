package Keybord.Controler;
import Keybord.Model.*;
import javax.swing.event.*;
import javax.swing.*;

public class SliderControler implements ChangeListener
{
	private SynthModel synthModel;
	public SliderControler(SynthModel synthModel)
	{
		this.synthModel = synthModel;
	}
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = (JSlider)e.getSource();
		this.synthModel.setVelocity(source.getValue());
	}
}