import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rxp8385.designpatterns.singleton.model.DAOFactory;
import com.rxp8385.designpatterns.singleton.model.Database;
import com.rxp8385.designpatterns.singleton.model.Person;
import com.rxp8385.designpatterns.singleton.model.PersonDAO;

public class PersonDAOTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setting stuff up before class");
		
		Database.getInstance().connect();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearing stuff down after class");
		
		Database.getInstance().disconnect();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println(" setUp method running");
		
		//ensures database is in a known state prior to each test...
		PersonDAO dao = DAOFactory.getPersonDAO();
		
		dao.deleteAll();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down"); 
	}

	/*@Test
	public void test() {
		//fail("Not yet implemented");
	}*/
	
	@Test
	public void testCreateDatabase() throws SQLException {
		PersonDAO dao = DAOFactory.getPersonDAO();
		System.out.println("testCreateDatabase method running");
		
		Person person1 = new Person("James", "goodtimes");
		Person person2 = new Person("ReRun", "candance");
		
		dao.addPerson(person1);
		dao.addPerson(person2);
		List<Person> people = dao.getPeople();
		/**
		 *assertEquals uses .equals() method, so the method and 
		 *the HashCode() method must be overridden in the Person class
		 */
		assertEquals("Should be two people in database.", 2, people.size());
		assertEquals("These two people must be the same.", person1, people.get(0));
		assertEquals("These two people must be the same.", person2, people.get(1));
		
	}

}
