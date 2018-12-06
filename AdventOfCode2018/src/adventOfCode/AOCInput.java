package adventOfCode;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AOCInput {
	public static String[] read(String filename) {
		ArrayList<String> list = new ArrayList<String>();
		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
				BufferedReader dis = new BufferedReader(isr)) {
			String textRow = dis.readLine();
			while(textRow!=null) {
				list.add(textRow);
				textRow = dis.readLine();
			}
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		return list.toArray(new String[0]);
	}
}
