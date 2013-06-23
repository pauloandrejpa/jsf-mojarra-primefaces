package br.com.alexandre.application.service;

import java.util.List;

import br.com.alexandre.domain.vo.MusicaVO;

public interface MusicaService {
	public List<MusicaVO> buscarMusicasDoArtista(final Long artista);
}
