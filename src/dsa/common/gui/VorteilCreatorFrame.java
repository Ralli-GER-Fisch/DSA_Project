package dsa.common.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import dsa.common.gui.editableLists.VorteilListGUI;
import dsa.common.gui.editableLists.editPanel.VorteilEditGUI;

@SuppressWarnings("serial")
public class VorteilCreatorFrame extends JPanel {
	private static VorteilCreatorFrame currentVorteilCreatorFrame;
	private VorteilListGUI vorteilList = null;
	private VorteilEditGUI editPanel = null;
	private JPanel contentPanel = null;
	public VorteilCreatorFrame() {
		super();
		setLayout(new BorderLayout());
		add(MainMenuFrame.LOADING_GIF,BorderLayout.CENTER);
		JTextPane infoPane = new JTextPane();
		infoPane.setEditable(false);
		new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				vorteilList = new VorteilListGUI();
				
				infoPane.setText(vorteilList.getInformation());
				
				editPanel = new VorteilEditGUI(vorteilList.getTable());
				
				contentPanel = new JPanel(new BorderLayout());
				return null;
			}
			@Override
			protected void done() {
				contentPanel.add(vorteilList,BorderLayout.CENTER);
				contentPanel.add(editPanel,BorderLayout.EAST);
				
				remove(MainMenuFrame.LOADING_GIF);
				add(contentPanel,BorderLayout.CENTER);
				add(infoPane,BorderLayout.SOUTH);
				validate();
			};
		}.execute();
		setCurrentVorteilCreatorFrame(this);
	}
	public static VorteilCreatorFrame getCurrentVorteilCreatorFrame() {
		if (currentVorteilCreatorFrame == null)
			new VorteilCreatorFrame();
		return currentVorteilCreatorFrame;
	}
	private static void setCurrentVorteilCreatorFrame(VorteilCreatorFrame currentVorteilCreatorFrame) {
		VorteilCreatorFrame.currentVorteilCreatorFrame = currentVorteilCreatorFrame;
	}
}
