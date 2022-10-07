package be.abis.unittesting;

import be.abis.courseadmin.admin.Person;
import be.abis.courseadmin.enumm.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    public void setPerson() {
        person = new Person("Elon", "Musk", Gender.MALE);
    }

    @AfterEach
    public void tearDown() {
        person = null;
    }

    @Test
    public void testAddHobby() {
        person.addHobby("chess");
        assertEquals("chess", (person.getHobbies()));
    }

/*    @Test
    public void testAddHobbies() {
        person.addHobbies("chess", "tennis", "metal");
    //    assertThat();
      assertEquals(new String[]{"chess", "tennis", "metal"}, person.getHobbies());
    }
    */
}