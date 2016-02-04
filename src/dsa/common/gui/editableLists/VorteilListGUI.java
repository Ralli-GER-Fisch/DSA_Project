package dsa.common.gui.editableLists;




import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Vorteil;
import dsa.common.gui.editableLists.tableModels.VorteilTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class VorteilListGUI extends JScrollPane {
	private CustomRenderedTable<Vorteil> vorteilTable;
	public VorteilListGUI() {
		super();
		VorteilTableModel aTM = new VorteilTableModel(DbManager.getCurrentDbManager().getAllOfClass(Vorteil.class));
		vorteilTable = new CustomRenderedTable<Vorteil>(aTM);
		vorteilTable.setFillsViewportHeight(true);
		vorteilTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//vorteilTable.setRowHeight(50);
		vorteilTable.setAutoCreateRowSorter(true);
		setViewportView(vorteilTable);
	}

	public String getInformation() {
		return "Zeige "+ DbManager.getCurrentDbManager().getRowCountOfClass(Vorteil.class) +" Einträge der Tabelle Vorteil";
	}
	
	public JTable getTable(){
		return vorteilTable;
	}
}
