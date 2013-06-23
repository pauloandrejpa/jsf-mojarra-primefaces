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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ALBUM")
@NamedQueries(value={
	@NamedQuery(name="Album.buscarAlbunsDoArtista", query="Select a From Album a join fetch a.artista t join fetch a.musicas m Where t.id = :artista")
})
public class Album implements Serializable {

	private static final long serialVersionUID = -797072005279198932L;

	@Id
	@Column(name="ID", nullable=false)
	private Long id;

	@Column(name="TITULO", nullable=true)
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name="ID_ARTISTA", nullable=false)
	private Artista artista;
	
	@ManyToMany
	@JoinTable(name="CONTEM", 
				joinColumns={ @JoinColumn(name="ID_ALBUM", nullable=false) }, 
				inverseJoinColumns={ @JoinColumn(name="ID_MUSICA", nullable=false)})
	private Set<Musica> musicas;
	
	public Album() {
		this.musicas = new HashSet<Musica>(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Set<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(Set<Musica> musicas) {
		this.musicas = musicas;
	}		

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
