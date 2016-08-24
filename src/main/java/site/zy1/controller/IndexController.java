package site.zy1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/html_gen")
	public String htmlGen(Model model,@Value("${app.version:}") String version) {
		model.addAttribute("version", version);
		return "html-gen";
	}
	
	@RequestMapping("/orm_gen")
	public String ormGen(Model model) {
		return "orm-gen";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		return "index";
	}
}
