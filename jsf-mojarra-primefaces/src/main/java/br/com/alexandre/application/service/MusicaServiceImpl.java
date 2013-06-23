package br.com.alexandre.application.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexandre.application.exception.RepositoryException;
import br.com.alexandre.application.exception.ServiceException;
import br.com.alexandre.domain.entity.Album;
import br.com.alexandre.domain.factory.simple.MusicaVOFactory;
import br.com.alexandre.domain.repository.AlbumRepository;
import br.com.alexandre.domain.vo.MusicaVO;

@Component(value="musicaService")
public class MusicaServiceImpl implements MusicaService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private MusicaVOFactory musicaVOFactory;
		
	@Transactional
	public List<MusicaVO> buscarMusicasDoArtista(final Long artista) {
		try {
			final Iterator<Album> albunsDoArtista = albumRepository.buscarAlbunsDoArtista(artista);
			return musicaVOFactory.create(albunsDoArtista);
		} catch (final RepositoryException e) {
			throw e;
		} catch (final RuntimeException e) {
			throw new ServiceException(e);
		}
	}

}
