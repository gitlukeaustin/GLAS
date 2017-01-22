package Main.View;
import Main.Controler.*;
import javax.swing.*;
public class BotSide extends JPanel
{
	public BotSide()
	{
		this.add(new JButton("<<"));
		this.add(new JButton(">"));
		this.add(new JButton(">>"));
	}
}