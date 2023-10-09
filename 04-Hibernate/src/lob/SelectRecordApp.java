package lob;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		int id = 1;
		JobSeeker seeker = null;
		FileOutputStream fos = null;
		FileWriter out =null;
		
		try {
			if (session != null)
				seeker = session.get(JobSeeker.class, id);

			if (seeker != null) {
				
				fos = new FileOutputStream("store/photo.jpg");
				fos.write(seeker.getPhoto());
				
				out = new FileWriter("store/resume.txt");
				out.write(seeker.getResume());
				
				fos.flush();
				out.flush();
				
				System.out.println("LOB's are retreived");
				System.out.println(seeker);
				
			} else {
				System.out.println("Employee record not found for the given id :: " + id);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
