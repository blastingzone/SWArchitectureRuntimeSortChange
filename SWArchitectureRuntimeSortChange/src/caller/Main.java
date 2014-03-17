package caller;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import sortAlgorithms.Isort;
import config.XMLParser;

public class Main {
	
	static Isort iSort = null;
	
	static int test[] = {0, 10, 9, 25, 7, 6, 3, 8, 13, 15};
	
	public static void main(String[] args) {
		Serializer serializer = new Persister();
		File file = new File("Configuration.xml");
		
		try {
			XMLParser parser = serializer.read(XMLParser.class, file);
			String sortType = "sortAlgorithms." + parser.GetSortType();
			// print Sort Type
			System.out.println("Sort Type : " + sortType);
			// create sort by Configuration.xml
			iSort = (Isort) Class.forName( sortType ).newInstance();
		} catch (Exception e) {
			 System.err.println("Cannot Create Sort Class");
		}
		
		// before sorting
		System.out.println("Original Data");
		printDataArray(test);

		// do sorting
		int[] sortedData = iSort.sort(test);
		
		// after sorting
		System.out.println("Sorting Complete");
		printDataArray(sortedData);
	}
	
	private static void printDataArray(int[] data) {
		for (int iter : data) {
			System.out.printf("%d ", iter);
		}
		System.out.printf("\n");
	}
}
