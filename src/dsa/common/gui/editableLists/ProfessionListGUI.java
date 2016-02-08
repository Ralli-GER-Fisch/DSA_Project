package dsa.common.gui.editableLists;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Profession;
import dsa.common.gui.editableLists.tableModels.ProfessionTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class ProfessionListGUI extends JScrollPane {
	private CustomRenderedTable<Profession> professionTable;
	public ProfessionListGUI() {
		super();
		ProfessionTableModel tTM = new ProfessionTableModel(DbManager.getCurrentDbManager().getAllOfClass(Profession.class));
		professionTable = new CustomRenderedTable<Profession>(tTM);
		professionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		professionTable.setAutoCreateRowSorter(true);
		setViewportView(professionTable);
	}

	public String getInformation() {
		return "Zeige "+ DbManager.getCurrentDbManager().getRowCountOfClass(Profession.class) +" Einträge der Tabelle Profession";
	}
	
	public JTable getTable(){
		return professionTable;
	}
}
