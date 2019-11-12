package com.sat.tv.model;
import java.util.ArrayList;
import java.util.List;

import com.sat.tv.enums.Channels;
import com.sat.tv.enums.Packs;
import com.sat.tv.enums.Services;

/**
 * 
 * @author Akhil.Singla
 *
 */
public class Subscription {

	private List<Channels> channels = new ArrayList<>();
	
	private List<Packs> packs = new ArrayList<>();
	
	private List<Services> services = new ArrayList<>();

	public List<Channels> getChannels() {
		return channels;
	}

	public void setChannels(List<Channels> channels) {
		this.channels = channels;
	}

	public List<Packs> getPacks() {
		return packs;
	}

	public void setPacks(List<Packs> packs) {
		this.packs = packs;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public void addChannel(Channels channel) {
		this.channels.add(channel);
	}

	public void addPack(Packs pack) {
		this.packs.add(pack);
	}

	public void addServices(Services service) {
		this.services.add(service);
	}
	
}
