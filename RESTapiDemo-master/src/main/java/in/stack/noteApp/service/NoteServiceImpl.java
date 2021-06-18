package in.stack.noteApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stack.noteApp.entity.Note;
import in.stack.noteApp.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository repo;

	@Override
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		return repo.getAllNotes();
	}

	@Override
	public Note createNote(Note n) {
		// TODO Auto-generated method stub
		return repo.createNote(n);
	}

}
