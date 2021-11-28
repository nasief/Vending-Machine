package com.vendingmachine.components;

import com.vendingmachine.payments.Note;
import com.vendingmachine.payments.NoteType;

public class NoteSlot implements MoneySlot<Note> {

    @Override
    public int validateInserted(Note note) {
        return note.getType() == NoteType._20D || note.getType() == NoteType._50D ? note.getType().centify() : -1;
    }
}
