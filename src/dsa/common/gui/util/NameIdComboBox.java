package dsa.common.gui.util;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;

import javax.swing.JComboBox;

import dsa.common.data.wrapper.NameIdWrapper;

@SuppressWarnings("serial")
public class NameIdComboBox extends JComboBox<NameIdWrapper> {

	@SuppressWarnings("unchecked")
	public NameIdComboBox(List<? extends NameIdWrapper> itemList) {
		super(getItems(itemList));
		super.setRenderer(new NameIdRenderer());
		super.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int newIndex = getSelectedIndex()+e.getWheelRotation();
				e.consume();
				if(newIndex >= 0)
					if(newIndex < getItemCount())
						setSelectedIndex(newIndex);
			}
		});
	}

	private static NameIdWrapper[] getItems(List<? extends NameIdWrapper> itemList) {
		NameIdWrapper[] itemArr = new NameIdWrapper[itemList.size()];
		return itemList.toArray(itemArr);
	}
	
	@Override
	public NameIdWrapper getSelectedItem() {
		return (NameIdWrapper) super.getSelectedItem();
	}
}
