package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Counselor database table.
 * 
 */
@Entity
@NamedQuery(name="Counselor.findAll", query="SELECT c FROM Counselor c")
@Table(name="Counselor")
public class Counselor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="counselor_id")
	private int counselorId;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name="member_since")
	private Date memberSince;

	@Column(name="nick_name")
	private String nickName;

	private String telephone;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="counselor")
	private List<Subject> subjects;

	public Counselor() {
	}

	public int getCounselorId() {
		return this.counselorId;
	}

	public void setCounselorId(int counselorId) {
		this.counselorId = counselorId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getMemberSince() {
		return this.memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setCounselor(this);

		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setCounselor(null);

		return subject;
	}

}