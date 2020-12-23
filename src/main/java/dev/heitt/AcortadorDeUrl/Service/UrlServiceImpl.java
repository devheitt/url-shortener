package dev.heitt.AcortadorDeUrl.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.heitt.AcortadorDeUrl.DAO.UrlRepository;
import dev.heitt.AcortadorDeUrl.Entity.Url;

@Service
public class UrlServiceImpl implements UrlService {
	
	UrlRepository urlRepository;
	
	@Autowired
	public UrlServiceImpl(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	@Override
	public Url findById(String key) throws Exception {
		Optional<Url> url = urlRepository.findById(key);
		Url result = null;
		if(url.isPresent())
			result = url.get();
		else
			throw new Exception("Ese link no es valido");
		return result;
	}

}
