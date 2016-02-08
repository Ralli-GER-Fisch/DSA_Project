package dsa.common.gui.editableLists;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Kultur;
import dsa.common.gui.editableLists.tableModels.KulturTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class KulturListGUI extends JScrollPane {
	private CustomRenderedTable<Kultur> kulturTable;
	public KulturListGUI() {
		super();
		KulturTableModel tTM = new KulturTableModel(DbManager.getCurrentDbManager().getAllOfClass(Kultur.class));
		kulturTable = new CustomRenderedTable<Kultur>(tTM);
		kulturTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		kulturTable.setAutoCreateRowSorter(true);
		setViewportView(kulturTable);
	}

	public String getInformation() {
		return "Zeige "+ DbManager.getCurrentDbManager().getRowCountOfClass(Kultur.class) +" Einträge der Tabelle Kultur";
	}
	
	public JTable getTable(){
		return kulturTable;
	}
}
