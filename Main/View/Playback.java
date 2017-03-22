package Main.View;
import java.awt.*;
import javax.swing.*;
import Main.Controler.*;

public class Playback extends JPanel
{
    public GridBagConstraints constraints;
	private PlaybackControl playcontroler;  
	public static int STOP = 0x25B4;
	public static int PAUSE = 0x23F8;
	public static int PLAY = 0x25B6;
 
    public Playback()
    {
        setLayout(new GridBagLayout());
        JSlider volume = new JSlider(SwingConstants.HORIZONTAL);
        JButton stop = new JButton(""+Playback.STOP);
        JButton pause = new JButton(""+Playback.PAUSE);
        JButton play = new JButton(""+Playback.PLAY);
	this.playcontroler = new PlaybackControl();
	play.addActionListener(playcontroler);
        JButton sauvegarde = new JButton("Sauvegarder");
        JButton ouvrir = new JButton("Ouvrir");
        JButton piano = new JButton("Piano");
        piano.addActionListener(new AfficherPianoControler());
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridx = 0;
        add(stop,c);
        c.gridx = 1;
        add(pause,c);
        c.gridx = 2;
        add(play,c);
        c.gridwidth = 6;
        c.gridheight = 1;
        c.gridx=3;
        add(volume,c);
        c.gridwidth = 2;
        c.gridy = 2;
        add(sauvegarde,c);
        c.gridx = 5;
        add(ouvrir,c);
        c.gridx = 7;
        add(piano,c);
        
        this.constraints = new GridBagConstraints();
        this.constraints.gridy = 4;
        this.constraints.gridx = 0;
        this.constraints.gridwidth = 4;
        this.constraints.gridheight = 1;
        this.constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.constraints.insets = new Insets(2,2,2,2);

    }

	public PlaybackControl getPlayController()
	{
		return this.playcontroler;
	}

}
