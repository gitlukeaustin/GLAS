package Keybord.View;
import Keybord.Model.*;
import Keybord.Controler.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class PianoView extends JPanel
{
	final int hauteur = 100;
	final int largeur = 22;
	private ArrayList<Key> notesBlanche = new ArrayList<Key>();
	private ArrayList<Key> notesNoire = new ArrayList<Key>();
    private SynthModel synthModel;
    private OptionPanel optnPanel;
	public PianoView(SynthModel synthModel,OptionPanel optnPanel)
	{
        this.synthModel = synthModel;
        this.optnPanel = optnPanel;
		this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(42*largeur, hauteur+1));
        int noteDepart = 24;
        KeyControler keyControler = new KeyControler(this,this.notesBlanche,this.notesNoire,this.synthModel,this.optnPanel.getCheckMouseOver());
        this.addKeyListener(new KeyControlerClavier(this,this.synthModel,this.notesBlanche,this.notesNoire));
        this.setFocusable(true);
        int blancheOctave[] = { 0, 2, 4, 5, 7, 9, 11 };
        for (int i = 0, x = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++, x += largeur) {
                int numeroTouche = i * 12 + blancheOctave[j] + noteDepart;
                notesBlanche.add(new Key(x, 0, largeur, hauteur, numeroTouche));
            }
        }
        for (int i = 0, x = 0; i < 6; i++, x += largeur) {
            int numeroTouche = i * 12 + noteDepart;
            notesNoire.add(new Key((x += largeur)-5, 0, largeur/2, hauteur/2, numeroTouche+1));
            notesNoire.add(new Key((x += largeur)-5, 0, largeur/2, hauteur/2, numeroTouche+3));
            x += largeur;
            notesNoire.add(new Key((x += largeur)-5, 0, largeur/2, hauteur/2, numeroTouche+6));
            notesNoire.add(new Key((x += largeur)-5, 0, largeur/2, hauteur/2, numeroTouche+8));
            notesNoire.add(new Key((x += largeur)-5, 0, largeur/2, hauteur/2, numeroTouche+10));
        }
        this.addMouseListener(keyControler);
        this.addMouseMotionListener(keyControler);
        FocusPiano focusPiano = new FocusPiano(this);  
        this.optnPanel.addMouseListener(focusPiano);
        this.optnPanel.getAllButton()[0].addMouseListener(focusPiano);
        this.optnPanel.getAllButton()[1].addMouseListener(focusPiano); 
        this.optnPanel.getAllButton()[2].addMouseListener(focusPiano);            
	}
	public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Dimension d = this.getSize();

            g2.setBackground(this.getBackground());
            g2.clearRect(0, 0, d.width, d.height);

            g2.setColor(Color.white);
            g2.fillRect(0, 0, 42*largeur, hauteur);

            for (int i = 0; i < notesBlanche.size(); i++) {
                Key key = (Key) notesBlanche.get(i);
                if (key.isNoteOn()) {
                    g2.setColor(Color.PINK);
                    g2.fill(key);
                }
                g2.setColor(Color.black);
                g2.draw(key);
            }
            for (int i = 0; i < notesNoire.size(); i++) {
                Key key = (Key) notesNoire.get(i);
                if (key.isNoteOn()) {
                    g2.setColor(Color.PINK);
                    g2.fill(key);
                    g2.setColor(Color.black);
                    g2.draw(key);
                } else {
                    g2.setColor(Color.black);
                    g2.fill(key);
                }
            }
        }
}