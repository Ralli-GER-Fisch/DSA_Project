package dsa.common.gui.editableLists.tables.cellrenderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import dsa.common.gui.editableLists.tables.CustomRenderedTable;
import dsa.common.main.constants.Constants;

public class LongTCR implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel retval = new JLabel(((Long) value).toString());
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
			if(row%2 == 0)
				retval.setBackground(Constants.EVEN_ROW_BG_COLOR);
			else
				retval.setBackground(Constants.ODD_ROW_BG_COLOR);
		}
		
		
		return retval;
	}

}
