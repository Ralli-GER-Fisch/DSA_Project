package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import dsa.common.data.Vorteil;

@SuppressWarnings("serial")
public class VorteilTableModel extends AbstractCustomTableModel<Vorteil> {
	private List<Vorteil> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Generierungskosten","Kostenzusatz","Beschreibung");
	private List<Class<?>> columnClasses = Arrays.asList(Long.class,String.class,Integer.class,String.class,String.class);
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_GENERIERUNGSKOSTEN = 2,
							COL_KOSTENZUSATZ = 3,
							COL_BESCHREIBUNG = 4;
	
	public VorteilTableModel(List<Vorteil> data) {
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	public Vorteil getRowObject(int row) {
		return data.get(row);
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object retval = null;
		switch(col){
		case COL_ID:
			retval = data.get(row).getId();
			break;
		case COL_NAME:
			retval = data.get(row).getName();
			break;
		case COL_GENERIERUNGSKOSTEN:
			retval = data.get(row).getGenerierungskosten();
			break;
		case COL_KOSTENZUSATZ:
			retval = data.get(row).getKostenzusatz();
			break;
		case COL_BESCHREIBUNG:
			retval = data.get(row).getBeschreibung();
			break;
		}
		return retval;
	}
	
	@Override
	public Class<?> getColumnClass(int col) {
		return columnClasses.get(col);
	}
	
	public List<Class<?>> getColumnClasses() {
		return columnClasses;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	public void addRow(Vorteil rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Vorteil rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
