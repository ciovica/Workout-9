package ro.digitalnation.restuflWebService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.digitalnation.activitati.Activitate;
import ro.digitalnation.activitati.Curs;
import ro.digitalnation.basic.Persoana;
import ro.digitalnation.structure.Track;

@RestController
public class TrackController {
	private Track track;

	public TrackController() {
		this.setTrack(new Track());
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@GetMapping("/curs")
	public Curs getCurs() {
		return track.getCurs();
	}

	@GetMapping("/exploreri")
	public ArrayList<Persoana> getExploreri() {
		return getCurs().getExploreri();
	}

	@GetMapping("/trainer")
	public Persoana getTrainer() {
		return getTrainer();
	}

	@GetMapping("/activitati")
	public LinkedHashMap<String, Activitate> getActivitati() {
		return getCurs().getActivitati();
	}

	@GetMapping("/activitate")
	public LinkedHashMap<String, Activitate> getActivitati(
			@RequestParam(value = "name", defaultValue = "name") String name) {
		return getActivitati(name);
	}

	@GetMapping("explorer/{id}")
	public String obtineIdentificator(@PathVariable String id) {
		return "ID explorer: " + obtineIdentificator(id);
	}
}