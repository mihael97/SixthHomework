package hr.fer.zemris.java.hw06.demo4;

import java.util.Objects;

/**
 * Metoda predstavlja zapis svakog studenta sa svojim
 * atrubutima:jmbag,ime,prezime,bodovi sa završnog,međuispita i vježbi i ocjena
 * 
 * @author Mihael
 *
 */
public class StudentRecord {
	/**
	 * Studentov jmbag
	 */
	private String jmbag;
	/**
	 * Studentovo ime
	 */
	private String name;
	/**
	 * Studentovo prezime
	 */
	private String surname;
	/**
	 * Studentovi bodovi s međuispita
	 */
	private Double pointsMI;
	/**
	 * Studentovi bodovi s završnog ispita
	 */
	private Double pointsZI;
	/**
	 * Studentovi bodovi iz vježbi
	 */

	private Double pointsLab;
	/**
	 * Studentova ocjena
	 */
	private Integer grade;

	/**
	 * Konstruktor stvar novi zapis o studentu
	 * 
	 * @param jmbag
	 *            - studentov jmbag
	 * @param name
	 *            - studentovo ime
	 * @param surname
	 *            - studentovo prezime
	 * @param pointsMI
	 *            - studentovi bodovi s međuispita
	 * @param pointsZI
	 *            - studentovi bodovi sa završnog ispita
	 * @param pointsLab
	 *            - studentovi bodovi iz vježbi
	 * @param grade
	 *            - studentova ocjena
	 */
	public StudentRecord(String jmbag, String name, String surname, Double pointsMI, Double pointsZI, Double pointsLab,
			Integer grade) {
		super();
		this.jmbag = Objects.requireNonNull(jmbag);
		this.name = Objects.requireNonNull(name);
		this.surname = Objects.requireNonNull(surname);
		this.pointsMI = Objects.requireNonNull(pointsMI);
		this.pointsZI = Objects.requireNonNull(pointsZI);
		this.pointsLab = Objects.requireNonNull(pointsLab);
		this.grade = Objects.requireNonNull(grade);
	}

	/**
	 * Metoda vraća studentov jmbag
	 * 
	 * @return studentov jmbag
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Metoda vraća studentovo ime
	 * 
	 * @return studentovo ime
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda vraća studentovo prezime
	 * 
	 * @return studentovo prezime
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Metoda vraća studentove bodove s međuispita
	 * 
	 * @return studentovi bodovi s međuispita
	 */
	public Double getPointsMI() {
		return pointsMI;
	}

	/**
	 * Metoda vraća studentove bodove sa završnog ispita
	 * 
	 * @return bodovi sa završnog ispita
	 */
	public Double getPointsZI() {
		return pointsZI;
	}

	/**
	 * Metoda vraća studentove bodove iz laboratorijskih vježbi
	 * 
	 * @return studentovi bodovi iz vježbi
	 */
	public Double getPointsLab() {
		return pointsLab;
	}

	/**
	 * Metoda vraća studentovu ocjenu
	 * 
	 * @return studentova ocjena
	 */
	public Integer getGrade() {
		return grade;
	}

}
