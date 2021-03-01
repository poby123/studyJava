package ch08;

import java.io.File;
import java.util.Scanner;

public class Ex04_finally {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			String title = scan.next();
			File f = createFile(title);
			System.out.println(f.getName() + " file is successfully created.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	public static File createFile(String filename) throws Exception {
		if (filename == null) {
			throw new Exception("The file name doesn't valid.");
		}
		File f = new File(filename);
		f.createNewFile();
		return f;
	}
}
