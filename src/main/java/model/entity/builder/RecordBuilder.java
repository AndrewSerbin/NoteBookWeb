package model.entity.builder;

import java.util.Date;
import model.entity.Address;
import model.entity.FullName;
import model.entity.Group;
import model.entity.Record;
import model.entity.Telephone;

class RecordBuilder {

	// Default initialization
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
	
	RecordBuilder setMake(String make) {
		this.make = make;
		return this;
	}
	RecordBuilder setTransmission(Transmission transmission) {
		this.transmission = transmission;
		return this;
	}
	RecordBuilder setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		return this;
	}
	
	Record build() {
		Record record = new Record();
		car.setMake(make);
		car.setTransmission(transmission);
		car.setMaxSpeed(maxSpeed);
		
		return car;
	}
}
