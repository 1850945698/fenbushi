package com.book_manage.service;

import java.util.List;

import com.book_manage.dao.UserDao;
import com.book_manage.entity.User;
import com.book_manage.util.Cart;



public class UserService {

//	public User findUserById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	UserDao pd=new UserDao();
	/*
	 * 楠岃瘉鏌ヨ鍟嗗搧鏂规硶<鏍规嵁id>
	 */
//	public User findUserById(int id){
//		User p=pd.findUserById(id);
//		return p;
//	}
	public User findUserById(int book_id){
		User p=null;
		p=pd.findUserById(book_id);
		return p;
	}
	/*
	 * 楠岃瘉鏌ヨ鍟嗗搧鏂规硶
	 */
	public List<User> findAll() {
		List<User> list=pd.findAll();
		return list;
	}
	/*
	 * 楠岃瘉浣跨敤鍒嗛〉鏌ヨ鍟嗗搧鏂规硶	
	 */
	public List<User> findByPage(){
		List<User> list=pd.findByPage();
		return list;
	}
	/*
	 * 楠岃瘉鍟嗗搧鎬绘暟鏂规硶	
	 */
	public int findCountByPage(){
		int count=pd.findCountByPage();
		return count;
	}
	/*
	 * 楠岃瘉鍟嗗搧娣诲姞鏂规硶	
	 */
	public boolean addUser(User p){
		if(!pd.isExist((p.getBook_name()))){
			pd.addUser(p);
			return true;
		}else{
			System.out.println("姝ゅ晢鍝佸凡瀛樺湪");
			return false;
		}
		
	}
	
	 /* 
	  * 楠岃瘉鍟嗗搧淇敼鏂规硶	
	  */
	 
	public boolean updateProduct(User p){
		if(pd.isExist(p.getBook_id())){
			pd.updateUser(p);
			return true;
		}else{
			return false;
		}
	}
	
	 /*
	  * * 楠岃瘉鍟嗗搧鍒犻櫎鏂规硶	
	  */
	 
	public boolean deleteUser(int id){
		if(pd.isExist(id)){
			pd.deleteUserByid(id);
			return true;
		}else{
			return false;
		}
	}
	 // 鍒犻櫎璐墿杞︿腑璐墿椤�
    public void deleteCartItem(int id, Cart cart) {
        cart.getMap().remove(id);
    }
    // 娓呯┖璐墿杞�
    public void clearCart(Cart cart) {
        cart.getMap().clear();
    }
//    // 鏀瑰彉璐墿杞︽煇璐墿椤圭殑鏁伴噺
//    public void changeItemCount(int id, int count, Cart cart) {
//        CartItem item = cart.getContainer().get(id);
//        item.setCount(count);
//    }
}
