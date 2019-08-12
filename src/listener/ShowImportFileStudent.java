package listener;

import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;

// csv
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// import object Student
import object.Student;

// import java hash map
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.*;
import java.util.*;

public class ShowImportFileStudent implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Please choose file");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		/// Users/sonnh/Documents/Java/BT1/BT1/src
		jfc.setCurrentDirectory(new File(
				System.getProperty("user.home") + System.getProperty("file.separator") + "Documents/Java/BT1/BT1/src"));

		FileNameExtensionFilter filter = new FileNameExtensionFilter("csv FILES", "csv");
		jfc.setFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			File files = jfc.getSelectedFile();

			System.out.println(files.getAbsolutePath());

			String csvFile = files.getAbsolutePath();
			BufferedReader br = null;
			String line = "";
			String csvSplitBy = ",";
			String[] arrStudent = new String[100];
			ArrayList<Object> arrListStudent = new ArrayList<>();
			try {
				br = new BufferedReader(new FileReader(csvFile));

				System.out.println(System.getProperty("user.dir") + "/src/data/student.txt");
				File file = new File(System.getProperty("user.dir") + "/src/data/student.txt");
				
				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/src/data/student.txt");

				String headerLine = br.readLine();
				System.out.println(headerLine);
				while ((line = br.readLine()) != null) {

					System.out.println(line);
					String[] tmp = line.split(csvSplitBy);

					Properties prop = new Properties();

					// set the properties value
					prop.setProperty(tmp[1] + ".name", tmp[2]);
					prop.setProperty(tmp[1] + ".sex", tmp[3]);
					prop.setProperty(tmp[1] + ".passport_id", tmp[4]);

					// save properties to project root folder
					prop.store(output, null);

					System.out.println(prop);

//			        oos.writeObject(map);

				}

			} catch (FileNotFoundException exception) {
				exception.printStackTrace();
			} catch (IOException ioexception) {
				ioexception.printStackTrace();
			}

		}
	}

}
