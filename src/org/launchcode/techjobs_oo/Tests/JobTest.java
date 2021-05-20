package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

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
        Assert.assertEquals(3, job1.getId() + job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Assert.assertEquals("Product tester", job3.getName());
        Assert.assertEquals("ACME", job3.getEmployer().getValue());
        Assert.assertEquals("Desert", job3.getLocation().getValue());
        Assert.assertEquals("Quality control",job3.getPositionType().getValue());
        Assert.assertEquals("Persistence",job3.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality(){
        Job job4 = new Job(job1.getName(),
                job1.getEmployer(), job1.getLocation(),
                job1.getPositionType(),
                job1.getCoreCompetency());
        Job job5 = new Job(job1.getName(),
                job1.getEmployer(), job1.getLocation(),
                job1.getPositionType(),
                job1.getCoreCompetency());
        Assert.assertEquals(job4,job5);

    }



}
