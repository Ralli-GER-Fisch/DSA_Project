package dsa.common.gui.editableLists.editPanel.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.BorderFactory;
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
import dsa.common.data.Kultur;
import dsa.common.data.mappings.Kultur_Eigenschaft_Mod;
import dsa.common.data.mappings.Kultur_Nachteil;
import dsa.common.data.mappings.Kultur_Talent_Mod;
import dsa.common.data.mappings.Kultur_Vorteil;
import dsa.common.gui.editableLists.editPanel.AddAttributePanel;
import dsa.common.gui.editableLists.editPanel.AddKultur_NachteilPanel;
import dsa.common.gui.editableLists.editPanel.AddKultur_VorteilPanel;
import dsa.common.gui.editableLists.editPanel.AddNachteilePanel;
import dsa.common.gui.editableLists.editPanel.AddTalentPanel;
import dsa.common.gui.editableLists.editPanel.AddVorteilePanel;
import dsa.common.main.constants.Constants;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class KulturEditFrame extends JFrame {
	public KulturEditFrame(Kultur kultur, JTable kulturTable) {
		if (kultur.getId() == null)
			setTitle("Neue Kultur");
		else
			setTitle("Kultur "+ kultur.getName() +" editieren");
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setAlignmentY(0);
		JTextField idTF = new JTextField(kultur.getId()==null?"":kultur.getId().toString());
		idTF.setEnabled(false);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setAlignmentY(0);
		JTextField nameTF = new JTextField(kultur.getName());
		UndoManager nameUndoManager = new UndoManager();
		nameTF.getDocument().addUndoableEditListener(new CustomUndoableEditListener(nameUndoManager));
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "undo");
		nameTF.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK, true), "redo");
		nameTF.getActionMap().put("undo",new UndoAction(nameUndoManager));
		nameTF.getActionMap().put("redo",new RedoAction(nameUndoManager));
		
		JLabel somaxLabel = new JLabel("Maximaler Sozialstatus");
		somaxLabel.setAlignmentY(0);
		JSpinner somaxSP = new JSpinner();
		somaxSP.setValue(kultur.getSozialstatus_maximum()!=null?kultur.getSozialstatus_maximum():new Integer(0));
		
		JLabel gemodLabel = new JLabel("Generierungskosten");
		gemodLabel.setAlignmentY(0);
		JSpinner gemodSP = new JSpinner();
		gemodSP.setValue(kultur.getGenerierungskosten()!=null?kultur.getGenerierungskosten():new Integer(0));
		
		JLabel lemodLabel = new JLabel("Lebenspunkte-Modifikator");
		lemodLabel.setAlignmentY(0);
		JSpinner lemodSP = new JSpinner();
		lemodSP.setValue(kultur.getLebenspunkte_modifikator()!=null?kultur.getLebenspunkte_modifikator():new Integer(0));
		
		JLabel aumodLabel = new JLabel("Ausdauer-Modifikator");
		aumodLabel.setAlignmentY(0);
		JSpinner aumodSP = new JSpinner();
		aumodSP.setValue(kultur.getAusdauer_modifikator()!=null?kultur.getAusdauer_modifikator():new Integer(0));
		
		JLabel mrmodLabel = new JLabel("Magieresistenz-Modifikator");
		mrmodLabel.setAlignmentY(0);
		JSpinner mrmodSP = new JSpinner();
		mrmodSP.setValue(kultur.getMagieresistenz_modifikator()!=null?kultur.getMagieresistenz_modifikator():new Integer(0));
				
		JLabel beschreibungLabel = new JLabel("Beschreibung");
		beschreibungLabel.setAlignmentY(0);
		
		JTextArea beschreibungTF = new JTextArea(kultur.getBeschreibung());
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
		AddKultur_EigenschaftPanel eigenschaftAP = new AddKultur_EigenschaftPanel(kultur,(kultur.getId()==null?(new HashSet<Kultur_Eigenschaft_Mod>()):DbManager.getCurrentDbManager().getEigenschaftOfKultur(kultur)));
		JScrollPane eigenschaftScrollPane = new JScrollPane(eigenschaftAP);
		eigenschaftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		eigenschaftScrollPane.setPreferredSize(new Dimension(300,100));

		JLabel vorteilLabel = new JLabel("Vorteile");
		vorteilLabel.setAlignmentY(0);
		AddKultur_VorteilPanel vorteilAP = new AddKultur_VorteilPanel(kultur,(kultur.getId()==null?(new HashSet<Kultur_Vorteil>()):DbManager.getCurrentDbManager().getVorteilOfKultur(kultur)));
		JScrollPane vorteilScrollPane = new JScrollPane(vorteilAP);
		vorteilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vorteilScrollPane.setPreferredSize(new Dimension(300,100));
		
		JLabel nachteilLabel = new JLabel("Nachteile");
		nachteilLabel.setAlignmentY(0);
		AddKultur_NachteilPanel nachteilAP = new AddKultur_NachteilPanel(kultur,(kultur.getId()==null?(new HashSet<Kultur_Nachteil>()):DbManager.getCurrentDbManager().getNachteilOfKultur(kultur)));
		JScrollPane nachteilScrollPane = new JScrollPane(nachteilAP);
		nachteilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		nachteilScrollPane.setPreferredSize(new Dimension(300,100));

		JLabel talentLabel = new JLabel("Talente");
		talentLabel.setAlignmentY(0);
		AddKultur_TalentPanel talentAP = new AddKultur_TalentPanel(kultur,(kultur.getId()==null?(new HashSet<Kultur_Talent_Mod>()):DbManager.getCurrentDbManager().getTalentOfKultur(kultur)));
		JScrollPane talentScrollPane = new JScrollPane(talentAP);
		talentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		talentScrollPane.setPreferredSize(new Dimension(300,100));
		
		
		JButton saveButton = new JButton("Speichern");
		saveButton.setActionCommand("edit");
		if (kultur.getId() == null){
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
						kultur.setName(nameTF.getText());
						kultur.setGenerierungskosten((Integer)gemodSP.getValue());
						kultur.setKoerpergroesse_regel(groesseTF.getText());
						kultur.setGewicht_regel(gewichtTF.getText());
						kultur.setLebenspunkte_modifikator((Integer)lemodSP.getValue());
						kultur.setAusdauer_modifikator((Integer)aumodSP.getValue());
						kultur.setMagieresistenz_modifikator((Integer)mrmodSP.getValue());
						kultur.setHerkunft_verbreitung(herkunftTF.getText());
						kultur.setKoerperbau_aussehen(aussehenTF.getText());
						kultur.setBeschreibung(beschreibungTF.getText());
						kultur.setEigenschafts_modifikatoren(eigenschaftAP.getKultur_Eigenschaft_Mods());
						kultur.setKultur_vorteile(vorteilAP.getKultur_Vorteile());
						kultur.setKultur_nachteile(nachteilAP.getKultur_Nachteile());
						kultur.setKultur_talente(talentAP.getKultur_Talent_Mods());
						DbManager.getCurrentDbManager().createNewObject(kultur);
						dispose();
						((AbstractTableModel)kulturTable.getModel()).fireTableDataChanged();
						break;
					case "edit":
						kultur.setName(nameTF.getText());
						kultur.setGenerierungskosten((Integer)gemodSP.getValue());
						kultur.setKoerpergroesse_regel(groesseTF.getText());
						kultur.setGewicht_regel(gewichtTF.getText());
						kultur.setLebenspunkte_modifikator((Integer)lemodSP.getValue());
						kultur.setAusdauer_modifikator((Integer)aumodSP.getValue());
						kultur.setMagieresistenz_modifikator((Integer)mrmodSP.getValue());
						kultur.setHerkunft_verbreitung(herkunftTF.getText());
						kultur.setKoerperbau_aussehen(aussehenTF.getText());
						kultur.setBeschreibung(beschreibungTF.getText());
						kultur.setEigenschafts_modifikatoren(eigenschaftAP.getKultur_Eigenschaft_Mods());
						kultur.setKultur_vorteile(vorteilAP.getKultur_Vorteile());
						kultur.setKultur_nachteile(nachteilAP.getKultur_Nachteile());
						kultur.setKultur_talente(talentAP.getKultur_Talent_Mods());
						DbManager.getCurrentDbManager().mergeObject(kultur);
						dispose();
						((AbstractTableModel)kulturTable.getModel()).fireTableDataChanged();
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
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(herkunftLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(herkunftScrollPane,cons);
		
		cons.gridy = 12;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(aussehenLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 1;
		getContentPane().add(aussehenScrollPane,cons);
		
		cons.gridy = 16;		
		cons.gridx = 0;
		cons.weightx = 0;
		cons.gridheight = 4;
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
		
		cons.gridy = 8;
		cons.gridx = 3;
		cons.weightx = 0;
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(nachteilLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 4;
		getContentPane().add(nachteilScrollPane,cons);

		cons.gridy = 12;
		cons.gridx = 3;
		cons.weightx = 0;
		cons.gridheight = 4;
		cons.gridwidth = 1;
		getContentPane().add(talentLabel,cons);
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.gridx = 4;
		getContentPane().add(talentScrollPane,cons);
		
		cons.gridheight = 1;
		cons.gridy = 17;
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
