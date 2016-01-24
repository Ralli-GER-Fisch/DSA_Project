package dsa.common.data.wrapper;
import static dsa.common.data.Talent.GRUPPE_BASIS;
import static dsa.common.data.Talent.GRUPPE_BASIS_STR;
import static dsa.common.data.Talent.GRUPPE_BERUF;
import static dsa.common.data.Talent.GRUPPE_BERUF_STR;
import static dsa.common.data.Talent.GRUPPE_SPEZIAL;
import static dsa.common.data.Talent.GRUPPE_SPEZIAL_STR;
import static dsa.common.data.Talent.TYP_GABE;
import static dsa.common.data.Talent.TYP_GABE_STR;
import static dsa.common.data.Talent.TYP_GESELLSCHAFTLICH;
import static dsa.common.data.Talent.TYP_GESELLSCHAFTLICH_STR;
import static dsa.common.data.Talent.TYP_HANDWERK;
import static dsa.common.data.Talent.TYP_HANDWERK_STR;
import static dsa.common.data.Talent.TYP_KAMPF;
import static dsa.common.data.Talent.TYP_KAMPF_STR;
import static dsa.common.data.Talent.TYP_KOERPERLICH;
import static dsa.common.data.Talent.TYP_KOERPERLICH_STR;
import static dsa.common.data.Talent.TYP_NATUR;
import static dsa.common.data.Talent.TYP_NATUR_STR;
import static dsa.common.data.Talent.TYP_SCHRIFT;
import static dsa.common.data.Talent.TYP_SCHRIFT_STR;
import static dsa.common.data.Talent.TYP_SPRACHE;
import static dsa.common.data.Talent.TYP_SPRACHE_STR;
import static dsa.common.data.Talent.TYP_WISSEN;
import static dsa.common.data.Talent.TYP_WISSEN_STR;

import java.util.Arrays;
import java.util.List;

public class TalentItem extends NameIdWrapper{
	public final static TalentItem			TALENTITEM_KAMPF = new TalentItem(TYP_KAMPF, TYP_KAMPF_STR),
											TALENTITEM_KOERPERLICH = new TalentItem(TYP_KOERPERLICH, TYP_KOERPERLICH_STR),
											TALENTITEM_GESELLSCHAFTLICH = new TalentItem(TYP_GESELLSCHAFTLICH, TYP_GESELLSCHAFTLICH_STR),
											TALENTITEM_NATUR = new TalentItem(TYP_NATUR, TYP_NATUR_STR),
											TALENTITEM_WISSEN = new TalentItem(TYP_WISSEN, TYP_WISSEN_STR),
											TALENTITEM_HANDWERK = new TalentItem(TYP_HANDWERK, TYP_HANDWERK_STR),
											TALENTITEM_SPRACHE = new TalentItem(TYP_SPRACHE, TYP_SPRACHE_STR),
											TALENTITEM_SCHRIFT = new TalentItem(TYP_SCHRIFT, TYP_SCHRIFT_STR),
											TALENTITEM_GABE = new TalentItem(TYP_GABE, TYP_GABE_STR),
											TALENTITEM_BASIS = new TalentItem(GRUPPE_BASIS,GRUPPE_BASIS_STR),
											TALENTITEM_BERUF = new TalentItem(GRUPPE_BERUF, GRUPPE_BERUF_STR),
											TALENTITEM_SPEZIAL = new TalentItem(GRUPPE_SPEZIAL, GRUPPE_SPEZIAL_STR);
	private static final List<TalentItem>	typTalentItemList = Arrays.asList(TALENTITEM_KAMPF,TALENTITEM_KOERPERLICH,TALENTITEM_GESELLSCHAFTLICH,TALENTITEM_NATUR,TALENTITEM_WISSEN,TALENTITEM_HANDWERK,TALENTITEM_SPRACHE,TALENTITEM_SCHRIFT,TALENTITEM_GABE),
											gruppeTalentItemList = Arrays.asList(TALENTITEM_BASIS,TALENTITEM_BERUF,TALENTITEM_SPEZIAL);
						
	public TalentItem(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	@Override
	public boolean equals(Object comp) {
		if (comp instanceof TalentItem)
			return this.getId() == ((TalentItem) comp).getId();
		else
			return false;
	}

	public static List<TalentItem> getTypTalentItemList() {
		return typTalentItemList;
	}
	public static List<TalentItem> getGruppeTalentItemList() {
		return gruppeTalentItemList;
	}
}
