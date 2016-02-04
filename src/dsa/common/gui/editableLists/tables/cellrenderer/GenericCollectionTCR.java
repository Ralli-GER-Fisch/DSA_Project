package dsa.common.gui.editableLists.tables.cellrenderer;

import java.awt.Component;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import dsa.common.data.mappings.Probe;
import dsa.common.data.mappings.Rasse_Eigenschaft_Mod;
import dsa.common.data.mappings.Rasse_Kultur;
import dsa.common.data.mappings.Rasse_Nachteil;
import dsa.common.data.mappings.Rasse_Talent_Mod;
import dsa.common.data.mappings.Rasse_Vorteil;
import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.main.constants.Constants;

public class GenericCollectionTCR implements TableCellRenderer {

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		String retvalString = "";
		//Component retval;
		if(value instanceof CollectionGenericWrapper){
			Class<?> valueClass = ((CollectionGenericWrapper) value).contentClass;
			Collection<?> valueData = ((CollectionGenericWrapper) value).data;
			
			//Different Collection Types
			
			if(valueClass.equals(Probe.class)){
				
				for(Probe p: ((Collection<Probe>)valueData)){
					if(!retvalString.isEmpty())
						retvalString += ", ";
					retvalString += p.getEigenschaft1().getKuerzel()+"/"+p.getEigenschaft2().getKuerzel()+"/"+p.getEigenschaft3().getKuerzel();
				}
			}
			if(valueClass.equals(Rasse_Eigenschaft_Mod.class)){
				
				for(Rasse_Eigenschaft_Mod e: ((Collection<Rasse_Eigenschaft_Mod>)valueData)){
					if(!retvalString.isEmpty())
						retvalString += ", ";
					retvalString += e.getEigenschaft().getKuerzel() +": "+e.getModifikator().toString();
				}
			}
			if(valueClass.equals(Rasse_Vorteil.class)){
				String autoRet = "", posRet = "", badRet = "";
				for(Rasse_Vorteil v: ((Collection<Rasse_Vorteil>)valueData)){
					switch(v.getTyp().byteValue()){
						case Rasse_Vorteil.RASSE_VORTEIL_AUTOMATISCH:
							if(!autoRet.isEmpty())
								autoRet += ", ";
							else
								autoRet += "Automatisch: ";
							autoRet += v.getVorteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
						case Rasse_Vorteil.RASSE_VORTEIL_EMPFOHLEN:
							if(!posRet.isEmpty())
								posRet += ", ";
							else
								posRet += "Empfohlen: ";
							posRet += v.getVorteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
						case Rasse_Vorteil.RASSE_VORTEIL_UNGEEIGNET:
							if(!badRet.isEmpty())
								badRet += ", ";
							else
								badRet += "Ungeeignet: ";
							badRet += v.getVorteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
					}
					retvalString += autoRet+"|"+posRet+"|"+badRet;
				}
			}
			if(valueClass.equals(Rasse_Nachteil.class)){
				String autoRet = "", posRet = "", badRet = "";
				for(Rasse_Nachteil v: ((Collection<Rasse_Nachteil>)valueData)){
					switch(v.getTyp().byteValue()){
						case Rasse_Nachteil.RASSE_NACHTEIL_AUTOMATISCH:
							if(!autoRet.isEmpty())
								autoRet += ", ";
							else
								autoRet += "Automatisch: ";
							autoRet += v.getNachteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
						case Rasse_Nachteil.RASSE_NACHTEIL_EMPFOHLEN:
							if(!posRet.isEmpty())
								posRet += ", ";
							else
								posRet += "Empfohlen: ";
							posRet += v.getNachteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
						case Rasse_Nachteil.RASSE_NACHTEIL_UNGEEIGNET:
							if(!badRet.isEmpty())
								badRet += ", ";
							else
								badRet += "Ungeeignet: ";
							badRet += v.getNachteil().getName()+(v.getWert().equals(new Integer(-1))?"":("("+v.getWert()+")"));
							break;
					}
					retvalString += autoRet+"|"+posRet+"|"+badRet;
				}
			}
			if(valueClass.equals(Rasse_Kultur.class)){
				String uebRet="",moegRet="";
				for(Rasse_Kultur v: ((Collection<Rasse_Kultur>)valueData)){
					switch(v.getTyp().byteValue()){
						case Rasse_Kultur.RASSE_KULTUR_UEBLICH:
							if(!uebRet.isEmpty())
								uebRet += ", ";
							else
								uebRet += "Üblich: ";
							uebRet += v.getKultur().getName();
							break;
						case Rasse_Kultur.RASSE_KULTUR_MOEGLICH:
							if(!moegRet.isEmpty())
								moegRet += ", ";
							else
								moegRet += "Möglich: ";
							moegRet += v.getKultur().getName();
							break;
					}
					retvalString += uebRet+"|"+moegRet;
				}
			}
			if(valueClass.equals(Rasse_Talent_Mod.class)){
				
				for(Rasse_Talent_Mod t: ((Collection<Rasse_Talent_Mod>)valueData)){
					if(!retvalString.isEmpty())
						retvalString += ", ";
					retvalString += t.getTalent().getName()+": "+t.getModifikator().toString();
				}
			}
		}
		JLabel retval = new JLabel(retvalString);
		retval.setOpaque(true);
		retval.setHorizontalTextPosition(SwingConstants.LEFT);
		if(isSelected){
			retval.setBackground(Constants.SELECTED_ROW_BG_COLOR);
			retval.setForeground(Constants.SELECTED_ROW_TEXT_COLOR);
		} else if(table instanceof CustomRenderedTable &&
				((CustomRenderedTable<?>) table).getMouseOverRow() == row){//check hover
				retval.setBackground(Constants.MOUSEOVER_ROW_BG_COLOR);
				retval.setForeground(Constants.MOUSEOVER_ROW_TEXT_COLOR);
		} else {
			if(row%2 == 0){
				retval.setBackground(Constants.EVEN_ROW_BG_COLOR);
				retval.setForeground(Constants.EVEN_ROW_TEXT_COLOR);
			}
			else{
				retval.setBackground(Constants.ODD_ROW_BG_COLOR);
				retval.setForeground(Constants.ODD_ROW_TEXT_COLOR);
			}
		}
		
		
		return retval;
	}

}
