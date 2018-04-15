package hr.fer.zemris.java.hw06.demo4;

import java.util.Objects;

/**
 * Method which presents every students with his attributes
 * jmbag,name,surname,grade and points form laboratory exercises,midterm exam
 * and final exam
 * 
 * @author Mihael
 *
 */
public class StudentRecord {
	/**
	 * Student's jmbag
	 */
	private String jmbag;
	/**
	 * Student's name
	 */
	private String name;
	/**
	 * Student's surname
	 */
	private String surname;
	/**
	 * Student's midterm exam points
	 */
	private Double pointsMI;
	/**
	 * Student's final exam points
	 */
	private Double pointsZI;
	/**
	 * Student's points from laboratory exercises
	 */

	private Double pointsLab;
	/**
	 * Student's grade
	 */
	private Integer grade;

	/**
	 * Public constructor which crates new {@link StudentRecord} with given
	 * attributes
	 * 
	 * @param jmbag
	 *            - student's jmbag
	 * @param name
	 *            - student's name
	 * @param surname
	 *            - student's surname
	 * @param pointsMI
	 *            - student's midterm exam points
	 * @param pointsZI
	 *            - student's final exam points
	 * @param pointsLab
	 *            - student's points from laboratory exercises
	 * @param grade
	 *            - student's grade
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
	 * Method return student's jmbag
	 * 
	 * @return student's jmbag
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Method return studnet's name
	 * 
	 * @return student's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method return student's surname
	 * 
	 * @return student's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Method returns student's midterm exam points
	 * 
	 * @return midterm points from student
	 */
	public Double getPointsMI() {
		return pointsMI;
	}

	/**
	 * Method return student's final exam points
	 * 
	 * @return final exam points
	 */
	public Double getPointsZI() {
		return pointsZI;
	}

	/**
	 * Method return student's laboratory exercise points
	 * 
	 * @return student's laboratory exercise points
	 */
	public Double getPointsLab() {
		return pointsLab;
	}

	/**
	 * Getter for student's grade
	 * 
	 * @return student's grade
	 */
	public Integer getGrade() {
		return grade;
	}

}
