package fr.eservices.week402.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

  @RequestMapping(value="/world", method=RequestMethod.GET)
  public String sayHello(
      Model model, 
      @RequestParam(value="name", required=false, defaultValue=" ")String name) 
  {
    model.addAttribute("message", "Hello " + name + " !");
    return "sample";
  }
}
