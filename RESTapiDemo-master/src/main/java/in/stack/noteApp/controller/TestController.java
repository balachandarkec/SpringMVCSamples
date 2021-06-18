package in.stack.noteApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stack.noteApp.entity.Note;

@RestController
@RequestMapping("/test/api/")
public class TestController {
	

	
	ResponseEntity<?> response=null;
	
	@GetMapping("/notes")
	public ResponseEntity<?> getmethodTest() {
		
		
		
		return new ResponseEntity< String >(" GET working Fine",HttpStatus.OK);
		
	}
//	
	@PostMapping("/notes")
	public ResponseEntity<?> postmethodTest() {
		
		
		
		return new ResponseEntity< String >(" post working Fine",HttpStatus.OK);
		
	}
	

}
