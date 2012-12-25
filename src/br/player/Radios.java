package br.player;

import java.util.HashMap;

import android.util.Log;

public class Radios {
	private static HashMap<String,String> map = new HashMap<String, String>();
	
	private static void setRadioNames(){
		for(RadioEnum value : RadioEnum.values()){
			map.put(value.getName(),value.getUrl() );
			Log.i("V - R Name",value.getName() );
			Log.i("V - URL",value.getUrl());
		}
	}
	
	public static String getRadio(String radioName){
		setRadioNames();
		return map.get(radioName);
	}

}
