package br.player;

public enum RadioEnum {
	FRANCE_INFO("France-Info[Paris]","http://mp3.live.tv-radio.com/franceinfo/all/franceinfo.mp3"), 
	ARL("ARL[Langon]","http://mp3.live.tv-radio.com/arl/all/arl.mp3"),
	PHARE_FM_LIVE("Phare FM Live[Mulhouse]","http://str30.creacast.com/pharefmlive"),
	CONTACT_FM("Contact FM [Lille]","http://radio-contact.ice.infomaniak.ch:80/radio-contact-high"),
	RADIO_CAMPUS_GRENOBLE("Radio Campus Grenoble [Grenoble]","http://live.campusgrenoble.org:9000/rcg112"),
	FRANCE_CULTURE("France Culture[Paris]","http://95.81.146.2/franceculture/all/franceculturehautdebit.mp3"),
	NOSTALGIE_60("Nostalgie 70's[Paris]","http://mp3.live.tv-radio.com/nostalgie_best_of_sixties/all/nos_174945.mp3"),
	NOSTALGIE_70("Nostalgie 70's[Paris]","http://mp3.live.tv-radio.com/nostalgie_best_of_seventies/all/nos_175440.mp3"),
	NOSTALGIE_80("Nostalgie 80's[Paris]","http://95.81.146.2/nostalgie_best_of_eighties/all/nos_172115.mp3"),
	MFM_FLASHBACK("MFM Flashback[Paris]","http://mfm-wr4.ice.infomaniak.ch/mfm-wr4-64"),
	JAZZ_RADIO_GOSPEL("Jazz Radio Jazz Gospel[Internet]","http://broadcast.infomaniak.net:80/jazz-wr07-128.mp3");

	private String url;
	private String name;

	private RadioEnum(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getName(){
		return name;
	}
}
