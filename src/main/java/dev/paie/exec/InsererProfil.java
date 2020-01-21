package dev.paie.exec;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Controller
public class InsererProfil implements Runnable {

	private ProfilRemunerationRepository profilRemunerationRepository;
	private CotisationRepository cotisationRepository;

	public InsererProfil(ProfilRemunerationRepository profilRemunerationRepository,
			CotisationRepository cotisationRepository) {
		super();
		this.profilRemunerationRepository = profilRemunerationRepository;
		this.cotisationRepository = cotisationRepository;

	}

	@Override
	public void run() {

		List<Cotisation> cotisations = this.cotisationRepository.findAllById(Arrays.asList(1, 2));

		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		profilRemuneration.setCode("Apprenti");
		profilRemuneration.setCotisations(cotisations);

		this.profilRemunerationRepository.save(profilRemuneration);

	}

}
