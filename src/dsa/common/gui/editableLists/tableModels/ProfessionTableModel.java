package dsa.common.gui.editableLists.tableModels;

import java.util.Arrays;
import java.util.List;

import dsa.common.data.Profession;
import dsa.common.data.Sonderfertigkeit;
import dsa.common.data.mappings.Profession_Eigenschaft_Voraussetzung;
import dsa.common.data.mappings.Profession_TalentGruppe_Mod;
import dsa.common.data.mappings.Rasse_Kultur;
import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class ProfessionTableModel extends AbstractCustomTableModel<Profession> {
	private List<Profession> data;
	private List<String> columnNames = Arrays.asList("ID","Name","Generierungskosten",
			"Zeitaufwendig","Erstprofession",
			"Voraussetzungen","Modifikatoren",
			"Talente","Verbilligte Sonderfertigkeiten",
			"Nachteile","Vorteile",
			"Varianten","Beschreibung");
	private List<Class<?>> columnClasses = Arrays.asList(Long.class,String.class,Integer.class,
			Boolean.class,Boolean.class,
			String.class,String.class,
			CollectionGenericWrapper.class,CollectionGenericWrapper.class,
			CollectionGenericWrapper.class,CollectionGenericWrapper.class,
			CollectionGenericWrapper.class,String.class);
	
	public static final int COL_ID = 0,
							COL_NAME = 1,
							COL_GENERIERUNG = 2,
							COL_ZEITAUFWENDIG = 3,
							COL_ERSTPROFESSION = 4,
							COL_VORAUSSETZUNG = 5,
							COL_MODIFIKATOREN = 6,
							COL_TALENTE = 7,
							COL_SONDERFERTIGKEITEN = 8,
							COL_NACHTEILE = 9,
							COL_VORTEILE = 10,
							COL_VARIANTEN = 11,
							COL_BESCHREIBUNG = 12;							
	
	public ProfessionTableModel(List<Profession> data) {
		DbManager.getCurrentDbManager().unlazyProfession(data);
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
	
	public Profession getRowObject(int row) {
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
		case COL_ZEITAUFWENDIG:
			retval = data.get(row).isZeitaufwendig();
			break;
		case COL_ERSTPROFESSION:
			retval = data.get(row).isErstprofession();
			break;
		case COL_VORAUSSETZUNG:
			retval = "";
			for(Profession_Eigenschaft_Voraussetzung p:data.get(row).getVoraussetzung_eigenschaft()){
				if(retval.equals(""))
					retval+=", ";
				retval += p.getEigenschaft().getKuerzel()+": "+p.getModifikator().toString();
				
			}
			if(data.get(row).getVoraussetzung_sozialstatus() != null){
				if(retval.equals(""))
					retval+=", ";
				retval += "SO: "+data.get(row).getVoraussetzung_sozialstatus().toString();
			}
			break;
		case COL_MODIFIKATOREN:
			retval = "AU: "+data.get(row).getAusdauer_modifikator();//
			break;
		case COL_TALENTE:
			retval = new <Profession_TalentGruppe_Mod>CollectionGenericWrapper(data.get(row).getTalente(),Profession_TalentGruppe_Mod.class);
			break;
		case COL_SONDERFERTIGKEITEN:
			retval = new <Sonderfertigkeit>CollectionGenericWrapper(data.get(row).getVerbilligteSonderfertigkeiten(),Sonderfertigkeit.class);
			break;
		case COL_NACHTEILE:
			retval = new <Profession_Nachteil>CollectionGenericWrapper(data.get(row).getProfession_nachteile(),Profession_Nachteil.class);
			break;
		case COL_VORTEILE:
			retval = new <Profession_Vorteil>CollectionGenericWrapper(data.get(row).getProfession_vorteile(),Profession_Vorteil.class);
			break;
		case COL_VARIANTEN:
			retval = new <Profession_Variante>CollectionGenericWrapper(data.get(row).getVarianten(),Profession_Variante.class);
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
	
	public void addRow(Profession rowData){
		insertRow(getRowCount(), rowData);
	}
	
	public void insertRow(int row, Profession rowData){
		data.add(row,rowData);
		fireTableRowsInserted(row, row);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
}
