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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Talent;
import dsa.common.data.mappings.Probe;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddProbePanel extends JPanel {
	List<Probe> proben = new ArrayList<Probe>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> attributeItems;
	ActionListener buttonListener;
	Talent talent;
	public AddProbePanel(Talent t,Set<Probe> probenI) {
		this.talent = t;
		if(!probenI.isEmpty())
			this.proben.addAll(probenI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		attributeItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Eigenschaft.class);
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					proben.add(new Probe(talent));
				}
				else if(e.getActionCommand().startsWith("del")){
					proben.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Probe> iter = proben.iterator();
		ii = 0;
		while(iter.hasNext()){
			Probe curP = iter.next();
			//E1
			NameIdComboBox e1SF = new NameIdComboBox(attributeItems);
			e1SF.setSelectedIndex(curP.getEigenschaft1().getId()!=null?curP.getEigenschaft1().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(e1SF);
			e1SF.setPreferredSize(new Dimension(75,25));
			//E2
			NameIdComboBox e2SF = new NameIdComboBox(attributeItems);
			e2SF.setSelectedIndex(curP.getEigenschaft2().getId()!=null?curP.getEigenschaft2().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(e2SF);
			e2SF.setPreferredSize(new Dimension(75,25));
			//E3
			NameIdComboBox e3SF = new NameIdComboBox(attributeItems);
			e3SF.setSelectedIndex(curP.getEigenschaft3().getId()!=null?curP.getEigenschaft3().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(e3SF);
			e3SF.setPreferredSize(new Dimension(75,25));
			
			e1SF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						proben.get(pos).setEigenschaft1(new Eigenschaft(((NameIdWrapper)e.getItem()).getId()));
				}
			});
			e2SF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e1) {
					if(e1.getStateChange() == ItemEvent.SELECTED)
						proben.get(pos).setEigenschaft2(new Eigenschaft(((NameIdWrapper)e1.getItem()).getId()));
				}
			});
			e3SF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e2) {
					if(e2.getStateChange() == ItemEvent.SELECTED)
						proben.get(pos).setEigenschaft3(new Eigenschaft(((NameIdWrapper)e2.getItem()).getId()));
				}
			});
			
			JButton delButton = new JButton("-");
			delButton.setActionCommand("del_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			add(e1SF,c);
			c.gridx = 1;
			add(e2SF,c);
			c.gridx = 2;
			add(e3SF,c);
			c.gridx = 3;
			add(delButton,c);
			delButton.addActionListener(buttonListener);
			ii++;
		}
			JButton addButton = new JButton("+");
			addButton.setActionCommand("add");
			
			c.gridy = ii;
			c.gridx = 3;
			add(addButton,c);
			addButton.addActionListener(buttonListener);
			super.revalidate();
			super.repaint();
	}

	public Set<Probe> getProben() {
		Set<Probe> retval = new HashSet<Probe>();
		Iterator<Probe> iter = proben.iterator();
		while(iter.hasNext()){
			Probe curProbe = iter.next();
			curProbe.setEigenschaft1(DbManager.getCurrentDbManager().loadInstanceById(curProbe.getEigenschaft1(),curProbe.getEigenschaft1().getId()));
			curProbe.setEigenschaft2(DbManager.getCurrentDbManager().loadInstanceById(curProbe.getEigenschaft2(),curProbe.getEigenschaft2().getId()));
			curProbe.setEigenschaft3(DbManager.getCurrentDbManager().loadInstanceById(curProbe.getEigenschaft3(),curProbe.getEigenschaft3().getId()));
			curProbe.setTalent(DbManager.getCurrentDbManager().loadInstanceById(talent,talent.getId()));
			try {
				retval.add(curProbe);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
