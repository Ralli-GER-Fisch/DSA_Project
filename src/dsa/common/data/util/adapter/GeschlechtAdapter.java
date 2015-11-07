package dsa.common.data.util.adapter;

import java.text.ParseException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import dsa.common.data.util.enums.Geschlecht;

public class GeschlechtAdapter extends XmlAdapter<String, Geschlecht>{

	public Geschlecht unmarshal(String geschlecht) throws ParseException {
		if(geschlecht == "maennlich"){
			return Geschlecht.MAENNLICH;
		}
		else if(geschlecht == "weiblich"){
			return Geschlecht.WEIBLICH;
		}
		else{
			throw new ParseException("Error while trying to convert "+geschlecht+" to Enum Geschlecht",19);
		}
	}
	
	
	public String marshal(Geschlecht geschlecht) throws ParseException {
		if(geschlecht == Geschlecht.MAENNLICH){
			return "maennlich";
		}
		else if(geschlecht == Geschlecht.WEIBLICH){
			return "weiblich";
		}
		else{
			throw new ParseException("Error while trying to convert Enum "+geschlecht+" to String",32);
		}
	}

}
