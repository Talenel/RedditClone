package groupA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by student on 6/20/17.
 */
@Controller
public class HomeController {
    @Autowired
    private RedditRepository redditRepository;


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute(new Reddit());
        model.addAttribute("items", redditRepository.findAllByOrderByRedDateDesc());
        return "result";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/create")
    public String newReddit(Model model){
        model.addAttribute("reddit", new Reddit());
        return "form";
    }
    @GetMapping("/add")
    public String getReddit(Model model){
        model.addAttribute(new Reddit());
        model.addAttribute("items", redditRepository.findAllByOrderByRedDateDesc());
        return "result";
    }
    @PostMapping("/add")
    public String processReddit(Model model, @Valid Reddit reddit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        redditRepository.save(reddit);
        return "redirect:/add";

        //finishProcessingReddit(reddit, bindingResult);

    }
    @GetMapping("/author")
    public String getReddit(Model model, Reddit reddit){
        reddit.setRedAuthor("DJakademiks");
        model.addAttribute(reddit);
        model.addAttribute("items", redditRepository.findAllByRedAuthorOrderByRedDateDesc(reddit.getRedAuthor()));
        return "byauthor";
    }
    /*public String sameClassmate(Model model, Reddit reddit){

        model.addAttribute("classmate", reddit);
        return "form";
    }*/

}
