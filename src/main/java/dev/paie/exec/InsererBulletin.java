package dev.paie.exec;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
public class InsererBulletin implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(InsererBulletin.class);
	private RemunerationEmployeRepository remunerationEmployeRepository;
	private BulletinSalaireRepository bulletinSalaireRepository;
	private PeriodeRepository periodeRepository;

	public InsererBulletin(BulletinSalaireRepository bulletinSalaireRepository,
			RemunerationEmployeRepository remunerationEmployeRepository, PeriodeRepository periodeRepository) {
		super();
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.periodeRepository = periodeRepository;
	}

	@Override
	public void run() {

		RemunerationEmploye remunerationEmploye = this.remunerationEmployeRepository.findById(1)
				.orElseThrow(() -> new EntityNotFoundException("Remunération Employé non trouvée"));

		Periode periode2 = this.periodeRepository.findById(2)
				.orElseThrow(() -> new EntityNotFoundException("Période non trouvée"));

		BulletinSalaire bulletinSalaire = new BulletinSalaire();
		bulletinSalaire.setRemunerationEmploye(remunerationEmploye);
		bulletinSalaire.setPeriode(periode2);
		bulletinSalaire.setPrimeExceptionnelle(new BigDecimal("150"));

		this.bulletinSalaireRepository.save(bulletinSalaire);

		LOG.info("Bulletin inséré");

	}

}
