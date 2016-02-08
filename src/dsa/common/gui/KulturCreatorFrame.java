package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.KulturListGUI;
import dsa.common.gui.editableLists.editPanel.KulturEditGUI;

@SuppressWarnings("serial")
public class KulturCreatorFrame extends JPanel {
	private static KulturCreatorFrame currentKulturCreatorFrame;
	private JPanel contentPanel = null;
	private KulturEditGUI editPanel = null;
	private KulturListGUI kulturList = null;
	public KulturCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				kulturList = new KulturListGUI();
				
				infoPane.setText(kulturList.getInformation());
				
				editPanel = new KulturEditGUI(kulturList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(kulturList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		
		setCurrentKulturCreatorFrame(this);
	}
	public static KulturCreatorFrame getCurrentKulturCreatorFrame() {
		if (currentKulturCreatorFrame == null)
			new KulturCreatorFrame();
		return currentKulturCreatorFrame;
	}
	private static void setCurrentKulturCreatorFrame(KulturCreatorFrame currentKulturCreatorFrame) {
		KulturCreatorFrame.currentKulturCreatorFrame = currentKulturCreatorFrame;
	}
}
