package asynchronous.templating.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import freemarker.template.TemplateException;

@Controller
public class AsyncTemplateController {

	@GetMapping(path = "/templateTest")
	public String templateTest(Model model, HttpServletRequest request) throws IOException, URISyntaxException, TemplateException {
		String baseUrl = request.getRequestURL().toString().replaceAll("templateTest", "");
		model.addAttribute("restUrl", baseUrl + "htmlData/");
		model.addAttribute("asyncTemplate", "ftlTest/ftlTest.ftl");
		return "templateTest";
	}
}
