package in.stack.noteApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import in.stack.noteApp.entity.Note;

@Repository
@Transactional
public class NoteRepositoryImpl implements NoteRepository {
	
	@Autowired
	private SessionFactory factory;
	
	private Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Note> getAllNotes() {
		
		Criteria cr=getCurrentSession().createCriteria(Note.class);
		
		List<Note> notes=cr.list();
		return notes;
	}

	@Override
	public Note createNote(Note n) {
		Note note=null;
		
		if(getCurrentSession().save(n)!=null) {	
	     note=n;
	   }
		return note;
	}

}
