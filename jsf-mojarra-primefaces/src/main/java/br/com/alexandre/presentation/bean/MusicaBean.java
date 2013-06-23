package br.com.alexandre.presentation.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.alexandre.application.exception.MyAppException;
import br.com.alexandre.application.service.MusicaService;
import br.com.alexandre.domain.vo.MusicaVO;

@ManagedBean
@ViewScoped
public class MusicaBean implements Serializable {

	private static final long serialVersionUID = 6477140911929052766L;

	@ManagedProperty(value="#{musicaService}")
	private MusicaService musicaService;

	private List<MusicaVO> musicas;
	
	public void buscar(final ActionEvent evt) {
		try {
			this.musicas = musicaService.buscarMusicasDoArtista(1L);
		} catch (MyAppException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void setMusicaService(MusicaService musicaService) {
		this.musicaService = musicaService;
	}

	public List<MusicaVO> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<MusicaVO> musicas) {
		this.musicas = musicas;
	}
	
	
}
