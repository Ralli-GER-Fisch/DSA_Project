package dsa.common.gui.editableLists;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Rasse;
import dsa.common.gui.editableLists.tableModels.RasseTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class RasseListGUI extends JScrollPane {
	private CustomRenderedTable<Rasse> rasseTable;
	public RasseListGUI() {
		super();
		RasseTableModel tTM = new RasseTableModel(DbManager.getCurrentDbManager().getAllOfClass(Rasse.class));
		rasseTable = new CustomRenderedTable<Rasse>(tTM);
		rasseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rasseTable.setAutoCreateRowSorter(true);
		setViewportView(rasseTable);
	}

	public String getInformation() {
		return "Displaying "+ DbManager.getCurrentDbManager().getRowCountOfClass(Rasse.class) +" rows";
	}
	
	public JTable getTable(){
		return rasseTable;
	}
}
