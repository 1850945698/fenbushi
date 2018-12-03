package com.book_manage.util;

import com.book_manage.entity.User;

public class CartItem {
	private User user;
	private int count;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
