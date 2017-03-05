package Main.Controler;
import Main.Model.*;
import Main.View.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JButton;

public class PlaybackControl implements ActionListener
{
	private Son son;
    
    public PlaybackControl()
    {
        
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
        if(((JButton)e.getSource()).getText().equals(Playback.PLAY))
        {
            if(son != null)
            {
                Thread t = new Thread(son);
                t.start();
            }
            System.out.println("play");

        }
        else if(((JButton)e.getSource()).getText().equals(Playback.PAUSE))
        {
            if(son != null)
            {
                son.pauseSon();
            }
            System.out.println("pause");

        }
        else if(((JButton)e.getSource()).getText().equals(Playback.STOP))
        {
            if(son != null)
            {
                son.arreterSon();
            }
            System.out.println("stop");

        }
	}

	public void setSon(File f)
	{	
		son = new Son(f);
	}
}
