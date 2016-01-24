package dsa.common.gui.editableLists;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Talent;
import dsa.common.gui.editableLists.tableModels.TalentTableModel;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class TalentListGUI extends JScrollPane {
	private JTable talentTable;
	public TalentListGUI() {
		super();
		TalentTableModel tTM = new TalentTableModel(DbManager.getCurrentDbManager().getAllOfClass(Talent.class));
		talentTable = new JTable(tTM);
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
