package com.hibernate.chat.persist;

import java.util.HashSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.chat.ChatRoom;
import com.hibernate.chat.Message;
import com.hibernate.chat.User;

public class HibernatePersistance implements Persistance {

	private SessionFactory sessionFactory;

	public HibernatePersistance() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public void createChatRoom(String chatRoomName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ChatRoom chatRoom = new ChatRoom(chatRoomName);
		session.save(chatRoom);
		transaction.commit();
		session.close();
	}

	@Override
	public boolean createUser(String chatRoomName, String username, String password) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(ChatRoom.class);
		criteria.add(Restrictions.eq("chatRoomName", chatRoomName));

		ChatRoom chatRoom = (ChatRoom) criteria.uniqueResult();
		if (chatRoom == null) {
			return false;
		}
		Transaction transaction = session.beginTransaction();
		HashSet<User> users = new HashSet<>();
		users.add(new User(chatRoom, username, password));

		chatRoom.setUsers(users);
		session.save(chatRoom);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public User login(String chatRoomName, String username, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("name", username));
		criteria.add(Restrictions.eq("password", password));

		User user = (User) criteria.uniqueResult();
		session.close();
		try {
			if (user != null && user.getChatRoom().getChatRoomName().equals(chatRoomName)) {
				return user;
			}
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}
	
	@Override
	public void sendMessage(String chatRoomName, String message) {
		System.out.println(chatRoomName);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		ChatRoom chatRoom = getChatRoom(chatRoomName);
		
		HashSet<Message> messages = new HashSet<>();
		Message msg = new Message(message, chatRoom);
		messages.add(msg);
		
		chatRoom.setMessages(messages);
		
		session.save(msg);
		transaction.commit();
		session.close();
	}

	@Override
	public void showAllMessages(String chatRoomName) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(ChatRoom.class);
		criteria.add(Restrictions.eq("chatRoomName", chatRoomName));

		ChatRoom chatRoom = (ChatRoom) criteria.uniqueResult();
		if (chatRoom != null) {
			chatRoom.getMessages().forEach(System.out::println);
		}
		session.close();
	}

	@Override
	public void showAllUsers(String chatRoomName) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(ChatRoom.class);
		criteria.add(Restrictions.eq("chatRoomName", chatRoomName));

		ChatRoom chatRoom = (ChatRoom) criteria.uniqueResult();
		if (chatRoom != null) {
			chatRoom.getUsers().forEach(System.out::println);
		}
		session.close();
	}

	@Override
	public boolean deleteChatRoom(String chatRoomName) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(ChatRoom.class);
		criteria.add(Restrictions.eq("chatRoomName", chatRoomName));
		ChatRoom chatRoom = (ChatRoom) criteria.uniqueResult();
		if (chatRoom != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(chatRoom);
			transaction.commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("name", username));
		User user = (User) criteria.uniqueResult();
		if (user != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public void close() {
		sessionFactory.close();
	}
	
	private ChatRoom getChatRoom(String chatRoomName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ChatRoom.class);
		criteria.add(Restrictions.eq("chatRoomName", chatRoomName));
		ChatRoom chatRoom = (ChatRoom) criteria.uniqueResult();
		session.close();
		return chatRoom;
	}

}