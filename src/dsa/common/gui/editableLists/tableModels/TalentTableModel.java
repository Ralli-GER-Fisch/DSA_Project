package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dsa.common.data.Talent;

@SuppressWarnings("serial")
public class TalentTableModel extends AbstractTableModel {
	private List<Talent> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Typ","Gruppe","Spalte","Effektive Behinderung","Beschreibung");
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_TYP = 2,
							COL_GRUPPE = 3,
							COL_SPALTE = 4,
							COL_eBE = 5,
							COL_BESCHREIBUNG = 6;
	
	public TalentTableModel(List<Talent> data) {
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
	
	public Talent getRowObject(int row) {
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
		case COL_TYP:
			retval = Talent.getTypStringById(data.get(row).getTyp());
			break;
		case COL_GRUPPE:
			retval = Talent.getGruppeStringById(data.get(row).getGruppe());
			break;
		case COL_SPALTE:
			retval = data.get(row).getSpalte();
			break;
		case COL_eBE:
			retval = data.get(row).geteBe();
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

	public void addRow(Talent rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Talent rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
