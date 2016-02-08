package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import dsa.common.data.Kultur;
import dsa.common.data.mappings.Kultur_Eigenschaft_Mod;
import dsa.common.data.mappings.Kultur_Nachteil;
import dsa.common.data.mappings.Kultur_Profession;
import dsa.common.data.mappings.Kultur_Sonderfertigkeit;
import dsa.common.data.mappings.Kultur_TalentGruppe_Mod;
import dsa.common.data.mappings.Kultur_Vorteil;
import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class KulturTableModel extends AbstractCustomTableModel<Kultur> {
	private List<Kultur> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Generierungskosten",
			"Maximaler Sozialstatus","LE",
			"AU","MR","Beschreibung",
			"Eigenschaftsmodifikatore","Vorteile","Nachteile",
			"Talente","Professionen","Sonderfertigkeiten",
			"Variante von");
	private List<Class<?>> columnClasses = Arrays.asList(Long.class,String.class,Integer.class,
			Integer.class,Integer.class,
			Integer.class,Integer.class,String.class,
			CollectionGenericWrapper.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class,
			CollectionGenericWrapper.class,CollectionGenericWrapper.class,CollectionGenericWrapper.class,
			Kultur.class);
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_GENERIERUNG = 2,
							COL_MAXSO = 3,
							COL_LE = 4,
							COL_AU = 5,
							COL_MR = 6,
							COL_BESCHREIBUNG = 7,
							COL_EIGENSCHAFT = 8,
							COL_VORTEIL = 9,
							COL_NACHTEIL = 10,
							COL_TALENT = 11,
							COL_PROFESSION = 12,
							COL_SONDERFERTIGKEIT = 13,
							COL_VARIANTEVON = 14;
							
	
	public KulturTableModel(List<Kultur> data) {
		DbManager.getCurrentDbManager().unlazyKultur(data);
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
	
	public Kultur getRowObject(int row) {
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
		case COL_MAXSO:
			retval = data.get(row).getSozialstatus_maximum();
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
		case COL_BESCHREIBUNG:
			retval = data.get(row).getBeschreibung();
			break;
		case COL_EIGENSCHAFT:
			retval = new <Kultur_Eigenschaft_Mod>CollectionGenericWrapper(data.get(row).getEigenschafts_modifikatoren(),Kultur_Eigenschaft_Mod.class);
			break;
		case COL_VORTEIL:
			retval = new <Kultur_Vorteil>CollectionGenericWrapper(data.get(row).getKultur_vorteile(),Kultur_Vorteil.class);
			break;
		case COL_NACHTEIL:
			retval = new <Kultur_Nachteil>CollectionGenericWrapper(data.get(row).getKultur_nachteile(),Kultur_Nachteil.class);
			break;
		case COL_TALENT:
			retval = new <Kultur_TalentGruppe_Mod>CollectionGenericWrapper(data.get(row).getKultur_talente(),Kultur_TalentGruppe_Mod.class);
			break;
		case COL_PROFESSION:
			retval = new <Kultur_Profession>CollectionGenericWrapper(data.get(row).getKultur_professionen(), Kultur_Profession.class);
			break;
		case COL_SONDERFERTIGKEIT:
			retval = new <Kultur_Sonderfertigkeit>CollectionGenericWrapper(data.get(row).getKultur_sonderfertigkeiten(),Kultur_Sonderfertigkeit.class);
			break;
		case COL_VARIANTEVON:
			retval = data.get(row).getVarianteVon();
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
	
	public void addRow(Kultur rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Kultur rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
