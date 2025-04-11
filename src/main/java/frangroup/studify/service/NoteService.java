package frangroup.studify.service;

import frangroup.studify.entity.Note;
import frangroup.studify.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveOrUpdate(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note findById(Integer id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        noteRepository.deleteById(id);
    }
}
