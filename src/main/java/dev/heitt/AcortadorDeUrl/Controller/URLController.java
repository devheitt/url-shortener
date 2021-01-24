package dev.heitt.AcortadorDeUrl.Controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.heitt.AcortadorDeUrl.Entity.Url;
import dev.heitt.AcortadorDeUrl.Service.UrlService;

@Controller
public class URLController {
	
	UrlService urlService;
	
	@Autowired
	public URLController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@GetMapping("/{key}")
	public void redirect(@PathVariable("key") String key, HttpServletResponse httpServletResponse) throws IOException {
		try {
			String url = urlService.findById(key).getValue();
			httpServletResponse.setHeader("Location", url);
		} catch (Exception e) {
			httpServletResponse.setHeader("Location", "/?message=link inexistente");
		}
		httpServletResponse.setStatus(302);
	}

	@GetMapping("/")
	public String index(Model model, @RequestParam Optional<String> message) {
		model.addAttribute("date", new java.util.Date());
		model.addAttribute("newUrl", new Url());
		if(!message.isEmpty())
			model.addAttribute("message", message.get());
		return "index";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute Url newUrl) {
		try {
			urlService.save(newUrl);
			return "redirect:/?success=" + newUrl.getKey();
		} catch (Exception e) {			
			return "redirect:/?error";
		}
	}
	
}
