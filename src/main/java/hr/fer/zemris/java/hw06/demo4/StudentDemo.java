package hr.fer.zemris.java.hw06.demo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class implements some filtering of {@link StudentRecord} using Stream
 * function Some methods names are on Croatian because it is provided in
 * instructions
 * 
 * @author Mihael
 *
 */
public class StudentDemo {

	/**
	 * Main program form which we call all methods for filtering
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			List<String> lines = Files.readAllLines(Paths.get("src/main/resources/studenti.txt"));
			List<StudentRecord> records = convert(lines);

			long broj = vratiBodovaViseOd25(records);
			long broj5 = vratiBrojOdlikasa(records);
			List<StudentRecord> odlikasi = vratiListuOdlikasa(records);
			List<StudentRecord> odlikasiSortirano = vratiSortiranuListuOdlikasa(records);
			List<String> nepolozeniJMBAGovi = vratiPopisNepolozenih(records);
			Map<Integer, List<StudentRecord>> mapaPoOcjenama = razvrstajStudentePoOcjenama(records);
			Map<Integer, Integer> mapaPoOcjenama2 = vratiBrojStudenataPoOcjenama(records);
			Map<Boolean, List<StudentRecord>> prolazNeprolaz = razvrstajProlazPad(records);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method count how many students have sum of points greater than 25
	 * 
	 * @param records
	 *            - list of students
	 * @return number of students with points greater than 25
	 */
	private static long vratiBodovaViseOd25(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getPointsMI() + e.getPointsZI() + e.getPointsLab()) > 25).count();
	}

	/**
	 * Method count how many students have best grade
	 * 
	 * @param records
	 *            - list of all students
	 * @return number of students with best grades
	 */
	private static long vratiBrojOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 5)).count();
	}

	/**
	 * Method filters all students with best grade
	 * 
	 * @param records
	 *            - list of all students
	 * @return {@link List} of {@link StudentRecord} with best grade
	 */
	private static List<StudentRecord> vratiListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 5)).collect(Collectors.toList());
	}

	/**
	 * Method creates sorted list of students by sum of their points
	 * 
	 * @param records
	 *            - list of all students
	 * @return list of students with best grade sorted by number of points
	 */
	private static List<StudentRecord> vratiSortiranuListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> e.getGrade() == 5)
				.sorted((first, second) -> (Double.valueOf(sumOf(second)).compareTo(Double.valueOf(sumOf(first)))))
				.collect(Collectors.toList());
	}

	/**
	 * Method creates list of students with grade 1
	 * 
	 * @param records
	 *            - list of all students
	 * @return list of students which didn't pass(have grade 1)
	 */
	private static List<String> vratiPopisNepolozenih(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 1)).map(e -> e.getJmbag()).sorted()
				.collect(Collectors.toList());
	}

	/**
	 * Method creates map where keys are grades and values are lists of students
	 * with specific grade
	 * 
	 * @param records
	 *            - list of all students
	 * @return map of all grades and students
	 */
	private static Map<Integer, List<StudentRecord>> razvrstajStudentePoOcjenama(List<StudentRecord> records) {
		return records.stream().collect(Collectors.groupingBy(e -> e.getGrade()));
	}

	/**
	 * Method creates map where keys are grades and values are numbers of students
	 * with specific grade
	 * 
	 * @param records
	 *            - list of all students
	 * @return map of grades and number of students with specific grade
	 */
	private static Map<Integer, Integer> vratiBrojStudenataPoOcjenama(List<StudentRecord> records) {
		return records.stream()
				.collect(Collectors.toMap(e -> e.getGrade(), t -> Integer.valueOf(1), (i, j) -> (i + j)));
	}

	/**
	 * Method creates map with keys true and false and values are student's
	 * list,depends if they passed subject or not
	 * 
	 * @param records
	 *            - list of all students
	 * @return map with students sorted if they passed or not
	 */
	private static Map<Boolean, List<StudentRecord>> razvrstajProlazPad(List<StudentRecord> records) {
		return records.stream().collect(Collectors.partitioningBy(e -> e.getGrade() > 1));
	}

	/**
	 * Method converts lines from txt document to {@link StudentRecord} files
	 * 
	 * @param lines
	 *            - txt document context
	 * @return list of {@link StudentRecord}
	 */
	private static List<StudentRecord> convert(List<String> lines) {
		ArrayList<StudentRecord> forReturn = new ArrayList<>();

		for (String line : lines) {
			String[] array = line.split("\t");

			if (array.length == 0)
				break;

			forReturn.add(new StudentRecord(array[0], array[2], array[1], Double.parseDouble(array[3]),
					Double.parseDouble(array[4]), Double.parseDouble(array[5]), Integer.parseInt(array[6])));
		}

		return forReturn;
	}

	/**
	 * Method calculates sum of all points for student
	 * 
	 * @param student
	 *            - student
	 * @return sum of points
	 */
	private static double sumOf(StudentRecord student) {
		return student.getPointsLab() + student.getPointsMI() + student.getPointsZI();
	}

}
