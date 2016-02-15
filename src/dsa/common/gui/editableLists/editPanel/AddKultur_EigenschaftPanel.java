package dsa.common.gui.editableLists.editPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.Kultur_Eigenschaft_Mod;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddKultur_EigenschaftPanel extends JPanel {
	List<Kultur_Eigenschaft_Mod> eigenschaft_mods = new ArrayList<Kultur_Eigenschaft_Mod>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> attributeItems;
	ActionListener buttonListener;
	Kultur kultur;
	public AddKultur_EigenschaftPanel(Kultur k,Set<Kultur_Eigenschaft_Mod> eigenschaft_modsI) {
		this.kultur = k;
		if(!eigenschaft_modsI.isEmpty())
			this.eigenschaft_mods.addAll(eigenschaft_modsI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		attributeItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Eigenschaft.class);
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					eigenschaft_mods.add(new Kultur_Eigenschaft_Mod(kultur));
				}
				else if(e.getActionCommand().startsWith("del")){
					eigenschaft_mods.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Kultur_Eigenschaft_Mod> iter = eigenschaft_mods.iterator();
		ii = 0;
		while(iter.hasNext()){
			Kultur_Eigenschaft_Mod curEM = iter.next();
			
			NameIdComboBox eSF = new NameIdComboBox(attributeItems);
			eSF.setSelectedIndex(curEM.getEigenschaft().getId()!=null?curEM.getEigenschaft().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(eSF);
			eSF.setPreferredSize(new Dimension(75,25));
			
			JSpinner modValue = new JSpinner();
			modValue.setValue(curEM.getModifikator()!=null?curEM.getModifikator().intValue():0);
			modValue.setPreferredSize(new Dimension(50, 25));
			
			eSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						eigenschaft_mods.get(pos).setEigenschaft(new Eigenschaft((long) ((NameIdWrapper)e.getItem()).getId()));
				}
			});
			modValue.addChangeListener(new ChangeListener() {
				int pos = ii;
				@Override
				public void stateChanged(ChangeEvent e) {
					eigenschaft_mods.get(pos).setModifikator((Integer) modValue.getValue());
				}
			});
			
			JButton delButton = new JButton("-");
			delButton.setActionCommand("del_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			add(eSF,c);
			c.gridx = 1;
			add(modValue,c);
			c.gridx = 2;
			add(delButton,c);
			delButton.addActionListener(buttonListener);
			ii++;
		}
			JButton addButton = new JButton("+");
			addButton.setActionCommand("add");
			
			c.gridy = ii;
			c.gridx = 2;
			add(addButton,c);
			addButton.addActionListener(buttonListener);
			super.revalidate();
			super.repaint();
	}

	public Set<Kultur_Eigenschaft_Mod> getKultur_Eigenschaft_Mods() {
		Set<Kultur_Eigenschaft_Mod> retval = new HashSet<Kultur_Eigenschaft_Mod>();
		Iterator<Kultur_Eigenschaft_Mod> iter = eigenschaft_mods.iterator();
		while(iter.hasNext()){
			Kultur_Eigenschaft_Mod curEM = iter.next();
			curEM.setEigenschaft(DbManager.getCurrentDbManager().loadInstanceById(curEM.getEigenschaft(), curEM.getEigenschaft().getId()));
			curEM.setModifikator(new Integer(curEM.getModifikator()));
			try {
				retval.add(curEM);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
