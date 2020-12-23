package dev.heitt.AcortadorDeUrl.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.heitt.AcortadorDeUrl.Service.UrlService;

@RestController
public class URLController {
	
	UrlService urlService;
	
	@Autowired
	public URLController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@GetMapping("/r/{key}")
	public void redirect(@PathVariable("key") String key, HttpServletResponse httpServletResponse) throws IOException {
		try {
			httpServletResponse.setHeader("Location", "https://" + urlService.findById(key).getValue());
			httpServletResponse.setStatus(302);
		} catch (Exception e) {
			notFound();
		}
	}
	
	@GetMapping("/error")
	public String notFound() {
		return "No se encontro el sitio :(";
	}
}
