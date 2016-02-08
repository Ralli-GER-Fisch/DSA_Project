package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.ProfessionListGUI;
import dsa.common.gui.editableLists.editPanel.ProfessionEditGUI;

@SuppressWarnings("serial")
public class ProfessionCreatorFrame extends JPanel {
	private static ProfessionCreatorFrame currentProfessionCreatorFrame;
	private JPanel contentPanel = null;
	private ProfessionEditGUI editPanel = null;
	private ProfessionListGUI professionList = null;
	public ProfessionCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				professionList = new ProfessionListGUI();
				
				infoPane.setText(professionList.getInformation());
				
				editPanel = new ProfessionEditGUI(professionList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(professionList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		
		setCurrentProfessionCreatorFrame(this);
	}
	public static ProfessionCreatorFrame getCurrentProfessionCreatorFrame() {
		if (currentProfessionCreatorFrame == null)
			new ProfessionCreatorFrame();
		return currentProfessionCreatorFrame;
	}
	private static void setCurrentProfessionCreatorFrame(ProfessionCreatorFrame currentProfessionCreatorFrame) {
		ProfessionCreatorFrame.currentProfessionCreatorFrame = currentProfessionCreatorFrame;
	}
}
