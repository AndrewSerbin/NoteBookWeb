package model;

import model.entity.NoteBookSingleton;
import model.entity.Record;
import model.exception.EmailAlreadyExistsException;

public class Model {

    private NoteBookSingleton noteBook;

    public Model() {
	noteBook = NoteBookSingleton.getInstance();
    }

    public void addRecord(Record record) throws EmailAlreadyExistsException {
	noteBook.add(record);
    }
}
