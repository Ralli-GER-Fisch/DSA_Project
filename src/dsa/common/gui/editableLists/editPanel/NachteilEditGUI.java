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

import dsa.common.data.Nachteil;
import dsa.common.gui.editableLists.editPanel.frames.NachteilEditFrame;
import dsa.common.gui.editableLists.tableModels.NachteilTableModel;
import dsa.common.manage.DbManager;


@SuppressWarnings("serial")
public class NachteilEditGUI extends JPanel {
	private static final String ACTION_NEW = "new",
								ACTION_EDIT = "edit",
								ACTION_DELETE = "del";
	public NachteilEditGUI(JTable nachteilTable) {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
					case ACTION_NEW:
						new NachteilEditFrame(new Nachteil(),nachteilTable);
						break;
					case ACTION_EDIT:
						if(nachteilTable.getSelectedRow() >= 0)
							new NachteilEditFrame(((NachteilTableModel)nachteilTable.getModel())
														.getRowObject(nachteilTable.convertRowIndexToModel(nachteilTable.getSelectedRow())),nachteilTable);
						break;
					case ACTION_DELETE:
						if(nachteilTable.getSelectedRow()>=0){
							DbManager.getCurrentDbManager().deleteObject(((NachteilTableModel)nachteilTable.getModel())
									.getRowObject(nachteilTable.convertRowIndexToModel(nachteilTable.getSelectedRow())));
							((NachteilTableModel)nachteilTable.getModel()).removeRow(nachteilTable.convertRowIndexToModel(nachteilTable.getSelectedRow()));
							((NachteilTableModel)nachteilTable.getModel()).fireTableDataChanged();
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

		
		nachteilTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
