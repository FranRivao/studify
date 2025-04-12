package frangroup.studify.view;

import frangroup.studify.StudifyApplication;
import frangroup.studify.entity.Note;
import frangroup.studify.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(StudifyApplication.route + "notes/")
public class NoteView {
    @Autowired
    private final NoteService noteService;
    private final String DIRECTORY = "note/";

    public NoteView(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("create")
    public String showCreate() {
        return DIRECTORY + "index";
    }

    @PostMapping("create")
    public String createProcess(@RequestParam String title, @RequestParam String description, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);

        this.noteService.saveOrUpdate(Note.builder().title(title).description(description).build());
        return DIRECTORY + "resultado";
    }
}