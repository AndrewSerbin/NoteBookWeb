package model.entity;

import java.util.ArrayList;
import java.util.Date;
import model.exception.EmailAlreadyExistsException;

public class NoteBookSingleton {

    private static volatile NoteBookSingleton instance;
    private ArrayList<Record> records;

    private NoteBookSingleton() {
	records = new ArrayList<>();
    }

    public static NoteBookSingleton getInstance() {
	if (instance == null) {
	    synchronized (NoteBookSingleton.class) {
		if (instance == null) {
		    instance = new NoteBookSingleton();
		}
	    }
	}

	return instance;
    }

    public void add(Record inputedRecord) throws EmailAlreadyExistsException {
	checkEmailForUniq(inputedRecord);

	inputedRecord.setDateOfEntryInNoteBook(new Date());
	records.add(inputedRecord);
    }

    /**
     * Checks for the existence of the entered e-mail address in the record array.
     * 
     * @param inputedRecord
     * @throws EmailAlreadyExistsException
     */
    void checkEmailForUniq(Record inputedRecord) throws EmailAlreadyExistsException {
	for (Record r : records) {
	    if (r.getEmail().equalsIgnoreCase(inputedRecord.getEmail())) {
		throw new EmailAlreadyExistsException(inputedRecord);
	    }
	}
    }

    public ArrayList<Record> getRecords() {
	return records;
    }

    public void setRecords(ArrayList<Record> records) {
	this.records = records;
    }
}
