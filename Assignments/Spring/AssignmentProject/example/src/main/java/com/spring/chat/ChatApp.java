package com.spring.chat;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_chat.xml");
		ChatRoom chatRoom = (ChatRoom) context.getBean("chatRoomBean1");
		System.out.println(chatRoom);
		System.out.println("Messages = " + chatRoom.getMessages());
		System.out.println("Users = " + chatRoom.getUsers());
		
		ChatRoom foodChatRoom = (ChatRoom) context.getBean("chatRoomBean2");
		System.out.println();
		System.out.println(foodChatRoom);
		System.out.println("Messages = " + foodChatRoom.getMessages());
		System.out.println("Users = " + foodChatRoom.getUsers());
		context.close();
	}
}
