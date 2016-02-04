package dsa.common.gui.editableLists.editPanel.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.AbstractTableModel;
import javax.swing.undo.UndoManager;

import dsa.common.ctrl.util.CustomUndoableEditListener;
import dsa.common.ctrl.util.actions.RedoAction;
import dsa.common.ctrl.util.actions.UndoAction;
import dsa.common.data.Nachteil;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class NachteilEditFrame extends JFrame {
	public NachteilEditFrame(Nachteil nachteil, JTable nachteilTable) {
		if (nachteil.getId() == null)
			setTitle("Neuer Nachteil");
		else
			setTitle("Nachteil "+ nachteil.getName() +" editieren");
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setAlignmentY(0);
		JTextField idTF = new JTextField(nachteil.getId()==null?"":nachteil.getId().toString());
		idTF.setEnabled(false);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setAlignmentY(0);
		JTextField nameTF = new JTextField(nachteil.getName());
		UndoManager nameUndoManager = new UndoManager();
		nameTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(nameUndoManager));
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		nameTF.getActionMap().put("undo",new UndoAction(nameUndoManager));
		nameTF.getActionMap().put("redo",new RedoAction(nameUndoManager));
		
		JLabel geLabel = new JLabel("Generierungskosten");
		geLabel.setAlignmentY(0);
		JSpinner geSP = new JSpinner();
		geSP.setValue(nachteil.getGenerierungskosten()!=null?nachteil.getGenerierungskosten():new Integer(0));
		JTextField geTF = new JTextField(nachteil.getKostenzusatz());
		UndoManager geUndoManager = new UndoManager();
		geTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(geUndoManager));
		geTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		geTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		geTF.getActionMap().put("undo",new UndoAction(geUndoManager));
		geTF.getActionMap().put("redo",new RedoAction(geUndoManager));
		
		
		JLabel beschreibungLabel = new JLabel("Beschreibung");
		beschreibungLabel.setAlignmentY(0);
		
		JTextArea beschreibungTF = new JTextArea(nachteil.getBeschreibung());
		beschreibungTF.setWrapStyleWord(true);
		beschreibungTF.setLineWrap(true);
		UndoManager beschreibungUndoManager = new UndoManager();
		beschreibungTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(beschreibungUndoManager));
		beschreibungTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		beschreibungTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		beschreibungTF.getActionMap().put("undo",new UndoAction(beschreibungUndoManager));
		beschreibungTF.getActionMap().put("redo",new RedoAction(beschreibungUndoManager));
		JScrollPane beschreibungScrollPane = new JScrollPane(beschreibungTF);
		beschreibungScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		beschreibungScrollPane.setPreferredSize(new Dimension(200,100));
		
		JButton saveButton = new JButton("Speichern");
		saveButton.setActionCommand("edit");
		if (nachteil.getId() == null){
			saveButton.setText("Erstellen");
			saveButton.setActionCommand("new");
		}
		
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.setActionCommand("cancel");
		
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
					case "new":
						nachteil.setName(nameTF.getText());
						nachteil.setBeschreibung(beschreibungTF.getText());
						nachteil.setGenerierungskosten((Integer)geSP.getValue());
						nachteil.setKostenzusatz(geTF.getText());
						DbManager.getCurrentDbManager().createNewObject(nachteil);
						dispose();
						((AbstractTableModel)nachteilTable.getModel()).fireTableDataChanged();
						break;
					case "edit":
						nachteil.setName(nameTF.getText());
						nachteil.setBeschreibung(beschreibungTF.getText());
						nachteil.setGenerierungskosten((Integer)geSP.getValue());
						nachteil.setKostenzusatz(geTF.getText());
						DbManager.getCurrentDbManager().updateObject(nachteil);
						dispose();
						((AbstractTableModel)nachteilTable.getModel()).fireTableDataChanged();
						break;
					case "cancel":
						dispose();
						break;
				}
			}
		};
		
		saveButton.addActionListener(buttonListener);
		cancelButton.addActionListener(buttonListener);
		
		cons.gridy = 0;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(idLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(idTF,cons);
		
		cons.gridy = 1;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(nameLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(nameTF,cons);

		cons.gridy = 2;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(geLabel,cons);
		cons.gridx = 1;
		getContentPane().add(geSP,cons);
		cons.gridx = 2;
		getContentPane().add(geTF,cons);
		
		cons.gridy = 3;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(beschreibungLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(beschreibungScrollPane,cons);
		
		cons.gridy = 4;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(saveButton,cons);
		cons.fill = GridBagConstraints.NONE;
		cons.weightx = 0;
		cons.gridx = 1;
		getContentPane().add(cancelButton,cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		cons.gridx = 2;
		getContentPane().add(Box.createHorizontalGlue(),cons);
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
