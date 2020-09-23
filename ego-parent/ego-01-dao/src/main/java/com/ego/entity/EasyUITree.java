package com.ego.entity;

/**
 * <p>
 * 树型目录返回类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
public class EasyUITree {
	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
