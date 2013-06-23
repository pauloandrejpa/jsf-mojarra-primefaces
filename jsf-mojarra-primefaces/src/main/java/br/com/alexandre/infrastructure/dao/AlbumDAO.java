package br.com.alexandre.infrastructure.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.alexandre.domain.entity.Album;
import br.com.alexandre.domain.repository.AlbumRepository;

@Repository(value="albumRepository")
public class AlbumDAO implements AlbumRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Iterator<Album> buscarAlbunsDoArtista(final Long artista) {
		final TypedQuery<Album> namedQuery = entityManager.createNamedQuery("Album.buscarAlbunsDoArtista", Album.class);
		namedQuery.setParameter("artista", artista);
		final List<Album> albuns = namedQuery.getResultList();
		return (albuns != null)? new HashSet<Album>(albuns).iterator(): null;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	

}
