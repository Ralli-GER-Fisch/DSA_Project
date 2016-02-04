package dsa.common.gui.editableLists;




import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Nachteil;
import dsa.common.gui.editableLists.tableModels.NachteilTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class NachteilListGUI extends JScrollPane {
	private CustomRenderedTable<Nachteil> nachteilTable;
	public NachteilListGUI() {
		super();
		NachteilTableModel aTM = new NachteilTableModel(DbManager.getCurrentDbManager().getAllOfClass(Nachteil.class));
		nachteilTable = new CustomRenderedTable<Nachteil>(aTM);
		nachteilTable.setFillsViewportHeight(true);
		nachteilTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//nachteilTable.setRowHeight(50);
		nachteilTable.setAutoCreateRowSorter(true);
		setViewportView(nachteilTable);
	}

	public String getInformation() {
		return "Zeige "+ DbManager.getCurrentDbManager().getRowCountOfClass(Nachteil.class) +" Einträge der Tabelle Nachteil";
	}
	
	public JTable getTable(){
		return nachteilTable;
	}
}
