package dsa.common.gui.editableLists.editPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dsa.common.data.Vorteil;
import dsa.common.gui.editableLists.editPanel.frames.VorteilEditFrame;
import dsa.common.gui.editableLists.tableModels.VorteilTableModel;
import dsa.common.manage.DbManager;


@SuppressWarnings("serial")
public class VorteilEditGUI extends JPanel {
	private static final String ACTION_NEW = "new",
								ACTION_EDIT = "edit",
								ACTION_DELETE = "del";
	public VorteilEditGUI(JTable vorteilTable) {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
					case ACTION_NEW:
						new VorteilEditFrame(new Vorteil(),vorteilTable);
						break;
					case ACTION_EDIT:
						if(vorteilTable.getSelectedRow() >= 0)
							new VorteilEditFrame(((VorteilTableModel)vorteilTable.getModel())
														.getRowObject(vorteilTable.convertRowIndexToModel(vorteilTable.getSelectedRow())),vorteilTable);
						break;
					case ACTION_DELETE:
						if(vorteilTable.getSelectedRow()>=0){
							DbManager.getCurrentDbManager().deleteObject(((VorteilTableModel)vorteilTable.getModel())
									.getRowObject(vorteilTable.convertRowIndexToModel(vorteilTable.getSelectedRow())));
							((VorteilTableModel)vorteilTable.getModel()).removeRow(vorteilTable.convertRowIndexToModel(vorteilTable.getSelectedRow()));
							((VorteilTableModel)vorteilTable.getModel()).fireTableDataChanged();
						}
						break;
				}
				
			}
		};
		JButton newButton = new JButton("Neu");
		JButton editButton = new JButton("Editieren");
		JButton deleteButton = new JButton("Löschen");
		newButton.setActionCommand(ACTION_NEW);
		editButton.setActionCommand(ACTION_EDIT);
		deleteButton.setActionCommand(ACTION_DELETE);
		editButton.setEnabled(false);
		deleteButton.setEnabled(false);
		
		newButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);

		
		vorteilTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getFirstIndex()>=0){
					editButton.setEnabled(true);
					deleteButton.setEnabled(true);
				}
			}
		});
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		
		add(newButton,cons);
		add(editButton,cons);
		add(deleteButton,cons);
		cons.weighty = 1;
		add(Box.createVerticalGlue(),cons);
		setBackground(Color.WHITE);
	}
}
