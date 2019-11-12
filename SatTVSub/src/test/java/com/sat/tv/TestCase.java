package com.sat.tv;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sat.tv.model.User;

public class TestCase {
	private static User user = new User();
	
	@Test
	//View Balance - option 1
	public void option1() {
		SatTVD2H.displayMenus();
		System.out.println("Enter the option: 1");
		assertTrue(user.getBalance().equals(100D));
	}
	
	@Test
	//Check able to recharge or not - option2
	public void option2() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 2");
		SatTVD2H.rechargeAccount(user, 205D);
		assertTrue(user.getBalance().equals(305D));
	}
	
	@Test
	//View all subscription - option 3
	public void option3() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 3");
		SatTVD2H.viewAllSubscriptions(user);
	}
	
	@Test
	//Purchase silver pack - option 4
	public void option4() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 4");
		SatTVD2H.subscribeToChannel(user, "S", 3);
		assertTrue(user.getSubscritionPacksAndChannels().equals("Silver"));
		assertTrue(user.getBalance().equals(170D));
	}
	
	@Test
	//Purchase channels - option 5
	public void option5() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 5");
		SatTVD2H.addChannelsToExistingSub(user, "Discovery, NatGeo");
		assertTrue(user.getSubscritionPacksAndChannels().equals("Silver + Discovery + NatGeo"));
		assertTrue(user.getBalance().equals(140D));
	}
	
	@Test
	//Purchse Services - option 6
	public void option6() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 6");
		SatTVD2H.subscribeToSpecialServices(user, "Cook");
		assertTrue(user.getSubscritionServices().equals("LearnCooking"));
		assertTrue(user.getBalance().equals(40D));
	}
	
	@Test
	//View purchased subscription - option 7
	public void option7() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 7");
		User user = new User();
		SatTVD2H.viewCurrentSubscriptions(user);
	}
	
	@Test
	//Set new email and phone - option 8
	public void option8() {
		System.out.println("====================================================");
		System.out.println("Enter the option: 8");
		User user = new User();
		SatTVD2H.updateEmailAndPhone(user, "test@email.com", "9876543210");
		assertTrue(user.getEmail().equals("test@email.com"));
		assertTrue(user.getPhone().equals("9876543210"));
	}
	
}
