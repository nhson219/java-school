package listener;

import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.filechooser.FileNameExtensionFilter;

// csv
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// import object Score
import object.Score;

// import java hash map
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ShowImportFileScore implements ActionListener {

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

			String csvFile = files.getAbsolutePath();
			BufferedReader br = null;
			String line = "";
			String csvSplitBy = ",";
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Score.class).buildSessionFactory();

			// create a Session
			Session session = sessionFactory.openSession();
			
			try {
				br = new BufferedReader(new FileReader(csvFile));

				String headerLine = br.readLine();
				
				System.out.println(headerLine);
				
				Integer dem = 0;
				while ((line = br.readLine()) != null) {
					dem++;

					System.out.println(line);
					String[] tmp = line.split(csvSplitBy);
					
					if (dem == 1) {
						System.out.println("hello");
						continue;
					}

					// create the Score object
					Score score = new Score();
					score.insertScore(tmp[1], tmp[2], Float.parseFloat(tmp[3]), Float.parseFloat(tmp[4]), Float.parseFloat(tmp[5]), Float.parseFloat(tmp[6]));

					// start a transaction
					session.beginTransaction();

					// Save the Score object to the database
					session.save(score);

					System.out.println("Java object saved to the database");
					// commit the transaction
					session.getTransaction().commit();

				}

			} catch (FileNotFoundException exception) {
				exception.printStackTrace();
			} catch (IOException ioexception) {
				ioexception.printStackTrace();
			} finally {
				sessionFactory.close();
			}

		}
	}

}
