package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.TalentListGUI;
import dsa.common.gui.editableLists.editPanel.TalentEditGUI;

@SuppressWarnings("serial")
public class TalentCreatorFrame extends JPanel {
	private static TalentCreatorFrame currentTalentCreatorFrame;
	private JPanel contentPanel = null;
	private TalentEditGUI editPanel = null;
	private TalentListGUI talentList = null;
	public TalentCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				talentList = new TalentListGUI();
				
				infoPane.setText(talentList.getInformation());
				
				editPanel = new TalentEditGUI(talentList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(talentList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		
		setCurrentTalentCreatorFrame(this);
	}
	public static TalentCreatorFrame getCurrentTalentCreatorFrame() {
		if (currentTalentCreatorFrame == null)
			new TalentCreatorFrame();
		return currentTalentCreatorFrame;
	}
	private static void setCurrentTalentCreatorFrame(TalentCreatorFrame currentTalentCreatorFrame) {
		TalentCreatorFrame.currentTalentCreatorFrame = currentTalentCreatorFrame;
	}
}
