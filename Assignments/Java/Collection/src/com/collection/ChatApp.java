package com.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChatApp {

	private static Map<String, ChatRoom> chatRooms = new HashMap<>();
	private static String currentRoom;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String chatRoomName, username, password, message;
		Scanner scanner = new Scanner(System.in);
		while (true) {
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
				createChatRoom(chatRoomName);
				break;
			case 2:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("Enter username: ");
				username = scanner.next();
				System.out.print("Enter password: ");
				password = scanner.next();
				addUser(chatRoomName, username, password);
				break;
			case 3:
				System.err.print("\nLOGIN");
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("Enter username: ");
				username = scanner.next();
				System.out.print("Enter password: ");
				password = scanner.next();
				User currentUser = loginUser(chatRoomName, username, password);
				if (currentUser != null) {
					currentRoom = chatRoomName;
					System.out.println("Welcome " + username + " to chat room " + currentRoom);
				} else {
					System.out.println("Incorrect username or password or chatroom");
				}
				break;
			case 4:
				System.out.print("Enter message: ");
				message = scanner.next();
				sendMessage(message);
				System.err.print("\nMessage Sent!");
				break;
			case 5:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.err.print("All messages from chat room " + chatRoomName);
				System.out.println();
				List<String> messages = getChatRoom(chatRoomName).getMessages();
				for (String msg : messages) {
					System.out.println("- " + msg);
				}
				break;
			case 6:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.err.print("All the users from chat room " + chatRoomName);
				System.out.println();
				List<User> users = getChatRoom(chatRoomName).getUsers();
				for (User user : users) {
					System.out.println("- " + user);
				}
				break;
			case 7:
				logoutUser();
				System.err.print("\nLOGGED OUT");
				break;
			case 8:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				System.out.print("Enter username: ");
				username = scanner.next();
				removeUser(chatRoomName, username);
				System.out.print("\nDeleted user " + username + " from chat room " + chatRoomName);
				break;
			case 9:
				System.out.print("Enter chat room name: ");
				chatRoomName = scanner.next();
				removeChatRoom(chatRoomName);
				break;
			default:
				break;
			}
		}
	}

	private static void sendMessage(String message) {
		if (currentRoom == null) {
			System.out.println("Please login before sending message");
			return;
		}
		ChatRoom currentChatRoom = getChatRoom(currentRoom);
		currentChatRoom.sendMessage(message);
	}

	private static void createChatRoom(String chatRoomName) {
		ChatRoom chatRoom = new ChatRoom(chatRoomName);
		chatRooms.put(chatRoomName, chatRoom);
	}

	private static void addUser(String chatRoomName, String user, String password) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			currentChatRoom.addUser(new User(user, password));
			System.out.println("Added user " + user);
		} else {
			System.err.println("Incorrect chat room");
		}

	}

	private static User loginUser(String chatRoomName, String user, String password) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		return currentChatRoom.login(new User(user, password));
	}

	private static void removeUser(String chatRoomName, String user) {
		getChatRoom(chatRoomName).remove(new User(user));
	}

	private static void removeChatRoom(String chatRoomName) {
		chatRooms.remove(chatRoomName);
	}

	private static void logoutUser() {
		getChatRoom(currentRoom).logout();
		currentRoom = null;
	}

	private static ChatRoom getChatRoom(String chatRoomName) {
		return chatRooms.get(chatRoomName);
	}

}
