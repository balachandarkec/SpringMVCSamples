package in.stack.noteApp.service;

import java.util.List;

import in.stack.noteApp.entity.Note;

public interface NoteService {

	public List<Note> getAllNotes();
	public Note createNote(Note n);
}
