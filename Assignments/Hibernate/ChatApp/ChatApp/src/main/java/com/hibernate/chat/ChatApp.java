package com.hibernate.chat;

import java.util.Scanner;

import com.hibernate.chat.persist.Persistance;
import com.hibernate.chat.persist.PersistanceFactory;
import com.hibernate.chat.persist.PersistanceType;

public class ChatApp {

	private static User currentUser = null;

	public static void main(String[] args) {
		String chatRoomName, username, password, message;
		Scanner scanner = new Scanner(System.in);
		Persistance persistance = PersistanceFactory.getInstance().getPersistance(PersistanceType.HIBERNATE);
		outer: while (true) {
			StringBuilder builder = new StringBuilder();
			builder.append("\n1. Create a chatroom");
			builder.append("\n2. Add the user");
			builder.append("\n3. User login");
			builder.append("\n4. Send a message");
			builder.append("\n5. Display the messages from a specific chatroom");
			builder.append("\n6. List down all users belonging to the specified chat room.");
			builder.append("\n7. Logout");
			builder.append("\n8. Delete an user");
			builder.append("\n9. Delete the chat room.");
			builder.append("\nPlease enter your option: ");
			System.out.print(builder);
			int choice = scanner.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				persistance.createChatRoom(chatRoomName);
				break;
			case 2:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("Enter username: ");
				username = scanner.next();
				System.out.print("Enter password: ");
				password = scanner.next();
				boolean createUser = persistance.createUser(chatRoomName, username, password);
				System.out.println("User created = " + createUser);
				break;
			case 3:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("Enter username: ");
				username = scanner.next();
				System.out.print("Enter password: ");
				password = scanner.next();
				currentUser = persistance.login(chatRoomName, username, password);
				if (currentUser != null) {
					System.out.println("Welcome " + currentUser.getName() + " to chat room "
							+ currentUser.getChatRoom().getChatRoomName());
				} else {
					System.out.println("Incorrect username or password or chatroom");
				}
				break;
			case 4:
				if (currentUser != null) {
					System.out.print("Enter message: ");
					message = scanner.next();
					persistance.sendMessage(currentUser.getChatRoom().getChatRoomName(), message);
					System.out.print("\nMessage Sent!");
				} else {
					System.out.println("You need to login before sending message");
				}
				break;
			case 5:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.err.print("All messages from chat room " + chatRoomName);
				System.out.println();
				persistance.showAllMessages(chatRoomName);
				break;
			case 6:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("All the users from chat room " + chatRoomName);
				System.out.println();
				persistance.showAllUsers(chatRoomName);
				break;
			case 7:
				if (currentUser != null) {
					currentUser = null;
					System.out.print("\nLOGGED OUT");
				} else {
					System.out.println("You need to login before sending message");
				}
				break;
			case 8:
				System.out.print("Enter username: ");
				username = scanner.next();
				boolean deleteUser = persistance.deleteUser(username);
				System.out.print("\nDeleted user " + username + " = " + deleteUser);
				break;
			case 9:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				boolean deleteChatRoom = persistance.deleteChatRoom(chatRoomName);
				System.out.print("\nDeleted chatroom " + chatRoomName + " = " + deleteChatRoom);
				break;
			default:
				break outer;
			}
		}
		System.out.println("Exiting the chat app..");
		scanner.close();
		persistance.close();
	}

}
