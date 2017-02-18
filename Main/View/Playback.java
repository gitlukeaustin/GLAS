package Main.View;
import java.awt.*;
import javax.swing.*;
import Main.Controler.*;

public class Playback extends JPanel
{
    public GridBagConstraints constraints;
    
    public Playback()
    {
        setLayout(new GridBagLayout());
        JSlider volume = new JSlider(SwingConstants.HORIZONTAL);
        JButton stop = new JButton("\u25B4");
        JButton pause = new JButton("\u23F8");
        JButton play = new JButton("\u25B6");
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

}