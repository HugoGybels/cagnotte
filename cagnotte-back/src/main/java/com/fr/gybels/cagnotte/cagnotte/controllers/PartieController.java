package com.fr.gybels.cagnotte.cagnotte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fr.gybels.cagnotte.cagnotte.controllers.dto.PartieDTO;
import com.fr.gybels.cagnotte.cagnotte.model.Partie;
import com.fr.gybels.cagnotte.cagnotte.repositories.PartieRepository;
import com.fr.gybels.cagnotte.cagnotte.services.PartieService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/partie")
public class PartieController {

	@Autowired
	private PartieRepository partieRepository;

	@Autowired
	private PartieService partieService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getAllParties() {
		List<Partie> parties = partieService.getAllPartie();
		try {
			return new ResponseEntity(parties, HttpStatus.OK);
		}
		catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity addPartie(@RequestBody Partie partie) {

		partieService.addPartie(partie);

		try {
			return new ResponseEntity(HttpStatus.OK);
		}
		catch (Exception e) {
			return null;
		}
	}
}
