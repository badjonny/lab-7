import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListAddressBookTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void aRemoveEntry(){
		AddressBook dir = new ArrayListAddressBook();
		dir.put("Jonathan", "Phone", "119");
		dir.remove("Keshav", "Phone");
		assertNull(dir.get("Keshav", "Phone"));
	}
	/* public void anEmptyDirectoryHasNoFred() 
	 {
	     AddressBook dir = new ArrayListAddressBook();
	     assertNull(dir.get("Fred", "Phone"));
	 } */

}
