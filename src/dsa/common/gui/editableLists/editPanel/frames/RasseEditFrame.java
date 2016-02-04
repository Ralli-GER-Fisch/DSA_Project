package dsa.common.gui.editableLists.editPanel.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

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
import dsa.common.data.Rasse;
import dsa.common.data.mappings.Rasse_Eigenschaft_Mod;
import dsa.common.data.mappings.Rasse_Nachteil;
import dsa.common.data.mappings.Rasse_Vorteil;
import dsa.common.gui.editableLists.editPanel.AddAttributePanel;
import dsa.common.gui.editableLists.editPanel.AddNachteilePanel;
import dsa.common.gui.editableLists.editPanel.AddVorteilePanel;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class RasseEditFrame extends JFrame {
	public RasseEditFrame(Rasse rasse, JTable rasseTable) {
		if (rasse.getId() == null)
			setTitle("Neue Rasse");
		else
			setTitle("Rasse "+ rasse.getName() +" editieren");
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setAlignmentY(0);
		JTextField idTF = new JTextField(rasse.getId()==null?"":rasse.getId().toString());
		idTF.setEnabled(false);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setAlignmentY(0);
		JTextField nameTF = new JTextField(rasse.getName());
		UndoManager nameUndoManager = new UndoManager();
		nameTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(nameUndoManager));
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		nameTF.getActionMap().put("undo",new UndoAction(nameUndoManager));
		nameTF.getActionMap().put("redo",new RedoAction(nameUndoManager));

		JLabel groesseLabel = new JLabel("Größe-Regel");
		groesseLabel.setAlignmentY(0);
		JTextField groesseTF = new JTextField(rasse.getKoerpergroesse_regel());
		UndoManager groesseUndoManager = new UndoManager();
		groesseTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(groesseUndoManager));
		groesseTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		groesseTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		groesseTF.getActionMap().put("undo",new UndoAction(groesseUndoManager));
		groesseTF.getActionMap().put("redo",new RedoAction(groesseUndoManager));
		
		JLabel gewichtLabel = new JLabel("Gewicht-Regel");
		gewichtLabel.setAlignmentY(0);
		JTextField gewichtTF = new JTextField(rasse.getGewicht_regel());
		UndoManager gewichtUndoManager = new UndoManager();
		gewichtTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(gewichtUndoManager));
		gewichtTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		gewichtTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		gewichtTF.getActionMap().put("undo",new UndoAction(gewichtUndoManager));
		gewichtTF.getActionMap().put("redo",new RedoAction(gewichtUndoManager));
		
		JLabel gemodLabel = new JLabel("Generierungskosten");
		gemodLabel.setAlignmentY(0);
		JSpinner gemodSP = new JSpinner();
		gemodSP.setValue(rasse.getGenerierungskosten()!=null?rasse.getGenerierungskosten():new Integer(0));
		
		JLabel lemodLabel = new JLabel("Lebenspunkte-Modifikator");
		lemodLabel.setAlignmentY(0);
		JSpinner lemodSP = new JSpinner();
		lemodSP.setValue(rasse.getLebenspunkte_modifikator()!=null?rasse.getLebenspunkte_modifikator():new Integer(0));
		
		JLabel aumodLabel = new JLabel("Ausdauer-Modifikator");
		aumodLabel.setAlignmentY(0);
		JSpinner aumodSP = new JSpinner();
		aumodSP.setValue(rasse.getAusdauer_modifikator()!=null?rasse.getAusdauer_modifikator():new Integer(0));
		
		JLabel mrmodLabel = new JLabel("Magieresistenz-Modifikator");
		mrmodLabel.setAlignmentY(0);
		JSpinner mrmodSP = new JSpinner();
		mrmodSP.setValue(rasse.getMagieresistenz_modifikator()!=null?rasse.getMagieresistenz_modifikator():new Integer(0));
		
		JLabel herkunftLabel = new JLabel("Herkunft und Verbreitung");
		herkunftLabel.setAlignmentY(0);
		
		JTextArea herkunftTF = new JTextArea(rasse.getHerkunft_verbreitung());
		herkunftTF.setWrapStyleWord(true);
		herkunftTF.setLineWrap(true);
		UndoManager herkunftUndoManager = new UndoManager();
		herkunftTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(herkunftUndoManager));
		herkunftTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		herkunftTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		herkunftTF.getActionMap().put("undo",new UndoAction(herkunftUndoManager));
		herkunftTF.getActionMap().put("redo",new RedoAction(herkunftUndoManager));
		JScrollPane herkunftScrollPane = new JScrollPane(herkunftTF);
		herkunftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		herkunftScrollPane.setPreferredSize(new Dimension(300,100));
		
		JLabel aussehenLabel = new JLabel("Körperbaue und Aussehen");
		aussehenLabel.setAlignmentY(0);
		
		JTextArea aussehenTF = new JTextArea(rasse.getKoerperbau_aussehen());
		aussehenTF.setWrapStyleWord(true);
		aussehenTF.setLineWrap(true);
		UndoManager aussehenUndoManager = new UndoManager();
		aussehenTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(aussehenUndoManager));
		aussehenTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		aussehenTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		aussehenTF.getActionMap().put("undo",new UndoAction(aussehenUndoManager));
		aussehenTF.getActionMap().put("redo",new RedoAction(aussehenUndoManager));
		JScrollPane aussehenScrollPane = new JScrollPane(aussehenTF);
		aussehenScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		aussehenScrollPane.setPreferredSize(new Dimension(300,100));
		
		JLabel beschreibungLabel = new JLabel("Beschreibung");
		beschreibungLabel.setAlignmentY(0);
		
		JTextArea beschreibungTF = new JTextArea(rasse.getBeschreibung());
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
		
		JLabel eigenschaftLabel = new JLabel("Eigenschaft-Modifikator");
		eigenschaftLabel.setAlignmentY(0);
		AddAttributePanel eigenschaftAP = new AddAttributePanel(rasse,(rasse.getId()==null?(new HashSet<Rasse_Eigenschaft_Mod>()):DbManager.getCurrentDbManager().getAttributeOfRasse(rasse)));
		JScrollPane eigenschaftScrollPane = new JScrollPane(eigenschaftAP);
		eigenschaftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		eigenschaftScrollPane.setPreferredSize(new Dimension(300,100));

		JLabel vorteilLabel = new JLabel("Vorteile");
		vorteilLabel.setAlignmentY(0);
		AddVorteilePanel vorteilAP = new AddVorteilePanel(rasse,(rasse.getId()==null?(new HashSet<Rasse_Vorteil>()):DbManager.getCurrentDbManager().getVorteileOfRasse(rasse)));
		JScrollPane vorteilScrollPane = new JScrollPane(vorteilAP);
		vorteilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vorteilScrollPane.setPreferredSize(new Dimension(300,100));
		
		JLabel nachteilLabel = new JLabel("Nachteile");
		nachteilLabel.setAlignmentY(0);
		AddNachteilePanel nachteilAP = new AddNachteilePanel(rasse,(rasse.getId()==null?(new HashSet<Rasse_Nachteil>()):DbManager.getCurrentDbManager().getNachteileOfRasse(rasse)));
		JScrollPane nachteilScrollPane = new JScrollPane(nachteilAP);
		nachteilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		nachteilScrollPane.setPreferredSize(new Dimension(300,100));
		
		JButton saveButton = new JButton("Speichern");
		saveButton.setActionCommand("edit");
		if (rasse.getId() == null){
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
						rasse.setName(nameTF.getText());
						rasse.setGenerierungskosten((Integer)gemodSP.getValue());
						rasse.setKoerpergroesse_regel(groesseTF.getText());
						rasse.setGewicht_regel(gewichtTF.getText());
						rasse.setLebenspunkte_modifikator((Integer)lemodSP.getValue());
						rasse.setAusdauer_modifikator((Integer)aumodSP.getValue());
						rasse.setMagieresistenz_modifikator((Integer)mrmodSP.getValue());
						rasse.setHerkunft_verbreitung(herkunftTF.getText());
						rasse.setKoerperbau_aussehen(aussehenTF.getText());
						rasse.setBeschreibung(beschreibungTF.getText());
						rasse.setEigenschafts_modifikatoren(eigenschaftAP.getRasse_Eigenschaft_Mods());
						rasse.setRasse_vorteile(vorteilAP.getRasse_Vorteile());
						rasse.setRasse_nachteile(nachteilAP.getRasse_Nachteile());
						DbManager.getCurrentDbManager().createNewObject(rasse);
						dispose();
						((AbstractTableModel)rasseTable.getModel()).fireTableDataChanged();
						break;
					case "edit":
						rasse.setName(nameTF.getText());
						rasse.setGenerierungskosten((Integer)gemodSP.getValue());
						rasse.setKoerpergroesse_regel(groesseTF.getText());
						rasse.setGewicht_regel(gewichtTF.getText());
						rasse.setLebenspunkte_modifikator((Integer)lemodSP.getValue());
						rasse.setAusdauer_modifikator((Integer)aumodSP.getValue());
						rasse.setMagieresistenz_modifikator((Integer)mrmodSP.getValue());
						rasse.setHerkunft_verbreitung(herkunftTF.getText());
						rasse.setKoerperbau_aussehen(aussehenTF.getText());
						rasse.setBeschreibung(beschreibungTF.getText());
						rasse.setEigenschafts_modifikatoren(eigenschaftAP.getRasse_Eigenschaft_Mods());
						rasse.setRasse_vorteile(vorteilAP.getRasse_Vorteile());
						rasse.setRasse_nachteile(nachteilAP.getRasse_Nachteile());
						DbManager.getCurrentDbManager().mergeObject(rasse);
						dispose();
						((AbstractTableModel)rasseTable.getModel()).fireTableDataChanged();
						break;
					case "cancel":
						dispose();
						break;
				}
			}
		};
		
		saveButton.addActionListener(buttonListener);
		cancelButton.addActionListener(buttonListener);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
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
		getContentPane().add(gemodLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(gemodSP,cons);
		
		cons.gridy = 3;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(groesseLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(groesseTF,cons);
		
		cons.gridy = 4;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(gewichtLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(gewichtTF,cons);
		
		cons.gridy = 5;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(lemodLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(lemodSP,cons);
		
		cons.gridy = 6;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(aumodLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(aumodSP,cons);
		
		cons.gridy = 7;
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(mrmodLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(mrmodSP,cons);

		cons.gridy = 8;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(herkunftLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(herkunftScrollPane,cons);
		
		cons.gridy = 9;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(aussehenLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(aussehenScrollPane,cons);
		
		cons.gridy = 10;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridwidth = 1;
		getContentPane().add(beschreibungLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(beschreibungScrollPane,cons);
		
		cons.gridy = 0;		
		cons.gridx = 3;
		cons.weightx = 0;
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(eigenschaftLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 4;
		getContentPane().add(eigenschaftScrollPane,cons);
		
		cons.gridy = 4;		
		cons.gridx = 3;
		cons.weightx = 0;
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(vorteilLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 4;
		getContentPane().add(vorteilScrollPane,cons);
		
		cons.gridheight = 1;
		cons.gridy = 11;
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
