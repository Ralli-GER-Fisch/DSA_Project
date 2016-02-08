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

import dsa.common.data.Talent;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.Rasse_Talent_Mod;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddRasse_TalentPanel extends JPanel {
	List<Rasse_Talent_Mod> talent_mods = new ArrayList<Rasse_Talent_Mod>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> talentItems;
	ActionListener buttonListener;
	Rasse rasse;
	public AddRasse_TalentPanel(Rasse r,Set<Rasse_Talent_Mod> talent_modsI) {
		this.rasse = r;
		if(!talent_modsI.isEmpty())
			this.talent_mods.addAll(talent_modsI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		talentItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Talent.class);
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					talent_mods.add(new Rasse_Talent_Mod(rasse));
				}
				else if(e.getActionCommand().startsWith("del")){
					talent_mods.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Rasse_Talent_Mod> iter = talent_mods.iterator();
		ii = 0;
		while(iter.hasNext()){
			Rasse_Talent_Mod curEM = iter.next();
			
			NameIdComboBox eSF = new NameIdComboBox(talentItems);
			eSF.setSelectedIndex(curEM.getTalent().getId()!=null?curEM.getTalent().getId().intValue()-1:0);
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
						talent_mods.get(pos).setTalent(new Talent((long) ((NameIdWrapper)e.getItem()).getId()));
				}
			});
			modValue.addChangeListener(new ChangeListener() {
				int pos = ii;
				@Override
				public void stateChanged(ChangeEvent e) {
					talent_mods.get(pos).setModifikator((Integer) modValue.getValue());
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

	public Set<Rasse_Talent_Mod> getRasse_Talent_Mods() {
		Set<Rasse_Talent_Mod> retval = new HashSet<Rasse_Talent_Mod>();
		Iterator<Rasse_Talent_Mod> iter = talent_mods.iterator();
		while(iter.hasNext()){
			Rasse_Talent_Mod curEM = iter.next();
			curEM.setTalent(DbManager.getCurrentDbManager().loadInstanceById(curEM.getTalent(), curEM.getTalent().getId()));
			curEM.setModifikator(new Integer(curEM.getModifikator()));
			try {
				retval.add(curEM);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
