package in.stack.noteApp.repository;

import java.util.List;

import in.stack.noteApp.entity.Note;

public interface NoteRepository {

	public List<Note> getAllNotes();
	public Note createNote(Note n);
	
}
