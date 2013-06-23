package br.com.alexandre.domain.vo;

import java.io.Serializable;

public class MusicaVO implements Serializable{

	private static final long serialVersionUID = 7004939252913892779L;

	private String titulo;
	
	private Integer duracao;
	
	private String artista;
	
	private String album;
	
	private boolean selecionada;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public boolean isSelecionada() {
		return selecionada;
	}

	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
	
	
}
