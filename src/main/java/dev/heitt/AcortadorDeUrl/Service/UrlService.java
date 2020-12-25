package dev.heitt.AcortadorDeUrl.Service;

import dev.heitt.AcortadorDeUrl.Entity.Url;

public interface UrlService {
	public Url findById(String key) throws Exception;
	public Url save(Url newUrl) throws Exception;
}
