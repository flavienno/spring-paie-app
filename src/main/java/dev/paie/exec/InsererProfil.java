package dev.paie.exec;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

public class InsererProfil implements Runnable {

	private ProfilRepository profilRepository;

	/**
	 * @param profilRepository
	 */
	public InsererProfil(ProfilRepository profilRepository) {
		super();
		this.profilRepository = profilRepository;
	}

	@Override
	public void run() {
		ProfilRemuneration nvProfil = new ProfilRemuneration();
		nvProfil.setCode("Cadre_supérieur");

	}

}
