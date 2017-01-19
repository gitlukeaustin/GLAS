package Controler;
import Model.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
public class ControleurTableSelection implements ListSelectionListener{
    private SynthModel synthModel;
    private JTable table;
    public ControleurTableSelection(SynthModel synthModel,JTable table)
    {
        this.synthModel = synthModel;
        this.table = table;
    }
    public void valueChanged(ListSelectionEvent listSelectionEvent){
        int ligne=0;
        int colone=0;
        ListSelectionModel sm = (ListSelectionModel) listSelectionEvent.getSource();
        if (!sm.isSelectionEmpty()) {
            ligne = this.table.getSelectedRow();
            colone = this.table.getSelectedColumn();
        }
        System.out.println("instru selectionné ="+(colone*8+ligne));
        this.synthModel.setInstrument(colone*8+ligne);
    }
}