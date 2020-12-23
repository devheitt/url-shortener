package dev.heitt.AcortadorDeUrl.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.heitt.AcortadorDeUrl.Entity.Url;

public interface UrlRepository extends JpaRepository<Url, String> {

}
