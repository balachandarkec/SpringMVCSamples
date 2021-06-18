package in.stack.noteApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stack.noteApp.entity.Note;
import in.stack.noteApp.service.NoteService;

@RestController
@RequestMapping("/noteService/api")  //http://localhost:8080/noteApp/noteService/api/notes
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	ResponseEntity<?> response=null;
	
	@GetMapping("/notes")
	public ResponseEntity<?> getAllNotes() {
		
		List<Note> notes=service.getAllNotes();
		
		return new ResponseEntity< List<Note> >(notes,HttpStatus.OK);
		
	}
	
	@PostMapping("/note")
	public ResponseEntity<?> saveNote(@RequestBody Note note, HttpSession session){
		ResponseEntity<?>	re= null;
		
		try {
			
			Note responseNote=service.createNote(note);
			if (responseNote !=null) {
				re= new ResponseEntity<Note>(responseNote,HttpStatus.CREATED);
			}else {
				re= new ResponseEntity<String>("Conflict Data",HttpStatus.CONFLICT);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			re= new ResponseEntity<String>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return re;
	}
	
	
	
	

}
