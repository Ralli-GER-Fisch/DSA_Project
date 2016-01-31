package dsa.common.gui.editableLists.tableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class AbstractCustomTableModel<T> extends AbstractTableModel {
	@SuppressWarnings("unused")
	private List<T> data;
	@SuppressWarnings("unused")
	private List<String> columnNames;
	@SuppressWarnings("unused")
	private List<Class<?>> columnClasses;
	
	abstract public int getColumnCount();

	abstract public int getRowCount();
	
	abstract public T getRowObject(int row);

	abstract public Object getValueAt(int row, int col);
		
	abstract public Class<?> getColumnClass(int col);
	
	abstract public List<Class<?>> getColumnClasses();
	
	abstract public String getColumnName(int col);
	
	abstract public void addRow(T rowData);
	
	abstract public void insertRow(int row, T rowData);
	
	abstract public void removeRow(int row);

}
