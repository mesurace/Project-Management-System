/**
 * DAO application for a website to register volunteering projects and recruit
 * for volunteers
 */
package com.ea.project.DAO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ea.project.model.Beneficiary;
import com.ea.project.model.Project;
import com.ea.project.model.Resource;
import com.ea.project.model.Status;
import com.ea.project.model.Task;
import com.ea.project.model.Volunteer;

/**
 * @author sureshadhikari
 *
 */

public class AppDAO {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("eaProject");
			em = emf.createEntityManager();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static void createProject() {

		EntityTransaction et = em.getTransaction();
		try {

			Beneficiary beneficiary1 = new Beneficiary();
			beneficiary1.setBeneficiaryId(0);
			beneficiary1.setName("Software company");
			beneficiary1.setDescription("They will use this product ");
			beneficiary1.setInfo(loadImage("beneficiary.jpg"));

			Resource resource1 = new Resource();
			resource1.setResourceId(0);
			resource1.setName("lecture slides");
			resource1.setDescription("lecture slides are available on sakai");

			Volunteer volunteer1 = new Volunteer();
			volunteer1.setVolunteerId(0);
			volunteer1.setName("Suresh");

			Task task1 = new Task();
			task1.setTaskId(0);
			task1.setName("Task 1");
			task1.setDescription("understand and run all demo codes");
			task1.setStartDate(new SimpleDateFormat("yyyy-mm-dd").parse("2016-11-10"));
			task1.setEndDate(new SimpleDateFormat("yyyy-mm-dd").parse("2016-12-10"));
			task1.getResources().add(resource1);
			task1.getVolunteers().add(volunteer1);
			task1.setStatus(Status.STARTED);

			Project project = new Project();
			project.setProjectId(0);
			project.setTitle("Project Management System");
			project.setDescription(
					"This is a project to create a database and the data access objects (DAOs) for a website to register volunteering projects and recruit for volunteers.");
			project.setLocation("FairField");
			project.setStartDate(new Date("2016/11/06 00:00:00"));
			project.setEndDate(new Date("2016/12/06 00:00:00"));
			project.getTasks().add(task1);
			project.getBeneficiaries().add(beneficiary1);
			project.setStatus(Status.STARTED);
			project.setDescriptionImage(loadImage("pms.png"));

			et.begin();

			em.persist(resource1);

			et.commit();

			et.begin();
			em.persist(beneficiary1);

			et.commit();

			et.begin();

			em.persist(volunteer1);

			et.commit();

			et.begin();
			em.persist(task1);

			et.commit();
			et.begin();
			em.persist(project);

			et.commit();

			allProjects();
			allTask();
			projectsByStatus(Status.STARTED);
			projectsByKeyWords("Fair");
			projectsOrderByDate();
			tasksOrderByDate();

		} catch (Throwable e) {
			if ((et != null) && (et.isActive()))
				et.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

	private static byte[] loadImage(String filename) {
		Path p = FileSystems.getDefault().getPath(filename);
		byte[] fileData = null;
		try {
			fileData = Files.readAllBytes(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileData;
	}

	// list of all projects
	public static void allProjects() {

		Query query = em.createQuery("select p from Project p ");

		List<Project> projects = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Project project : projects) {
			System.out.println("List of Projects :\n\n" + project);

		}
		System.out.println("\n--------------------------------------------\n");

	}

	// list of tasks
	public static void allTask() {

		Query query = em.createQuery("select t from Task t");

		List<Task> tasks = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Task task : tasks) {
			System.out.println("List of Tasks :\n\n" + task);

		}
		System.out.println("\n--------------------------------------------\n");
	}

	// list of project by Status
	public static void projectsByStatus(Status s) {

		Query query = em.createQuery("select p from Project p where p.status= :status");
		query.setParameter("status", s);
		List<Project> projects = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Project project : projects) {
			System.out.println("List of " + s + " Projects :\n\n" + project);

		}
		System.out.println("\n--------------------------------------------\n");
	}

	// list of project by search key and location
	public static void projectsByKeyWords(String s) {

		Query query = em.createQuery("select p from Project p where p.title like :title or p.location like :location");
		query.setParameter("title", "%" + s + "%");
		query.setParameter("location", "%" + s + "%");
		List<Project> projects = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Project project : projects) {
			System.out.println("Search Result :\n\n" + project);

		}
		System.out.println("\n--------------------------------------------\n");
	}

	// list of project by order by time
	public static void projectsOrderByDate() {

		Query query = em.createQuery("select p from Project p order by p.startDate");

		List<Project> projects = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Project project : projects) {
			System.out.println("List of Projects Order By Date:\n\n" + project);

		}
		System.out.println("\n--------------------------------------------\n");
	}

	// list of tasks order by date
	public static void tasksOrderByDate() {

		Query query = em.createQuery("select t from Task t order by t.startDate");

		List<Task> tasks = query.getResultList();
		System.out.println("\n--------------------------------------------\n");
		for (Task task : tasks) {
			System.out.println("List of Tasks order by Date:\n\n" + task);

		}
		System.out.println("\n--------------------------------------------\n");
	}

}
