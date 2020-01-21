package dev.paie.exec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Controller
public class ListerCotisations implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerCotisations.class);

	private CotisationRepository cotisationRepository;

	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public void run() {

		List<Cotisation> listCotisation = cotisationRepository.findAll();

		for (Cotisation cotisation : listCotisation) {
			LOG.info("code={} libelle={} tauxSalarial={} tauxPatronal={}", cotisation.getCode(),
					cotisation.getLibelle(), cotisation.getTauxSalarial(), cotisation.getTauxPatronal());
		}
	}

}
