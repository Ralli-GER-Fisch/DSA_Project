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
import dsa.common.data.Kultur;
import dsa.common.data.mappings.Kultur_TalentGruppe_Mod;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddKultur_TalentPanel extends JPanel {
	List<Kultur_TalentGruppe_Mod> talent_mods = new ArrayList<Kultur_TalentGruppe_Mod>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> talentItems;
	ActionListener buttonListener;
	Kultur kultur;
	public AddKultur_TalentPanel(Kultur k,Set<Kultur_TalentGruppe_Mod> talent_modsI) {
		this.kultur = k;
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
					talent_mods.add(new Kultur_TalentGruppe_Mod(kultur));
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
		Iterator<Kultur_TalentGruppe_Mod> iter = talent_mods.iterator();
		ii = 0;
		int maxIndex = 0;
		while(iter.hasNext()){
			Kultur_TalentGruppe_Mod curEM = iter.next();
			
			JPanel groupPanel = new JPanel();
			int j = 0;
			//iterate over Talents in Group
			Iterator<Talent> talentIter = curEM.getTalentAlternativen().iterator();
			while(talentIter.hasNext()){
				Talent t = talentIter.next();

				NameIdComboBox eSF = new NameIdComboBox(talentItems);
				eSF.setSelectedIndex(t.getId()!=null?t.getId().intValue()-1:0);
				AutoCompleteDecorator.decorate(eSF);
				eSF.setPreferredSize(new Dimension(75,25));

				eSF.addItemListener(new ItemListener() {
					int pos = ii;
					int posB = jj;
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED)
							//iterate to index posB, then change index
							talent_mods.get(pos).getTalentAlternativen().setTalent(new Talent((long) ((NameIdWrapper)e.getItem()).getId()));
					}
				});
				j++;
			}
			
			JSpinner modValue = new JSpinner();
			modValue.setValue(curEM.getModifikator()!=null?curEM.getModifikator().intValue():0);
			modValue.setPreferredSize(new Dimension(50, 25));
			

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

	public Set<Kultur_TalentGruppe_Mod> getKultur_TalentGruppe_Mods() {
		Set<Kultur_TalentGruppe_Mod> retval = new HashSet<Kultur_TalentGruppe_Mod>();
		Iterator<Kultur_TalentGruppe_Mod> iter = talent_mods.iterator();
		while(iter.hasNext()){
			Kultur_TalentGruppe_Mod curEM = iter.next();
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
