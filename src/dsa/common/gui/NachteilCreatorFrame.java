package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.NachteilListGUI;
import dsa.common.gui.editableLists.editPanel.NachteilEditGUI;

@SuppressWarnings("serial")
public class NachteilCreatorFrame extends JPanel {
	private static NachteilCreatorFrame currentNachteilCreatorFrame;
	private NachteilListGUI nachteilList = null;
	private NachteilEditGUI editPanel = null;
	private JPanel contentPanel = null;
	public NachteilCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				nachteilList = new NachteilListGUI();
				
				infoPane.setText(nachteilList.getInformation());
				
				editPanel = new NachteilEditGUI(nachteilList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(nachteilList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		setCurrentNachteilCreatorFrame(this);
	}
	public static NachteilCreatorFrame getCurrentNachteilCreatorFrame() {
		if (currentNachteilCreatorFrame == null)
			new NachteilCreatorFrame();
		return currentNachteilCreatorFrame;
	}
	private static void setCurrentNachteilCreatorFrame(NachteilCreatorFrame currentNachteilCreatorFrame) {
		NachteilCreatorFrame.currentNachteilCreatorFrame = currentNachteilCreatorFrame;
	}
}
