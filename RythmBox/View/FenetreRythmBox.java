package RythmBox.View;
import javax.swing.*;
import java.awt.*;
public class FenetreRythmBox extends JFrame
{
	private JTable rythmTable;
	private JPanel leftPanel;
	public FenetreRythmBox()
	{
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.leftPanel = new JPanel();
		this.rythmTable = new JTable();
		this.add(this.leftPanel,BorderLayout.WEST);
		this.add(this.rythmTable,BorderLayout.CENTER);

	}
}