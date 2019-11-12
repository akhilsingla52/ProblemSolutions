package com.sat.tv.enums;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Akhil.Singla
 *
 */
public enum Packs {
	
	SILVERPACK("Silver", 50D, Channels.ZEE, Channels.SONY, Channels.STAR_PLUS),
	GOLDPACK("Gold", 100D, Channels.ZEE, Channels.SONY, Channels.STAR_PLUS, Channels.DISCOVERY, Channels.NATGEO);

	private String name;
	private Double price;
	private List<Channels> channels;
	
	Packs(String name, Double price, Channels... channels) {
		this.name = name;
		this.price = price;
		this.channels = Arrays.asList(channels);
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public List<Channels> getChannels() {
		return channels;
	}

	public static Packs findPackByName(String name) {
		Packs findPack = null;
		for(Packs pack : Packs.values()) {
			if(pack.getName().toLowerCase().contains(name.toLowerCase())) {
				findPack = pack;
				break;
			}
		}
		return findPack;
	}
}
