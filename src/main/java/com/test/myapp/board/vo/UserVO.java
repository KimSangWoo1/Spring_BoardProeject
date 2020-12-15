package com.test.myapp.board.vo;

public class UserVO {
	private int userno; //회원번호
	private String userid; //회원아이디
	private String userpw; //회원비밀번호
	
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
}
