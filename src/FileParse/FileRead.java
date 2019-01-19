package FileParse;

import com.gg.Car;
import com.gg.Sort;
import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileRead {
	public static Car[] parse() {

		List<String[]> lines;
		try {
			
			CSVReader reader = new CSVReader(new FileReader("vehicles-sorted.csv"));
			lines = reader.readAll();

			Car[] data = new Car[lines.size()];
			reader.close();
			int counter = 0;
			for (String[] line : lines) {
				Car temp = new Car(line[63], line[47], line[46], line[65], line[57], line[4], line[34]);
				data[counter] = temp;
				counter++;
			}
			Sort.sortMerge(data);
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
