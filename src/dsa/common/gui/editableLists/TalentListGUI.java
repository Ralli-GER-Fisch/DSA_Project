package dsa.common.gui.editableLists;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Talent;
import dsa.common.gui.editableLists.tableModels.TalentTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class TalentListGUI extends JScrollPane {
	private CustomRenderedTable<Talent> talentTable;
	public TalentListGUI() {
		super();
		TalentTableModel tTM = new TalentTableModel(DbManager.getCurrentDbManager().getAllOfClass(Talent.class));
		talentTable = new CustomRenderedTable<Talent>(tTM);
		talentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		talentTable.setAutoCreateRowSorter(true);
		setViewportView(talentTable);
	}

	public String getInformation() {
		return "Displaying "+ DbManager.getCurrentDbManager().getRowCountOfClass(Talent.class) +" rows";
	}
	
	public JTable getTable(){
		return talentTable;
	}
}
