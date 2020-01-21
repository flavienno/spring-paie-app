package dev.paie.exec;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
public class InsererRemuneration implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(InsererRemuneration.class);

	private RemunerationEmployeRepository remunerationEmployeRepository;
	private GradeRepository gradeRepository;
	private ProfilRemunerationRepository profilRemunerationRepository;
	private EntrepriseRepository entrepriseRepository;

	public InsererRemuneration(RemunerationEmployeRepository remunerationEmployeRepository, GradeRepository gradeRepository,
			ProfilRemunerationRepository profilRemunerationRepository, EntrepriseRepository entrepriseRepository) {
		super();
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.gradeRepository = gradeRepository;
		this.profilRemunerationRepository = profilRemunerationRepository;
		this.entrepriseRepository = entrepriseRepository;
	}

	@Override
	public void run() {

		// Entreprise optEntreprise = this.entrepriseRepository.findById(1000).get(); //
		// anti-pattern

		Optional<Entreprise> optEntreprise = this.entrepriseRepository.findById(1);

		if (optEntreprise.isPresent()) {
			Entreprise entreprise1 = optEntreprise.get();
		}
		// cas je ne fais si pas trouvé
		this.entrepriseRepository.findById(1).ifPresent(entreprise -> {
		});

		// option 1 = je plante volontairement
		// option 2 = je cache les défaults

		try {
			// cas je plante si absent
			Entreprise entreprise1 = this.entrepriseRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("Entreprise non trouvée"));
			ProfilRemuneration profilRemuneration1 = this.profilRemunerationRepository.findById(2000)
					.orElseThrow(() -> new EntityNotFoundException("Profil non trouvée"));
			Grade grade1 = this.gradeRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("Grade non trouvée"));

			RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
			remunerationEmploye.setMatricule("test02");
			remunerationEmploye.setEntreprise(entreprise1);
			remunerationEmploye.setProfilRemuneration(profilRemuneration1);
			remunerationEmploye.setGrade(grade1);

			this.remunerationEmployeRepository.save(remunerationEmploye);

		} catch (EntityNotFoundException e) {
			LOG.error("Problème d'accès à une donnée en base : " + e.getMessage());
		}

	}

}
