package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int i;

	private int j;

	private int k;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getI() {
		return this.i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return this.j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getK() {
		return this.k;
	}

	public void setK(int k) {
		this.k = k;
	}

}