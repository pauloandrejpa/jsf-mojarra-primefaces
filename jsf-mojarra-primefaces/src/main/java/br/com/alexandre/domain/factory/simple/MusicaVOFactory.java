package br.com.alexandre.domain.factory.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alexandre.domain.entity.Album;
import br.com.alexandre.domain.entity.Musica;
import br.com.alexandre.domain.vo.MusicaVO;

@Component(value="musicaVOFactory")
public class MusicaVOFactory {
	
	public List<MusicaVO> create(final Iterator<Album> albuns) {
		final List<MusicaVO> musicasVO = new ArrayList<MusicaVO>();
		
		if (albuns != null) {
			while (albuns.hasNext()) {
				final Album album = albuns.next();
								
				if (album.getMusicas() != null) {
					final Iterator<Musica> musicas = album.getMusicas().iterator();
					while (musicas.hasNext()) {
						
						final Musica musica = musicas.next();
						
						final MusicaVO musicaVO = new MusicaVO();
						musicaVO.setAlbum(album.getTitulo());
						musicaVO.setArtista(album.getArtista().getNome());
						musicaVO.setTitulo(musica.getTitulo());
						musicaVO.setDuracao(musica.getDuracao());
						
						musicasVO.add(musicaVO);
					}
				}
			}
		} 

		return musicasVO;
	}
	
}
