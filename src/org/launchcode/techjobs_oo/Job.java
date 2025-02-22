package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;


    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    @Override
    public String toString() {
        String showName;
        String showEmployer;
        String showLocation;
        String showPositionType;
        String showCoreCompetency;

        if(this.getEmployer() == null || this.getEmployer().getValue() == ""){
             showEmployer = "Data not available";
        } else {
            showEmployer = this.getEmployer().getValue();
        }

        if(this.getCoreCompetency() == null || this.getCoreCompetency().getValue() == ""){
            showCoreCompetency = "Data not available";
        }else {
            showCoreCompetency = this.getCoreCompetency().getValue();
        }

        if (this.getLocation() == null || this.getLocation().getValue() == "") {
            showLocation = "Data not available";
        } else {
            showLocation = this.getLocation().getValue();
        }

        if (this.getPositionType() == null || this.positionType.getValue() == "") {
            showPositionType = "Data not available";
        } else {
            showPositionType = this.getPositionType().getValue();
        }

        if (this.getName() == null ||this.getName() == "") {
            showName = "Data not available";
        } else {
            showName = this.getName();
        }

        if(this.getName() == "" && this.getEmployer().getValue() == "" &&
                this.getLocation().getValue() == "" && this.getPositionType().getValue() == ""
                && this.getCoreCompetency().getValue() == "") {
          return  "\nOOPS! This job does not seem to exist.\n";
        }

        String techjobs = '\n' +
                        "ID: " + this.getId() + '\n' +
                        "Name: " +  showName + '\n' +
                        "Employer: " + showEmployer + '\n' +
                        "Location: " + showLocation + '\n' +
                        "Position Type: " +  showPositionType + '\n' +
                        "Core Competency: " + showCoreCompetency  + '\n';
        return techjobs;
    }
}
