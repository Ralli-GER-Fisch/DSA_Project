package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import dsa.common.data.Rasse;
import dsa.common.data.mappings.Rasse_Eigenschaft_Mod;
import dsa.common.data.mappings.Rasse_Kultur;
import dsa.common.data.mappings.Rasse_Nachteil;
import dsa.common.data.mappings.Rasse_Talent_Mod;
import dsa.common.data.mappings.Rasse_Vorteil;
import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class RasseTableModel extends AbstractCustomTableModel<Rasse> {
	private List<Rasse> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Generierungskosten","Körpergröße","Gewicht","LE","AU","MR","Herkunft und Verbreitung","Körperbau und Aussehen","Beschreibung","Eigenschaftsmodifikatore","Vorteile","Nachteile","Talente","Kulturen");
	private List<Class<?>> columnClasses = Arrays.asList(Long.class,String.class,Integer.class,String.class,String.class,Integer.class,Integer.class,Integer.class,String.class,String.class,String.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class);
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_GENERIERUNG = 2,
							COL_GROESSE = 3,
							COL_GEWICHT = 4,
							COL_LE = 5,
							COL_AU = 6,
							COL_MR = 7,
							COL_HERKUNFT = 8,
							COL_AUSSEHEN = 9,
							COL_BESCHREIBUNG = 10,
							COL_EIGENSCHAFT = 11,
							COL_VORTEIL = 12,
							COL_NACHTEIL = 13,
							COL_KULTUR = 14,
							COL_TALENT = 15;//,COL_SONDERFERTIGKEIT = 16;
							
	
	public RasseTableModel(List<Rasse> data) {
		DbManager.getCurrentDbManager().unlazyRasse(data);
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
	
	public Rasse getRowObject(int row) {
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
		case COL_GENERIERUNG:
			retval = data.get(row).getGenerierungskosten();
			break;
		case COL_GROESSE:
			retval = data.get(row).getKoerpergroesse_regel();
			break;
		case COL_GEWICHT:
			retval = data.get(row).getGewicht_regel();
			break;
		case COL_LE:
			retval = data.get(row).getLebenspunkte_modifikator();
			break;
		case COL_AU:
			retval = data.get(row).getAusdauer_modifikator();
			break;
		case COL_MR:
			retval = data.get(row).getMagieresistenz_modifikator();
			break;
		case COL_HERKUNFT:
			retval = data.get(row).getHerkunft_verbreitung();
			break;
		case COL_AUSSEHEN:
			retval = data.get(row).getKoerperbau_aussehen();
			break;
		case COL_BESCHREIBUNG:
			retval = data.get(row).getBeschreibung();
			break;
		case COL_EIGENSCHAFT:
			retval = new <Rasse_Eigenschaft_Mod>CollectionGenericWrapper(data.get(row).getEigenschafts_modifikatoren(),Rasse_Eigenschaft_Mod.class);
			break;
		case COL_VORTEIL:
			retval = new <Rasse_Vorteil>CollectionGenericWrapper(data.get(row).getRasse_vorteile(),Rasse_Vorteil.class);
			break;
		case COL_NACHTEIL:
			retval = new <Rasse_Nachteil>CollectionGenericWrapper(data.get(row).getRasse_nachteile(),Rasse_Nachteil.class);
			break;
		case COL_KULTUR:
			retval = new <Rasse_Kultur>CollectionGenericWrapper(data.get(row).getRasse_kulturen(),Rasse_Kultur.class);
			break;
		case COL_TALENT:
			retval = new <Rasse_Talent_Mod>CollectionGenericWrapper(data.get(row).getRasse_talente(),Rasse_Talent_Mod.class);
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
	
	public void addRow(Rasse rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Rasse rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
