package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.RasseListGUI;
import dsa.common.gui.editableLists.editPanel.RasseEditGUI;

@SuppressWarnings("serial")
public class RasseCreatorFrame extends JPanel {
	private static RasseCreatorFrame currentRasseCreatorFrame;
	private JPanel contentPanel = null;
	private RasseEditGUI editPanel = null;
	private RasseListGUI rasseList = null;
	public RasseCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				rasseList = new RasseListGUI();
				
				infoPane.setText(rasseList.getInformation());
				
				editPanel = new RasseEditGUI(rasseList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(rasseList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		
		setCurrentRasseCreatorFrame(this);
	}
	public static RasseCreatorFrame getCurrentRasseCreatorFrame() {
		if (currentRasseCreatorFrame == null)
			new RasseCreatorFrame();
		return currentRasseCreatorFrame;
	}
	private static void setCurrentRasseCreatorFrame(RasseCreatorFrame currentRasseCreatorFrame) {
		RasseCreatorFrame.currentRasseCreatorFrame = currentRasseCreatorFrame;
	}
}
