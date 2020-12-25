package dev.heitt.AcortadorDeUrl.Utils;

public class Normalizer {
	public static String normalize(String url) {
		if(url.contains("://"))
			return url;
		return "https://" + url;
	}

}
