package model.entity;

import java.util.Date;

public class Record {

    private FullName fullName;
    private String nick;
    private String description;
    private Group group;
    private Telephone telephone;
    private String email;
    private String skype;
    private Address address;

    private Date dateOfEntryInNoteBook;
    private Date dateOfLastChanging;
    
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Telephone getTelephone() {
		return telephone;
	}
	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDateOfEntryInNoteBook() {
		return dateOfEntryInNoteBook;
	}
	public void setDateOfEntryInNoteBook(Date dateOfEntryInNoteBook) {
		this.dateOfEntryInNoteBook = dateOfEntryInNoteBook;
	}
	public Date getDateOfLastChanging() {
		return dateOfLastChanging;
	}
	public void setDateOfLastChanging(Date dateOfLastChanging) {
		this.dateOfLastChanging = dateOfLastChanging;
	}
}
