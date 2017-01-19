package Controler;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import View.*;

public class RecordButton implements ActionListener
{
	private SynthModel synthModel;
	public RecordButton(SynthModel model)
	{
		this.synthModel = model;
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton bouton;
		if(this.synthModel.isRecording())
		{
			//stoper enregistrement
			this.synthModel.stopRecord();
			bouton = (JButton)e.getSource();
			bouton.setText("°");
		}
		else
		{
			//commencer enregistrement
			this.synthModel.startRecord();
			bouton = (JButton)e.getSource();
			bouton.setText("||");
		}
	}
}