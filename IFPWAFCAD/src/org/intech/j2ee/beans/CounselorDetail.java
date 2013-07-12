package org.intech.j2ee.beans;

import java.util.Date;

public class CounselorDetail {
	private String description;
	private String lastName;
	private String firstName;
	private String nickName;
	private Date memberSince;
	private String telephone;
	private String email;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return String.format(nickName.matches("\".*\"") ? "%s %s %s" : "%s \"%s\" %s", firstName, nickName, lastName);
	}
}
