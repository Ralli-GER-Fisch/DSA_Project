package dsa.common.gui.editableLists;




import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dsa.common.data.Eigenschaft;
import dsa.common.gui.editableLists.tableModels.AttributeTableModel;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AttributeListGUI extends JScrollPane {
	private CustomRenderedTable<Eigenschaft> attributeTable;
	public AttributeListGUI() {
		super();
		AttributeTableModel aTM = new AttributeTableModel(DbManager.getCurrentDbManager().getAllOfClass(Eigenschaft.class));
		attributeTable = new CustomRenderedTable<Eigenschaft>(aTM);
		attributeTable.setFillsViewportHeight(true);
		attributeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//attributeTable.setRowHeight(50);
		attributeTable.setAutoCreateRowSorter(true);
		setViewportView(attributeTable);
	}

	public String getInformation() {
		return "Displaying "+ DbManager.getCurrentDbManager().getRowCountOfClass(Eigenschaft.class) +" rows";
	}
	
	public JTable getTable(){
		return attributeTable;
	}
}
