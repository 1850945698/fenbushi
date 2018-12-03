package com.book_manage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book_manage.entity.User;

public class UserDao {
	/*
	 * 添加商品方法
	 */
	public boolean addUser(User p){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into book(book_name,author,press) values(?,?,?)");
			pstm.setInt(1, p.getBook_id());;
			pstm.setString(2, p.getBook_name());;
			pstm.setString(3, p.getAuthor());
			pstm.setString(4, p.getPress());
//			pstm.setString(1, p.getName());
//			pstm.setString(2, p.getDescription());
//			pstm.setString(3, p.getListimg());
//			pstm.setInt(4, p.getPrice());
//			pstm.setInt(5, p.getDiscountprice());
			int rs = pstm.executeUpdate();
			if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
	/*
	 * 修改商品方法
	 */
	public boolean updateUser(User p){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("update book set book_name=?,author=?,press=? where book_id=?");
			pstm.setInt(1, p.getBook_id());;
			pstm.setString(2, p.getBook_name());;
			pstm.setString(3, p.getAuthor());
			pstm.setString(4, p.getPress());
//			pstm.setString(1, product.getName());
//			pstm.setString(2, product.getDescription());
//			pstm.setInt(3, product.getPrice());
//			pstm.setInt(4, product.getDiscountprice());
//            pstm.setInt(5, product.getId());
            int rs = pstm.executeUpdate();
            System.out.println(rs);
            if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * 删除商品方法<根据id>
	 */
	public boolean deleteUserByid(int book_id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from book where book_id=?");
			pstm.setInt(1, book_id);
			int rs=pstm.executeUpdate();
			if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * 验证该商品是否存�?<根据id>
	 */
	public boolean isExist(int book_id){
		return findUserById(book_id)==null?false:true;
	}
	
	/*
	 * 验证该商品是否存�?<根据name>
	 */
	public boolean isExist(String book_name){
		return findUserByName(book_name)==null?false:true;
	}
	private Object findUserByName(String book_name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 根据id查询相应商品
	 */
	public User findUserById(int book_id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from book where book_id=?");
			pstm.setInt(1, book_id);
			ResultSet rs=pstm.executeQuery();
			User p=null;
			while(rs.next()){
				p=new User();
				p.setBook_id(rs.getInt(1));
				p.setBook_name(rs.getString(2));
				p.setAuthor(rs.getString(3));
				p.setPress(rs.getString(4));
//				p=new Product();
//				p.setId(rs.getInt(1));
//				p.setName(rs.getString(2));
//				p.setDescription(rs.getString(3));
//				p.setListimg(rs.getString(4));
//				p.setPrice(rs.getInt(5));
//				p.setDiscountprice(rs.getInt(6));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 根据name查询相应商品
	 */
	public User findProductByName(String book_name){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from book where book_name=?");
			pstm.setString(1, book_name);
			ResultSet rs=pstm.executeQuery();
			User p=null;
			while(rs.next()){
				
//				p=new Product();
//				p.setId(rs.getInt(1));
//				p.setName(rs.getString(2));
//				p.setDescription(rs.getString(3));
//				p.setListimg(rs.getString(4));
//				p.setPrice(rs.getInt(5));
//				p.setDiscountprice(rs.getInt(6));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 查询全部商品的方�?
	 */
	public List<User> findAll(){
		try{
			List<User> list=new ArrayList<User>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from book");
			ResultSet rs=pstm.executeQuery();
			User p=null;
			while(rs.next()){
				p=new User();
				p.setBook_id(rs.getInt(1));
				p.setBook_name(rs.getString(2));
				p.setAuthor(rs.getString(3));
				p.setPress(rs.getString(4));
//				p=new Product();
//				p.setId(rs.getInt(1));
//				p.setName(rs.getString(2));
//				p.setDescription(rs.getString(3));
//				p.setListimg(rs.getString(4));
//				p.setPrice(rs.getInt(5));
//				p.setDiscountprice(rs.getInt(6));
				list.add(p);
				System.out.println(p);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 统计商品总数
	 * @return
	 */
	public int findCountByPage(){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select count(book_id) from book");
			ResultSet rs=pstm.executeQuery();
			int count=0;
			while(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/*
	 * 分页查询数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<User> findByPage(){
		try{
			List<User> list=new ArrayList<User>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from book");
			ResultSet rs=pstm.executeQuery();
			User p=null;
			while(rs.next()){
//				p=new Product();
//				p.setId(rs.getInt(1));
//				p.setName(rs.getString(2));
//				p.setDescription(rs.getString(3));
//				p.setListimg(rs.getString(4));
//				p.setPrice(rs.getInt(5));
//				p.setDiscountprice(rs.getInt(6));
				p=new User();
				p.setBook_id(rs.getInt(1));
				p.setBook_name(rs.getString(2));
				p.setAuthor(rs.getString(3));
				p.setPress(rs.getString(4));
				list.add(p);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
