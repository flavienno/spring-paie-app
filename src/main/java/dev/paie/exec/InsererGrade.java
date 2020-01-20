package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;

import dev.paie.repository.GradeRepository;

@Controller
public class InsererGrade implements Runnable {

	private GradeRepository gradeRepository;

	/**
	 * @param gradeRepository
	 */
	public InsererGrade(GradeRepository gradeRepository) {
		super();
		this.gradeRepository = gradeRepository;
	}

	@Override
	public void run() {

		Grade nvGrade = new Grade();
		nvGrade.setCode("Grade_H");
		nvGrade.setTauxBase(new BigDecimal(40));
		nvGrade.setNbHeuresBase(new BigDecimal(152));

	}

}
