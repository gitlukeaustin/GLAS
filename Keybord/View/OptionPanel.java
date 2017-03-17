package Keybord.View;
import javax.swing.*;
import java.awt.*;
import Keybord.View.*;
import Keybord.Model.*;
import Keybord.Controler.*;
public class OptionPanel extends JPanel
{
	private JSlider velocite;
	private SynthModel synthModel;
	private JCheckBox mouseOverPiano;
	private JButton record,save,play,export;
	private JLabel time;
	public OptionPanel(SynthModel synthModel)
	{
		this.synthModel = synthModel;
		//slider 1
		this.velocite = createSlider("Velocité",this);
		this.velocite.addChangeListener(new SliderControler(this.synthModel));
		//checkbox over
		this.mouseOverPiano = new JCheckBox("mouseOver", false);
		//enregistrement
		
		this.record = new JButton("Record");
		this.save = new JButton("Save");
		this.play = new JButton("Play");
		this.export = new JButton("Export");
		RecordButton listener = new RecordButton(this.synthModel,this);
		this.record.addActionListener(listener);
		this.save.addActionListener(listener);
		this.play.addActionListener(listener);
		this.export.addActionListener(listener);
		this.add(this.mouseOverPiano);
		this.add(this.velocite);
		this.add(this.record);
		this.add(this.play);
		this.add(this.save);
		this.add(this.export);
		this.time = new JLabel();
		this.add(this.time);
		JScrollPane scroll = new JScrollPane(new ListeInstru(this.synthModel),JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Dimension tableSize = new Dimension(42*22, 160);
		scroll.setPreferredSize(tableSize);
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
    public JButton[] getAllButton()
    {
    	JButton[] tab = new JButton[4];
    	tab[0]=this.record;
    	tab[1]=this.save;
    	tab[2]=this.play;
    	tab[3]=this.export;
    	return tab;
    }
    public JLabel getLabel()
    {
    	return this.time;
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