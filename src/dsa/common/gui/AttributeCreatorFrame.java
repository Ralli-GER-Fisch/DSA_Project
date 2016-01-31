package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.AttributeListGUI;
import dsa.common.gui.editableLists.editPanel.AttributeEditGUI;

@SuppressWarnings("serial")
public class AttributeCreatorFrame extends JPanel {
	private static AttributeCreatorFrame currentAttributeCreatorFrame;
	private AttributeListGUI attributeList = null;
	private AttributeEditGUI editPanel = null;
	private JPanel contentPanel = null;
	public AttributeCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				attributeList = new AttributeListGUI();
				
				infoPane.setText(attributeList.getInformation());
				
				editPanel = new AttributeEditGUI(attributeList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(attributeList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
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
