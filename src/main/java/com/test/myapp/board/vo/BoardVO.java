package com.test.myapp.board.vo;

/**
 * @author ksw
 * �Խ��� DTO (�Խñ� ��ȣ, �� ��ȣ, ����, ����, ��ȸ��, ���� ��¥, ���� ���̵�)  
 */
public class BoardVO {

	private int idx;
	private int parent_idx;
	private String title;
	private String content;
	private int hit_count;
	private String create_time;
	private String create_id;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getParent_idx() {
		return parent_idx;
	}
	public void setParent_idx(int parent_idx) {
		this.parent_idx = parent_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit_count() {
		return hit_count;
	}
	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
}