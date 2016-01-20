package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import dsa.common.gui.editableLists.AttributeListGUI;
import dsa.common.gui.editableLists.editPanel.AttributeEditGUI;

@SuppressWarnings("serial")
public class AttributeCreatorFrame extends JPanel {
	private static AttributeCreatorFrame currentAttributeCreatorFrame;
	public AttributeCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		AttributeListGUI attributeList = new AttributeListGUI();
		
		JTextPane infoPane = new JTextPane();
		infoPane.setText(attributeList.getInformation());
		infoPane.setEditable(false);
		
		AttributeEditGUI editPanel = new AttributeEditGUI(attributeList.getTable());
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		contentPanel.add(attributeList,BorderLayout.CENTER);
		contentPanel.add(editPanel,BorderLayout.EAST);
		add(contentPanel,BorderLayout.CENTER);
		add(infoPane,BorderLayout.SOUTH);
		
		setCurrentAttributeCreatorFrame(this);
	}
	public static AttributeCreatorFrame getCurrentAttributeCreatorFrame() {
		if (currentAttributeCreatorFrame == null)
			new AttributeCreatorFrame();
		return currentAttributeCreatorFrame;
	}
	private static void setCurrentAttributeCreatorFrame(AttributeCreatorFrame currentAttributeCreatorFrame) {
		AttributeCreatorFrame.currentAttributeCreatorFrame = currentAttributeCreatorFrame;
	}
}
