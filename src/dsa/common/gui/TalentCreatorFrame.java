package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import dsa.common.gui.editableLists.TalentListGUI;
import dsa.common.gui.editableLists.editPanel.TalentEditGUI;

@SuppressWarnings("serial")
public class TalentCreatorFrame extends JPanel {
	private static TalentCreatorFrame currentTalentCreatorFrame;
	public TalentCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		TalentListGUI talentList = new TalentListGUI();
		
		JTextPane infoPane = new JTextPane();
		infoPane.setText(talentList.getInformation());
		infoPane.setEditable(false);
		
		TalentEditGUI editPanel = new TalentEditGUI(talentList.getTable());
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		contentPanel.add(talentList,BorderLayout.CENTER);
		contentPanel.add(editPanel,BorderLayout.EAST);
		add(contentPanel,BorderLayout.CENTER);
		add(infoPane,BorderLayout.SOUTH);
		
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
