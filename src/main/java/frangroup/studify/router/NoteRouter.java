package frangroup.studify.router;

import frangroup.studify.StudifyApplication;
import frangroup.studify.entity.Note;
import frangroup.studify.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = StudifyApplication.route + "notes")
public class NoteRouter {
    @Autowired
    private final NoteService noteService;

    public NoteRouter(NoteService noteService) {
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
