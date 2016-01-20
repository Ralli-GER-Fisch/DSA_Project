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

import dsa.common.data.Eigenschaft;
import dsa.common.gui.editableLists.editPanel.frames.AttributeEditFrame;
import dsa.common.gui.editableLists.tableModels.AttributeTableModel;
import dsa.common.manage.DbManager;


@SuppressWarnings("serial")
public class AttributeEditGUI extends JPanel {
	private static final String ACTION_NEW = "new",
								ACTION_EDIT = "edit",
								ACTION_DELETE = "del";
	private int currentSelection = -1;
	public AttributeEditGUI(JTable attributeTable) {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
					case ACTION_NEW:
						new AttributeEditFrame(new Eigenschaft(),attributeTable);
						break;
					case ACTION_EDIT:
						if(attributeTable.getSelectedRow() >= 0)
							new AttributeEditFrame(((AttributeTableModel)attributeTable.getModel())
														.getRowObject(attributeTable.getSelectedRow()),attributeTable);
						break;
					case ACTION_DELETE:
						DbManager.getCurrentDbManager().deleteObject(((AttributeTableModel)attributeTable.getModel())
								.getRowObject(attributeTable.getSelectedRow()));
						((AttributeTableModel)attributeTable.getModel()).removeRow(attributeTable.getSelectedRow());
						((AttributeTableModel)attributeTable.getModel()).fireTableDataChanged();
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
		
		newButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);

		
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
	public int getCurrentSelection() {
		return currentSelection;
	}
	public void setCurrentSelection(int currentSelection) {
		this.currentSelection = currentSelection;
	}
}
