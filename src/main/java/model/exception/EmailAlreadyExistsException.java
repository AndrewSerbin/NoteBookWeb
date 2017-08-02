package model.exception;

import model.entity.Record;

public class EmailAlreadyExistsException extends Exception {

    private Record record;

    public EmailAlreadyExistsException(Record record) {
	this.record = record;
    }

    public EmailAlreadyExistsException(String message, Record record) {
	super(message);
	this.record = record;
    }

    public Record getRecord() {
	return record;
    }
}
