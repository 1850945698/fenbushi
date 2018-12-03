package com.book_manage.util;

import java.util.HashMap;
import java.util.Map;

import com.book_manage.entity.User;

public class Cart {
	private Map<Integer,CartItem> map= new HashMap<Integer,CartItem>();
	public Map<Integer, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	public void addCartItem(User u) {
//		if(map.containsKey(u.getId())) {
		if(map.containsKey(u.getBook_id())) {
//		  CartItem ci=map.get(u.getId());
		  CartItem ci=map.get(u.getBook_id());
		  ci.setCount(ci.getCount()+1);
		}else {
			CartItem ci=new CartItem();
			ci.setCount(1);
			ci.setUser(u);
			map.put(u.getBook_id(), ci);
			
		}
	}

}
