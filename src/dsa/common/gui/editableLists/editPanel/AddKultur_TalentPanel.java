package dsa.common.gui.editableLists.editPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		talentItems.add(new NameIdWrapper(-1, "remove Talent"));
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					talent_mods.add(new Kultur_TalentGruppe_Mod(kultur));
				}
				else if(e.getActionCommand().startsWith("del")){
					talent_mods.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				else if(e.getActionCommand().startsWith("or")){
					talent_mods.get(new Integer(e.getActionCommand().split("_")[1]).intValue()).getTalentAlternativen().add(new Talent(0));
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
		while(iter.hasNext()){
			Kultur_TalentGruppe_Mod curEM = iter.next();
			
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new FlowLayout());
			int jj = 0;
			//iterate over Talents in Group
			Iterator<Talent> talentIter = curEM.getTalentAlternativen().iterator();
			while(talentIter.hasNext()){
				Talent t = talentIter.next();

				NameIdComboBox eSF = new NameIdComboBox(talentItems,jj);
				eSF.setSelectedIndex(t.getId()!=null?t.getId().intValue()-1:0);
				AutoCompleteDecorator.decorate(eSF);
				eSF.setPreferredSize(new Dimension(75,25));

				eSF.addItemListener(new ItemListener() {
					int posA = ii;
					@SuppressWarnings("unchecked")
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED){
							if(((NameIdWrapper)e.getItem()).getId().longValue()==new Long(-1).longValue()){
								((LinkedList<Talent>)talent_mods.get(posA).getTalentAlternativen()).remove(eSF.getIndex());
								reCreate();
							} else
								((LinkedList<Talent>)talent_mods.get(posA).getTalentAlternativen()).set(eSF.getIndex(),new Talent((long) ((NameIdWrapper)e.getItem()).getId()));
						}
					}
				});
				groupPanel.add(eSF);
				jj++;
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
			

			JButton orButton = new JButton("|");
			orButton.setActionCommand("or_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			c.gridwidth = jj>=5?5:jj;
			JScrollPane scrollGroupPanel = new JScrollPane(groupPanel);
			add(scrollGroupPanel,c);
			c.gridx = 1;
			add(orButton,c);
			c.gridx = 2;
			add(modValue,c);
			c.gridx = 3;
			add(delButton,c);
			orButton.addActionListener(buttonListener);
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
			Set<Talent> talentAlternativen = new HashSet<Talent>();
			Iterator<Talent> tIter = curEM.getTalentAlternativen().iterator();
			while(tIter.hasNext()){
				Talent curT = tIter.next();
				talentAlternativen.add(DbManager.getCurrentDbManager().loadInstanceById(curT, curT.getId()));
			}
			curEM.setTalentAlternativen(talentAlternativen);
			curEM.setModifikator(new Integer(curEM.getModifikator()));
			try {
				retval.add(curEM);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
