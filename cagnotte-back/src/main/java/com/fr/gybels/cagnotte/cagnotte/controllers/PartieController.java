package com.fr.gybels.cagnotte.cagnotte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fr.gybels.cagnotte.cagnotte.controllers.dto.PartieDTO;
import com.fr.gybels.cagnotte.cagnotte.model.Partie;
import com.fr.gybels.cagnotte.cagnotte.repositories.PartieRepository;

@Controller
@RequestMapping("/partie")
public class PartieController {

	@Autowired
	private PartieRepository partieRepository;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getAllParties() {
		List<Partie> parties = partieRepository.findAll();
		PartieDTO partieDTO = new PartieDTO();
		partieDTO.setIdPartie(parties.get(0).getIdPartie());
		try {
			return new ResponseEntity(parties, HttpStatus.OK);
		}
		catch (Exception e) {

		}
		return null;
	}
}
