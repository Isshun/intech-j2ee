package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
@Table(name="Subject")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_id")
	private int subjectId;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to Counselor
	@ManyToOne
	@JoinColumn(name="counselor_idfk")
	private Counselor counselor;

	public Subject() {
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Counselor getCounselor() {
		return this.counselor;
	}

	public void setCounselor(Counselor counselor) {
		this.counselor = counselor;
	}

}