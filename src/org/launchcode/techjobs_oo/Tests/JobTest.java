package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class JobTest {
    Job job1, job2,job3;
    @Before
    public void createJob(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobID(){
            assertEquals(job1.getId() +1, job2.getId() );
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(job1.equals(job2));
    }
    @Test
    public void shouldReturnABlankLine(){

        String test1 = job1.toString();
       char char1 = test1.charAt(0);
       char char2 = test1.charAt(test1.length()-1);
       assertEquals(char1, '\n');
       assertEquals(char2, '\n');

    }
    @Test
    public void testFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String test3 = job3.toString();
        String test4 ='\n' +
                "ID: " + job3.getId() + '\n' +
                "Name: " + job3.getName() + '\n' +
                "Employer: " + job3.getEmployer() + '\n' +
                "Location: " + job3.getLocation() + '\n' +
                "Position Type: " + job3.getPositionType() + '\n' +
                "Core Competency: " + job3.getCoreCompetency() +'\n';
        assertEquals(test4,test3);
    }
    @Test
    public void testEmptyField() {
        Job job5 = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency("Persistence"));

        String job6 = job5.toString();

        String job7 = '\n' +
                "ID: " + job5.getId() + '\n' +
                "Name: " + job5.getName() + '\n' +
                "Employer: " + "Data not available" + '\n' +
                "Location: " + job5.getLocation().getValue() + '\n' +
                "Position Type: " + "Data not available" + '\n' +
                "Core Competency: " + job5.getCoreCompetency().getValue() + '\n';
        assertEquals(job7,job6);
    }
    @Test
    public void testIfOnlyId(){
        Job job8 = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));
        String job9 = job8.toString();

        String job10 = "\nOOPS! This job does not seem to exist.\n";
        assertEquals(job10,job9);
    }
}
