package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dsa.common.data.Eigenschaft;

@SuppressWarnings("serial")
public class AttributeTableModel extends AbstractTableModel {
	private List<Eigenschaft> data;
	private List<String> columnNames = Arrays.asList("ID","Name","K�rzel","Beschreibung");
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_KUERZEL = 2,
							COL_BESCHREIBUNG = 3;
	
	public AttributeTableModel(List<Eigenschaft> data) {
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
	
	public Eigenschaft getRowObject(int row) {
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
		case COL_KUERZEL:
			retval = data.get(row).getKuerzel();
			break;
		case COL_BESCHREIBUNG:
			retval = data.get(row).getBeschreibung();
			break;
		}
		return retval;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	public void addRow(Eigenschaft rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Eigenschaft rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
