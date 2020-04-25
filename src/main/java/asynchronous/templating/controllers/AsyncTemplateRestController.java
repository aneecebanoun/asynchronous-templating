package asynchronous.templating.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import asynchronous.templating.services.FtlService;
import freemarker.template.TemplateException;

@RestController
public class AsyncTemplateRestController {

	@Autowired
	private FtlService ftlService;

	@RequestMapping(path = "/htmlData", method = RequestMethod.POST)
	public Map<String, String> gethtmlData(@RequestBody Map<String, String> inData)
			throws IOException, URISyntaxException, TemplateException {
		Map<String, String> outData = new HashMap<>();
		outData.put("inData", ftlService.getTemplateHtml(inData, inData.get("asyncTemplate")));
		return outData;
	}
}
