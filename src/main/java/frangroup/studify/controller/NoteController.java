package frangroup.studify.controller;

import frangroup.studify.entity.Note;
import frangroup.studify.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notes")
public class NoteController {
    @Autowired
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note saveOrUpdate(@RequestBody Note note) {
        return noteService.saveOrUpdate(note);
    }

    @GetMapping
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @GetMapping("/{noteId}")
    public Note findById(@PathVariable("noteId") Integer id) {
        return noteService.findById(id);
    }

    @DeleteMapping("/{noteId}")
    public void delete(@PathVariable("noteId") Integer id) {
        noteService.delete(id);
    }
}
