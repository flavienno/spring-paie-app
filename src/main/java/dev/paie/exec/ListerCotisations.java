package dev.paie.exec;

import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

//@Controller
public class ListerCotisations implements Runnable {

	private CotisationRepository cotisationRepository;

	/**
	 * @param cotisationRepository 
	 * injection par controleur
	 */
	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public void run() {
		// creation de la liste des cotisations et affichage
		List<Cotisation> cotisations = this.cotisationRepository.findAll();
		for (Cotisation cotisation : cotisations) {
			System.out.println(cotisation.getLibelle());
		}

	}

}
