package com.hibernate.chat.persist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.hibernate.chat.ChatRoom;
import com.hibernate.chat.Message;
import com.hibernate.chat.User;

public class InMemoryPersistance implements Persistance {

	private Map<String, ChatRoom> chatRooms = new HashMap<>();
	private ChatRoom currentChatRoom;

	@Override
	public void createChatRoom(String chatRoomName) {
		ChatRoom chatRoom = new ChatRoom(chatRoomName);
		chatRooms.put(chatRoomName, chatRoom);
	}

	@Override
	public boolean createUser(String chatRoomName, String username, String password) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			currentChatRoom.getUsers().add(new User(currentChatRoom, username, password));
			return true;
		}
		return false;
	}

	@Override
	public User login(String chatRoomName, String username, String password) {
		currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			Optional<User> optUser = currentChatRoom.getUsers().stream().findFirst()
					.filter(user -> user.getName().equals(username) && user.getPassword().equals(password));
			if (optUser.isPresent()) {
				return optUser.get();
			}
		}
		return null;
	}

	@Override
	public void sendMessage(String chatRoomName, String message) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			currentChatRoom.getMessages().add(new Message(message, currentChatRoom));
		}
	}

	@Override
	public void showAllMessages(String chatRoomName) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			currentChatRoom.getMessages().forEach(System.out::println);
		}
	}

	@Override
	public void showAllUsers(String chatRoomName) {
		ChatRoom currentChatRoom = getChatRoom(chatRoomName);
		if (currentChatRoom != null) {
			currentChatRoom.getUsers().forEach(System.out::println);
		}
	}

	@Override
	public boolean deleteChatRoom(String chatRoomName) {
		return chatRooms.remove(chatRoomName) != null;
	}

	@Override
	public boolean deleteUser(String username) {
		if (currentChatRoom != null) {
			boolean removed = currentChatRoom.getUsers().removeIf(user -> user.getName().equals(username));
			chatRooms.put(currentChatRoom.getChatRoomName(), currentChatRoom);
			return removed;
		}
		Optional<ChatRoom> chatRoom = chatRooms.values().stream()
				.findAny()
				.filter(chatroom -> 
							chatroom.getUsers().stream().anyMatch(user -> user.getName().equals(username)));
		if (chatRoom.isPresent()) {
			ChatRoom room = chatRoom.get();
			room.getUsers().removeIf(user -> user.getName().equals(username));
			chatRooms.put(room.getChatRoomName(), room);
			return true;
		}
		return false;
	}

	@Override
	public void close() {
		currentChatRoom = null;
		chatRooms.clear();
	}

	private ChatRoom getChatRoom(String chatRoomName) {
		return chatRooms.get(chatRoomName);
	}

}
