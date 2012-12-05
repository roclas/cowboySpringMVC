import static org.junit.Assert.*;

import org.junit.Test;


public class GereralTests{

	@Test
	public void testUriStrings() {
		boolean a = "asdfasdfasd/admin/asdfadsf".matches("admin");
		boolean b ="/cowboySpringMVC/w/admin/home".matches(".*/admin/.*");
		System.out.println(a);
		System.out.println(b);
		assertTrue(b);
		assertFalse(a);
	}

}
