package org.intech.j2ee.beans;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date 	mDate;
	private int 	mI;
	private int 	mJ;
	private int 	mK;

	public Order(int i, int j, int k) {
		mI = i;
		mJ = j;
		mK = k;
		mDate = new Date();
	}

	public Order(int i, int j, int k, Date date) {
		mI = i;
		mJ = j;
		mK = k;
		mDate = date;
	}

	public Date getDate() {
		return mDate;
	}
	
	public int getI() {
		return mI;
	}

	public int getJ() {
		return mJ;
	}

	public int getK() {
		return mK;
	}

}
