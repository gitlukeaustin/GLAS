package View;
import javax.swing.*;
import View.*;
import Model.*;
import Controler.*;
public class OptionPanel extends JPanel
{
	private JSlider velocite;
	private SynthModel synthModel;
	private JCheckBox mouseOverPiano;
	private JButton record;
	public OptionPanel(SynthModel synthModel)
	{
		this.synthModel = synthModel;
		//slider 1
		this.velocite = createSlider("Velocité",this);
		this.velocite.addChangeListener(new SliderControler(this.synthModel));
		//checkbox over
		this.mouseOverPiano = new JCheckBox("mouseOver", false);
		//enregistrement
		this.record = new JButton("°");
		this.record.addActionListener(new RecordButton(this.synthModel));
		this.add(this.mouseOverPiano);
		this.add(this.velocite);
		this.add(this.record);
		JScrollPane scroll = new JScrollPane(new ListeInstru(this.synthModel));
		//this.add(new ListeInstru(this.synthModel.getAllInstru()));
		this.add(scroll);
	}
	private JSlider createSlider(String name, JPanel p) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 127, 64);
        //slider.addChangeListener(this);
        p.add(slider);
        p.add(Box.createHorizontalStrut(5));
        return slider;
    }
    public JSlider getSliderVelocite()
    {
    	return this.velocite;
    }
    public JCheckBox getCheckMouseOver()
    {
    	return this.mouseOverPiano;
    }
}