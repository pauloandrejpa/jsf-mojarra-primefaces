package br.com.alexandre.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MUSICA")
public class Musica implements Serializable {

	private static final long serialVersionUID = -1227541828251605605L;

	@Id
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="TITULO", length=50, nullable=false)
	private String titulo;
	
	@Column(name="DURACAO", nullable=false)
	private Integer duracao;
	
	@ManyToMany
	@JoinTable(name="CONTEM", 
			joinColumns={ @JoinColumn(name="ID_MUSICA", nullable=false) }, 
			inverseJoinColumns={ @JoinColumn(name="ID_ALBUM", nullable=false)})
	private Set<Album> albuns;
	
	public Musica() {
		this.albuns = new HashSet<Album>(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(Set<Album> albuns) {
		this.albuns = albuns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
