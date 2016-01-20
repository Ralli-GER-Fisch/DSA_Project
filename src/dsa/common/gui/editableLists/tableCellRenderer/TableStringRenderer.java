package dsa.common.gui.editableLists.tableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class TableStringRenderer implements TableCellRenderer {
	private static TableStringRenderer currentInstance;
	public TableStringRenderer(){}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JTextArea editor = new JTextArea();
		if (value!= null)
			editor.setText(value.toString());
		editor.setEditable(false);
		editor.setOpaque(true);
		editor.setBackground((row %2 == 0) ? Color.WHITE:Color.LIGHT_GRAY);
		return editor;
	}
	public static TableStringRenderer getCurrentInstance() {
		if(currentInstance == null)
			setCurrentInstance(new TableStringRenderer());
		return currentInstance;
	}
	private static void setCurrentInstance(TableStringRenderer currentInstance) {
		TableStringRenderer.currentInstance = currentInstance;
	}

}
