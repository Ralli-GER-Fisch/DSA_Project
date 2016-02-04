package dsa.common.gui.editableLists.editPanel.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.AbstractTableModel;
import javax.swing.undo.UndoManager;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dsa.common.ctrl.util.CustomUndoableEditListener;
import dsa.common.ctrl.util.actions.RedoAction;
import dsa.common.ctrl.util.actions.UndoAction;
import dsa.common.data.Talent;
import dsa.common.data.mappings.Probe;
import dsa.common.gui.editableLists.editPanel.AddProbePanel;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class TalentEditFrame extends JFrame {
	public TalentEditFrame(Talent talent, JTable talentTable) {
		if (talent.getId() == null)
			setTitle("Neues Talent");
		else
			setTitle("Talent "+ talent.getName() +" editieren");
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setAlignmentY(0);
		JTextField idTF = new JTextField(talent.getId()==null?"":talent.getId().toString());
		idTF.setEnabled(false);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setAlignmentY(0);
		JTextField nameTF = new JTextField(talent.getName());
		UndoManager nameUndoManager = new UndoManager();
		nameTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(nameUndoManager));
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		nameTF.getActionMap().put("undo",new UndoAction(nameUndoManager));
		nameTF.getActionMap().put("redo",new RedoAction(nameUndoManager));
		
		JLabel typLabel = new JLabel("Typ");
		typLabel.setAlignmentY(0);
		NameIdComboBox typSF = new NameIdComboBox(Talent.getTypTalentItemList());
		typSF.setSelectedIndex(talent.getTyp()==null?0:talent.getTyp().intValue());
		AutoCompleteDecorator.decorate(typSF);
		
		JLabel gruppeLabel = new JLabel("Gruppe");
		gruppeLabel.setAlignmentY(0);
		NameIdComboBox gruppeSF = new NameIdComboBox(Talent.getGruppeTalentItemList());
		gruppeSF.setSelectedIndex(talent.getGruppe()==null?0:talent.getGruppe().intValue());
		AutoCompleteDecorator.decorate(gruppeSF);
		
		JLabel spalteLabel = new JLabel("Spalte");
		spalteLabel.setAlignmentY(0);
		JComboBox<String> spalteSF = new JComboBox<String>(new String[]{"A","B","C","D","E","F","G","H"});
		spalteSF.setSelectedItem(talent.getSpalte()==null?"A":talent.getSpalte());
		AutoCompleteDecorator.decorate(spalteSF);
		spalteSF.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int newIndex = spalteSF.getSelectedIndex()+e.getWheelRotation();
				e.consume();
				if(newIndex >= 0)
					if(newIndex < spalteSF.getItemCount())
						spalteSF.setSelectedIndex(newIndex);
			}
		});
		
		
		JLabel ebeLabel = new JLabel("eBE");
		ebeLabel.setAlignmentY(0);
		JTextField ebeTF = new JTextField(talent.geteBe()==null?"BE":talent.geteBe());
		UndoManager ebeUndoManager = new UndoManager();
		ebeTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(ebeUndoManager));
		ebeTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		ebeTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		ebeTF.getActionMap().put("undo",new UndoAction(ebeUndoManager));
		ebeTF.getActionMap().put("redo",new RedoAction(ebeUndoManager));
		
		JLabel kurzinfoLabel = new JLabel("Kurzinfo");
		kurzinfoLabel.setAlignmentY(0);
		JTextField kurzinfoTF = new JTextField(talent.getKurzinfo());
		UndoManager kurzinfoUndoManager = new UndoManager();
		kurzinfoTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(kurzinfoUndoManager));
		kurzinfoTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		kurzinfoTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		kurzinfoTF.getActionMap().put("undo",new UndoAction(kurzinfoUndoManager));
		kurzinfoTF.getActionMap().put("redo",new RedoAction(kurzinfoUndoManager));
		
		
		
		JLabel beschreibungLabel = new JLabel("Beschreibung");
		beschreibungLabel.setAlignmentY(0);
		
		JTextArea beschreibungTF = new JTextArea(talent.getBeschreibung());
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
		beschreibungScrollPane.setPreferredSize(new Dimension(300,100));
		
		JLabel probeLabel = new JLabel("Proben");
		probeLabel.setAlignmentY(0);
		AddProbePanel probeAP = new AddProbePanel(talent,talent.getId()==null?(new HashSet<Probe>()):DbManager.getCurrentDbManager().getProbenOfTalent(talent));
		JScrollPane probeScrollPane = new JScrollPane(probeAP);
		probeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		probeScrollPane.setPreferredSize(new Dimension(300,100));
		
		JButton saveButton = new JButton("Speichern");
		saveButton.setActionCommand("edit");
		if (talent.getId() == null){
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
						talent.setName(nameTF.getText());
						talent.setTyp(new Long((long) typSF.getSelectedItem().getId()));
						talent.setGruppe(new Long((long) gruppeSF.getSelectedItem().getId()));
						talent.setSpalte(spalteSF.getSelectedItem().toString());
						talent.seteBe(ebeTF.getText());
						talent.setProben(probeAP.getProben());
						talent.setBeschreibung(beschreibungTF.getText());
						talent.setKurzinfo(kurzinfoTF.getText());
						DbManager.getCurrentDbManager().createNewObject(talent);
						dispose();
						((AbstractTableModel)talentTable.getModel()).fireTableDataChanged();
						break;
					case "edit":
						talent.setName(nameTF.getText());
						talent.setTyp(new Long((long) typSF.getSelectedItem().getId()));
						talent.setGruppe(new Long((long) gruppeSF.getSelectedItem().getId()));
						talent.setSpalte(spalteSF.getSelectedItem().toString());
						talent.seteBe(ebeTF.getText());
						talent.setProben(probeAP.getProben());
						talent.setBeschreibung(beschreibungTF.getText());
						talent.setKurzinfo(kurzinfoTF.getText());
						DbManager.getCurrentDbManager().mergeObject(talent);
						dispose();
						((AbstractTableModel)talentTable.getModel()).fireTableDataChanged();
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
		getContentPane().add(kurzinfoLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(kurzinfoTF,cons);
		
		cons.gridy = 3;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(typLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(typSF,cons);
		
		cons.gridy = 4;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(gruppeLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(gruppeSF,cons);
		
		cons.gridy = 5;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(spalteLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(spalteSF,cons);
		
		cons.gridy = 6;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(ebeLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(ebeTF,cons);
		
		cons.gridy = 7;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(probeLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(probeScrollPane,cons);
		
		cons.gridy = 8;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(beschreibungLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(beschreibungScrollPane,cons);
		
		cons.gridy = 9;
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
