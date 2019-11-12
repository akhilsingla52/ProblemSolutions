package com.sat.tv;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sat.tv.enums.Channels;
import com.sat.tv.enums.Packs;
import com.sat.tv.enums.Services;
import com.sat.tv.model.User;

/**
 * 
 * @author Akhil.Singla
 *
 */
public class SatTVD2H {
	
	/**
	 * Menu for user interaction.
	 */
	public final static void displayMenus() {
		List<String> displayMenus = Arrays.asList("====================================================", 
								"*** Welcome to SatTV ***", 
								"1. View current balance in the account", 
								"2. Recharge Account ", 
								"3. View available packs, channels and services ", 
								"4. Subscribe to base packs", 
								"5. Add channels to an existing subscription", 
								"6. Subscribe to special services", 
								"7. View current subscription details", 
								"8. Update exmail and phone number for notifications ", 
								"9. Exit ", 
								"====================================================");
		displayMenus.stream().forEach(System.out::println);
	}

	/**
	 * Main Method.
	 */
	public static void main(String... args) {
		User user  =  new User();
		try(Scanner scanner = new Scanner(System.in)) {
			Integer num = null;
			do {
				displayMenus();
				System.out.print("Enter the option: ");
				num = scanner.nextInt();
				switch(num) {
				case 1:
					viewCurrentBalance(user);
					break;
				case 2:
					System.out.print("Enter the amount to recharge: ");
					double amount = scanner.nextDouble();
					rechargeAccount(user,amount);
					break;
				case 3:
					viewAllSubscriptions(user);
					break;
				case 4:
					System.out.println("Subscribe to channel packs");
					System.out.print("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’): ");
					scanner.nextLine();
					String pack = scanner.nextLine();
					System.out.print("Enter the months: ");
					Integer month = scanner.nextInt();
					scanner.nextLine();
					subscribeToChannel(user,pack,month);
					break;
				case 5:
					System.out.print("Enter channel names to add (separated by commas): ");
					scanner.nextLine();
					String channels = scanner.nextLine();
					addChannelsToExistingSub(user,channels);
					break;
				case 6:
					System.out.print("Enter the service name: ");
					scanner.nextLine();
					String service = scanner.nextLine();
					subscribeToSpecialServices(user,service);
					break;
				case 7:
					viewCurrentSubscriptions(user);
					break;
				case 8:
					System.out.print("Enter the email: ");
					scanner.nextLine(); 
					String email = scanner.nextLine(); 
					System.out.print("Enter the Phone: "); 
					String phone = scanner.nextLine(); 
					updateEmailAndPhone(user,email,phone);
					break;
				case 9:
					System.out.println("Thank you :) ");
					break;
				default : System.out.println("Please enter valid choice");
				}
				System.out.println("\n\n");
			} while(num!=9);
		}
	}

	/**
	 * view user balance. Option 1
	 * @param user
	 */
	public static void viewCurrentBalance(User user) {
		System.out.println("View current balance in the account \nCurrent balance is "+ user.getBalance().intValue() + " Rs.");
	}

	/**
	 * Recharge account. Option 2
	 * @param user
	 * @param amount
	 */
	public static void rechargeAccount(User user, Double amount) {
		user.addBalance(amount);
		System.out.println("Recharge completed suceesfully. Current balance is " + user.getBalance().intValue());
	}

	/**
	 * view all available subscriptions. Option 3
	 * @param user
	 */
	public static void viewAllSubscriptions(User user){
		System.out.println("View available packs, channels and services");
		System.out.println("Available packs for subscription");
		List<Packs> packs = Arrays.asList(Packs.values());
		packs.stream().forEach(p -> {
			System.out.println(p.getName() + " Pack: " 
									+ p.getChannels().stream().map(c -> c.getName()).collect(Collectors.joining(", "))
									+ ": " + p.getPrice().intValue() + "Rs.");
		});
		System.out.println("Available channels for subscription");
		List<Channels> channels = Arrays.asList(Channels.values());
		channels.stream().forEach(c -> {
			System.out.println(c.getName() + ": " + c.getPrice().intValue() + "Rs.");
		});
		System.out.println("Available services for subscription");
		List<Services> services = Arrays.asList(Services.values());
		services.stream().forEach(s -> {
			System.out.println(s.getName() + " Service: " + s.getPrice().intValue() + "Rs.");
		});
	}

