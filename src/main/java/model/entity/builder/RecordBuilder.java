package model.entity.builder;

import java.util.Date;
import model.entity.Address;
import model.entity.FullName;
import model.entity.Group;
import model.entity.Record;
import model.entity.Telephone;

class RecordBuilder {
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
	
	public RecordBuilder setFullName(String name, String surname,  String patronymic, String truncatedName) {
		fullName = new FullName(surname, name, patronymic, truncatedName);
		return this;
	}
	
	public RecordBuilder setNick(String nick) {
		this.nick = nick;
		return this;
	}
	
	public RecordBuilder setDesription(String description) {
		this.description = description;
		return this;
	}
	
	public RecordBuilder setGroup(String group) {
        this.group = Group.valueOf(group);
        return this;
    }
	
    public RecordBuilder setTelephone(String mainTelephone, String spareTelephone) {
        this.telephone = new Telephone(mainTelephone, spareTelephone);
        return this;
    }
    
    public RecordBuilder setSkype(String skype) {
        this.skype = skype;
        return this;
    }
    
    public RecordBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public RecordBuilder setAddress(String index, String city, String street, String houseNumber, 
    		String apartmentNumber, String fullAddress) {
        this.address = new Address(index, city, street, houseNumber, apartmentNumber, fullAddress);
        return this;
    }
    
    public RecordBuilder setDateOfLastChanging(String dateOfLastChanging) {
        this.dateOfLastChanging = new Date(dateOfLastChanging);
        return this;
    }
	
	public Record build() {
		Record record = new Record();
		record.setFullName(fullName);
		record.setNick(nick);
		record.setDescription(description);
		record.setGroup(group);
		record.setTelephone(telephone);
		record.setEmail(email);
		record.setSkype(skype);
		record.setAddress(address);
		record.setDateOfLastChanging(dateOfLastChanging);
		
		return record;
	}
}
