package frangroup.studify.view;

import frangroup.studify.StudifyApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(StudifyApplication.route)
public class IndexView {

    @GetMapping
    public String showIndex() {
        return "index";
    }
}
