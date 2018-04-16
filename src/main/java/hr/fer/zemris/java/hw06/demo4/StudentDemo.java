package hr.fer.zemris.java.hw06.demo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Razred implementira filter zapisa o studentima putem stremova. Kako je zadano
 * u uputi,nazivi nekih su metoda na hrvatskom
 * 
 * @author Mihael
 *
 */
public class StudentDemo {

	/**
	 * Glavni program
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
	 * Metod vraća broje studenata sa sumom bodova većom od 25
	 * 
	 * @param records
	 *            - lista studenata
	 * @return broj studenata sa sumom bodova većom od 25
	 */
	private static long vratiBodovaViseOd25(List<StudentRecord> records) {
		return records.stream().filter(e -> (sumOf(e)) > 25).count();
	}

	/**
	 * Metoda računa koliko studenata ima odličnu ocjenu
	 * 
	 * @param records
	 *            - lista studenata
	 * @return broj studenata s najboljom ocjenom
	 */
	private static long vratiBrojOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 5)).count();
	}

	/**
	 * Metoda stvara listu svih odlikaša
	 * 
	 * @param records
	 *            - lista studenata
	 * @return {@link List} {@link StudentRecord} sa najboljom ocjenom
	 */
	private static List<StudentRecord> vratiListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 5)).collect(Collectors.toList());
	}

	/**
	 * Metoda koja vraća listu studenata sa odličnim uspjehom sortiranu po sumi
	 * bodova
	 * 
	 * @param records
	 *            - lista studenata
	 * @return lista studenata sa najboljim ocjenama sortirana po bodovima
	 */
	private static List<StudentRecord> vratiSortiranuListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(e -> e.getGrade() == 5)
				.sorted((first, second) -> (Double.valueOf(sumOf(second)).compareTo(Double.valueOf(sumOf(first)))))
				.collect(Collectors.toList());
	}

	/**
	 * Metoda stvara listu učenika sa nedovoljnom ocjenom
	 * 
	 * @param records
	 *            - lista studenata
	 * @return lista studenata koji nisu prošli
	 * 
	 */
	private static List<String> vratiPopisNepolozenih(List<StudentRecord> records) {
		return records.stream().filter(e -> (e.getGrade() == 1)).map(e -> e.getJmbag()).sorted()
				.collect(Collectors.toList());
	}

	/**
	 * Metoda vraća mapu studenata gdje je ključ ocjena,a vrijednost lista studenata
	 * sa tom ocjenom
	 * 
	 * @param records
	 *            - lista studenata
	 * @return mapa svih studenata raspoređenih po ocjenama
	 */
	private static Map<Integer, List<StudentRecord>> razvrstajStudentePoOcjenama(List<StudentRecord> records) {
		return records.stream().collect(Collectors.groupingBy(e -> e.getGrade()));
	}

	/**
	 * Metoda vraća mapu gdje je ključ ocjena,a vrijednost broj studenata sa tom
	 * ocjenom
	 * 
	 * @param records
	 *            - lista studenata
	 * @return mapa ocjena s brojem studenata sa tom ocjenom
	 */
	private static Map<Integer, Integer> vratiBrojStudenataPoOcjenama(List<StudentRecord> records) {
		return records.stream()
				.collect(Collectors.toMap(e -> e.getGrade(), t -> Integer.valueOf(1), (i, j) -> (i + j)));
	}

	/**
	 * Metoda vraća mapu raspodjeljenu oviso da li student prošao predmet ili nije
	 * 
	 * @param records
	 *            - list of all students
	 * @return map studenata sortitanu je li student prošao ili ne
	 */
	private static Map<Boolean, List<StudentRecord>> razvrstajProlazPad(List<StudentRecord> records) {
		return records.stream().collect(Collectors.partitioningBy(e -> e.getGrade() > 1));
	}

	/**
	 * Metoda vraća Stringove iz txt datoteke u zapise studenata
	 * 
	 * @param lines
	 *            - kontekst txt datoteke
	 * @return lista {@link StudentRecord}
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
	 * Metoda vraća sumu bodova studenta
	 * 
	 * @param student
	 *            - student
	 * @return suma bodova
	 */
	private static double sumOf(StudentRecord student) {
		return student.getPointsLab() + student.getPointsMI() + student.getPointsZI();
	}

}
