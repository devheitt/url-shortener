package dev.heitt.AcortadorDeUrl.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.heitt.AcortadorDeUrl.DAO.UrlRepository;
import dev.heitt.AcortadorDeUrl.Entity.Url;
import dev.heitt.AcortadorDeUrl.Utils.Normalizer;

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
		if (!url.isPresent())
			throw new Exception("Ese link no es valido");
		return url.get();
	}

	@Override
	public Url save(Url newUrl) throws Exception {
		Boolean existe = false;
		try {
			findById(newUrl.getKey());
			existe = true;		
		} catch(Exception e) {		
			
		}
		if (newUrl.getKey().isEmpty() || newUrl.getValue().isEmpty() || existe)
			throw new Exception();
		
		String normalizedUrl = Normalizer.normalize(newUrl.getValue());
		newUrl.setValue(normalizedUrl);
		
		return urlRepository.save(newUrl);
	}

}
