package com.cognizant.farmfresh.dao;

public class CartEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ename;
	public CartEmptyException() {
		ename = "MyCart is Empty";
	}
	@Override
	public String toString() {
		return "CartEmptyException [ename=" + ename + "]";
	}
}
