package br.com.alexandre.domain.repository;

import java.util.Iterator;

import br.com.alexandre.domain.entity.Album;

public interface AlbumRepository {
	public Iterator<Album> buscarAlbunsDoArtista(final Long artista);
}
