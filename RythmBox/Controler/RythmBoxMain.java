package RythmBox.Controler;
import RythmBox.View.*;
public class RythmBoxMain implements Runnable
{
	public void run()
	{
		FenetreRythmBox f = new FenetreRythmBox();
		f.setVisible(true);
	}
}