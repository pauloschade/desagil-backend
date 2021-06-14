package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Artist artist;
	@BeforeEach
	void setUp() {
		this.artist = new Artist("Anitta");
	}

	@Test
	void testZeroSeconds() {
		Track track = new Track(this.artist, "LALA", 0);
		String tempo = track.getDurationString();
		assertEquals("0:00", tempo);
	}

	@Test
	void testFiveSeconds() {
		
		Track track = new Track(this.artist, "LALA", 5);
		String tempo = track.getDurationString();
		assertEquals("0:05", tempo);
		
	}

	@Test
	void testTwentyFiveSeconds() {
		Track track = new Track(this.artist, "LALA", 25);
		String tempo = track.getDurationString();
		assertEquals("0:25", tempo);
	}

	@Test
	void testOneMinuteZeroSeconds() {
		Track track = new Track(this.artist, "LALA", 60);
		String tempo = track.getDurationString();
		assertEquals("1:00", tempo);
	}

	@Test
	void testOneMinuteFiveSeconds() {
		Track track = new Track(this.artist, "LALA", 65);
		String tempo = track.getDurationString();
		assertEquals("1:05", tempo);
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		Track track = new Track(this.artist, "LALA", 85);
		String tempo = track.getDurationString();
		assertEquals("1:25", tempo);
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		Track track = new Track(this.artist, "LALA", 120);
		String tempo = track.getDurationString();
		assertEquals("2:00", tempo);
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		Track track = new Track(this.artist, "LALA", 125);
		String tempo = track.getDurationString();
		assertEquals("2:05", tempo);
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		Track track = new Track(this.artist, "LALA", 145);
		String tempo = track.getDurationString();
		assertEquals("2:25", tempo);
	}

	@Test
	void testOneCollaborator() {
		List<Artist> colabs = new ArrayList<>();
		Artist colaborator1 = new Artist("Becky G");
		colabs.add(colaborator1);
		CollaborationTrack colabTrack = new CollaborationTrack(this.artist,colabs, "LALA", 0);
		String full = colabTrack.getFullArtistName();
		assertEquals("Anitta (feat. Becky G)", full);
	}

	@Test
	void testTwoCollaborators() {
		List<Artist> colabs = new ArrayList<>();
		Artist colaborator1 = new Artist("Ludmilla");
		Artist colaborator2 = new Artist("Snoop Dog");
		colabs.add(colaborator1);
		colabs.add(colaborator2);
		CollaborationTrack colabTrack = new CollaborationTrack(this.artist,colabs, "LALA", 0);
		String full = colabTrack.getFullArtistName();
		assertEquals("Anitta (feat. Ludmilla,Snoop Dog)", full);
	}
}
