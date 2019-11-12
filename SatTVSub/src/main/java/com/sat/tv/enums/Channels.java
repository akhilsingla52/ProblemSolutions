package com.sat.tv.enums;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Akhil.Singla
 *
 */
public enum Channels {

	ZEE("Zee", 10D),
	SONY("Sony", 15D),
	STAR_PLUS("Star Plus", 20D),
	DISCOVERY("Discovery", 10D),
	NATGEO("NatGeo", 20D);

	private String name;
	private Double price;

	Channels(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	
	public static Channels findChannelByName(String name) {
		Channels findChannel = null;
		for(Channels channel : Channels.values()) {
			if(channel.getName().equalsIgnoreCase(name)) {
				findChannel = channel;
				break;
			}
		}
		return findChannel;
	}
	
	public static List<Channels> findChannelsByNames(String names) {
		List<String> nameList = Stream.of(names.split(",", -1)).map(name -> name.trim().toLowerCase()).collect(Collectors.toList());
		List<Channels> channels = new ArrayList<>();
		for(Channels channel : Channels.values()) {
			if(nameList.contains(channel.getName().toLowerCase())) {
				channels.add(channel);
			}
		}
		return channels;
	}

}