	/**
	 * To subscribe user. Option 4
	 * @param user
	 * @param pack
	 * @param month
	 */
	public static void subscribeToChannel(User user, String pack, Integer month) {
		Packs selectedPack = Packs.findPackByName(pack);
		
		if(selectedPack==null) {
			System.out.println("Subscription Pack not found");
		} if(user.getSubscription().getPacks().contains(selectedPack)) {
			System.out.println(selectedPack.getName() + " Pack already subscribed.");
		} else {
			Double subscriptionAmount = selectedPack.getPrice() * month;
			Double disocuntedPrice = 0D;
			if(month >= 3) {
				disocuntedPrice = subscriptionAmount * 0.1;
				subscriptionAmount = subscriptionAmount - disocuntedPrice;
			}
			
			if(subscriptionAmount>user.getBalance()) {
				System.out.println("Account balance less than request");
			} else {
				System.out.println("You have successfully subscribed the following packs - " + selectedPack.getName());
				System.out.println("Monthly price: " + selectedPack.getPrice());
				user.addPack(selectedPack);
				System.out.println("No of months: " + month + "\n" +"Subscription Amount :"+ selectedPack.getPrice() * month);
				System.out.println("Discount applied: " + disocuntedPrice + "\n"+ "Final Price after discount: " + subscriptionAmount);
				user.setRemainingBalance(subscriptionAmount);
				System.out.println("Account balance: "+user.getBalance());
				System.out.println("Email notification sent successfully"+"\n"+"SMS notification sent successfully");
			}
		}
	}

	/**
	 * To add channels to existing subscriptions. Option 5
	 * @param user
	 * @param channles
	 */
	public static void addChannelsToExistingSub(User user, String channels) {
		List<Channels> channelsList = Channels.findChannelsByNames(channels);
		Double channelsPrice = channelsList.stream().mapToDouble(c -> c.getPrice()).sum();
		
		if(channelsList.isEmpty()) {
			System.out.println("Channel not found");
		} else if(user.getSubscription().getChannels().containsAll(channelsList)) {
			System.out.println("Channels already subscribed.");
		} else if(channelsPrice>user.getBalance()) {
			System.out.println("Account balance less than request");
		} else {
			for(Channels channel: channelsList) {
				user.addChannel(channel);
			}
			user.setRemainingBalance(channelsPrice);
			System.out.println("Channels added successfully."+"\n"+"Account balance: "+user.getBalance().intValue());
		}
	}

	/**
	 * To subscribe to special services. Option 6
	 * @param user
	 * @param service
	 */
	public static void subscribeToSpecialServices(User user, String service) {
		Services selectedService = null;
		if(Services.LEARN_COOKING.getName().toLowerCase().contains(service.toLowerCase())) {
			selectedService = Services.LEARN_COOKING;
		} else if(Services.LEARN_ENGLISH.getName().toLowerCase().contains(service.toLowerCase())) { 
			selectedService = Services.LEARN_ENGLISH;
		}
		
		if(selectedService==null) {
			System.out.println("Subscription Service not found");
		} if(user.getSubscription().getServices().contains(selectedService)) {
			System.out.println(selectedService.getName() + " Service already subscribed.");
		} else if(selectedService.getPrice()  > user.getBalance()) {
			System.out.println("Account balance less than request");
		} else {
			user.addServices(selectedService);
			user.setRemainingBalance(selectedService.getPrice());
			
			System.out.println("Service subscribed successfully ");
			System.out.println("Account balance:"+user.getBalance().intValue());
			System.out.println("Email notification sent successfully"+"\n"+"SMS notification sent successfully");
		}
	}
	
	/**
	 * To view subscriptions and services available for user. Option 7
	 * @param user
	 */
	public static void viewCurrentSubscriptions(User user) {
		System.out.println("Currently subscribed packs and channels: " + user.getSubscritionPacksAndChannels());
		System.out.println("Currently subscribed services: " + user.getSubscritionServices());
	}

	/**
	 * To Update email and Phone. Option 8
	 * @param user
	 * @param email
	 * @param phone
	 */
	public static void updateEmailAndPhone(User user, String email, String phone) {
		user.setEmail(email);
		user.setPhone(phone);
		System.out.println("Email and Phone updated successfully ");
	}

}
