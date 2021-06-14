package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	
	public Track(Artist artista, String name, int duration) {
		this.artist = artista;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	public String getPerformerName() {
		return this.artist.getName();
	}
	
	
	public String getDurationString() {
		int minutos = 0;
		boolean continua = true;
		int segundos = this.getDuration();
		String tempo = "0:00";
		while (continua) {
			if(segundos < 60) {
				continua = false;
			}else {
				minutos += 1;
				segundos -= 60;
				}
		}
		if (segundos < 10) {
			tempo = Integer.toString(minutos)+ ":"+ "0" + Integer.toString(segundos);
		}else {
			tempo = Integer.toString(minutos)+ ":" + Integer.toString(segundos);
		}
		return tempo;
		
	}
	
	public String getFullArtistName() {
		return name;
	}
}
