import Main.Model.*;
import java.awt.event.*;

public class PlayController implements ActionListener
{
	private Son son;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(son != null)
		{
			son.jouerSon();
		}
		System.out.println("play");
	}

	public void setSon(Ficher f)
	{	
		son = new Son(f);
	}
}
