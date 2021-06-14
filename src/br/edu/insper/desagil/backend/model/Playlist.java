package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(int id) {
		super();
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	
	public int getId() {
		return id;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track faixa) {
		this.tracks.add(faixa);
	}
	
	public void putRating(String nome, int rating) {
		this.ratings.put(nome,rating);
	}
	
	public double averageRatings() {
		double mediaDouble;
		int soma = 0;
		int media;
		double fractionMedia;
		double finalMedia;
		
		if (this.ratings.size() == 0) {
			return 0;
		}
		for (int i: this.ratings.values()) {
			soma += i;
		}
		
		mediaDouble = (double) soma/this.ratings.size();
		
		media = (int) mediaDouble;
		
		fractionMedia = mediaDouble - media;
		
		if (fractionMedia < 0.26) {
			finalMedia = media;
		}else if(fractionMedia < 0.74) {
			finalMedia = media + 0.5;
		} else {
			finalMedia = media + 1;
		}
		
		return finalMedia;
		
		
	}
	
}
