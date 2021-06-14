package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track {
	
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artista, List<Artist> collaborators,String name, int duration) {
		super(artista, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		String mainArtist = this.getPerformerName();
		List<String> colabsName = new ArrayList<>();
		for (Artist i: this.collaborators) {
			colabsName.add(i.getName());
		}
		String names = mainArtist+ " " + "(" + "feat. " + String.join(",", colabsName) + ")";
		return names;
	}
	
}
