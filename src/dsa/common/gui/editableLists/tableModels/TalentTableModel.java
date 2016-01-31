package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import dsa.common.data.Talent;
import dsa.common.data.mappings.Probe;
import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class TalentTableModel extends AbstractCustomTableModel<Talent> {
	private List<Talent> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Typ","Gruppe","Spalte","Effektive Behinderung","Kurzinfo","Beschreibung","Proben");
	private List<Class<?>> columnClasses = Arrays.asList(Long.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,CollectionGenericWrapper.class);
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_TYP = 2,
							COL_GRUPPE = 3,
							COL_SPALTE = 4,
							COL_eBE = 5,
							COL_KURZINFO = 6,
							COL_BESCHREIBUNG = 7,
							COL_PROBEN = 8;
	
	public TalentTableModel(List<Talent> data) {
		DbManager.getCurrentDbManager().unlazyTalente(data);
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
		case COL_KURZINFO:
			retval = data.get(row).getKurzinfo();
			break;
		case COL_BESCHREIBUNG:
			retval = data.get(row).getBeschreibung();
			break;
		case COL_PROBEN:
			retval = new <Probe>CollectionGenericWrapper(data.get(row).getProben(),Probe.class);
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
