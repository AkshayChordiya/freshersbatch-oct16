package com.hibernate.chat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="USERS")
public class User implements Comparable<User> {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="room_id")
	private ChatRoom chatroom;
	
	public User() {
	}
	
	public User(ChatRoom chatroom, String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.chatroom = chatroom;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ChatRoom getChatRoom() {
		return chatroom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatroom = chatRoom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", chatRoom=" + chatroom.getChatRoomName() + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.name);
	}
	
}