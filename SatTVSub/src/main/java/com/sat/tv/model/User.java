package com.sat.tv.model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sat.tv.enums.Channels;
import com.sat.tv.enums.Packs;
import com.sat.tv.enums.Services;

/**
 * 
 * @author Akhil.Singla
 *
 */
public class User {
	
	private Double balance = 100D;
	private String email = "akhilsingla52@gmail.com";
	private String phone = "7206299952";
	private Subscription subscription = new Subscription();

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public void addBalance(Double amount) {
		this.balance += amount; 
	}
	
	public void setRemainingBalance(Double amount) {
		this.balance -= amount;
	}

	public void addChannel(Channels channel) {
		this.subscription.addChannel(channel);
	}

	public void addPack(Packs pack) {
		this.subscription.addPack(pack);
	}

	public void addServices(Services service) {
		this.subscription.addServices(service);
	}

	public String getSubscritionPacksAndChannels() {
		List<String> subs = new ArrayList<>();

		this.subscription.getPacks().forEach(p -> subs.add(p.getName()));
		this.subscription.getChannels().forEach(c -> subs.add(c.getName()));
		
		if(subs.isEmpty()) {
			return "";
		} else {
			return subs.stream().collect(Collectors.joining(" + "));
		}
	}

	public String getSubscritionServices() {
		List<String> servicesList = this.subscription.getServices().stream().map(s -> s.getName()).collect(Collectors.toList());
		
		if(servicesList!=null && !servicesList.isEmpty()) {
			return servicesList.stream().collect(Collectors.joining(" + "));
		} else {
			return "";
		}
	}

}
