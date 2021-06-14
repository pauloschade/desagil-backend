package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Track track;
	private Artist artist;

	@BeforeEach
	void setUp() {
		this.artist = new Artist("Anitta");
		this.track = new Track(this.artist, "LALA", 0);
	}

	@Test
	void testRoundDownToZero() {
		Playlist playlist = new Playlist(1);
		playlist.putRating("Alberto", 1);
		playlist.putRating("Jose", 2);
		playlist.putRating("Carlos", 3);
		playlist.putRating("Jorge", 3);
		double nota = playlist.averageRatings();
		assertEquals(2.0, nota, DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		Playlist playlist = new Playlist(1);
		playlist.putRating("Alberto", 1);
		playlist.putRating("Jose", 2);
		playlist.putRating("Carlos", 1);
		double nota = playlist.averageRatings();
		assertEquals(1.5, nota, DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		Playlist playlist = new Playlist(1);
		playlist.putRating("Alberto", 1);
		playlist.putRating("Jose", 2);
		playlist.putRating("Carlos", 2);
		double nota = playlist.averageRatings();
		assertEquals(1.5, nota, DELTA);
	}

	@Test
	void testRoundUpToOne() {
		Playlist playlist = new Playlist(1);
		playlist.putRating("Alberto", 1);
		playlist.putRating("Jose", 1);
		playlist.putRating("Carlos", 2);
		playlist.putRating("Jorge", 3);
		double nota = playlist.averageRatings();
		assertEquals(2.0, nota, DELTA);
	}
}
