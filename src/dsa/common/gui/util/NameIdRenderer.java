package dsa.common.gui.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import dsa.common.data.wrapper.NameIdWrapper;

@SuppressWarnings("serial")
public class NameIdRenderer extends BasicComboBoxRenderer {
	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (value != null) {
			NameIdWrapper item = (NameIdWrapper) value;
			setText(item.getName());
		}

		if (index == -1) {
			NameIdWrapper item = (NameIdWrapper) value;
			setText(item.getName());
		}

		return this;
	}
}
