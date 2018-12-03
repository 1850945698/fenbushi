package com.book_manage.entity;

public class User {
private int book_id;
private String book_name;
private String author;
private String press;
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPress() {
	return press;
}
public void setPress(String press) {
	this.press = press;
}
@Override
public String toString() {
	return "User [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", press=" + press + "]";
}

}
