package model;

import model.entity.NoteBook;
import model.entity.Record;
import model.exception.EmailAlreadyExistsException;

public class Model {

    private NoteBook noteBook;

    public Model() {
        noteBook = new NoteBook();
    }

    public void addRecord(Record record) throws EmailAlreadyExistsException {
        noteBook.add(record);
    }
}
