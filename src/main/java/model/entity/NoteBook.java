package model.entity;

import java.util.ArrayList;
import model.exception.EmailAlreadyExistsException;

public class NoteBook {

    private ArrayList<Record> records;

    public NoteBook() {
        records = new ArrayList<>();
    }

    public void add(Record inputedRecord) throws EmailAlreadyExistsException {
        checkEmailForUniq(inputedRecord);

        inputedRecord.refreshDateOfEntryInNoteBook();
        records.add(inputedRecord);
    }

    /**
     * Checks for the existence of the entered e-mail address in the record array.
     * @param inputedRecord
     * @throws EmailAlreadyExistsException
     */
    void checkEmailForUniq(Record inputedRecord) throws EmailAlreadyExistsException {
        for (Record r :
                records) {
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
