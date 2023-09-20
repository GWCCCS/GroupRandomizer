public class Student {

    // Attributes

    private boolean attendance;
    private String name;

    // Methods

    // Getters
    public String getName() {
        return this.name;
    }
    public boolean getAttendance() {
        return this.attendance;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAttendance(boolean newAttendance) {
        this.attendance =  newAttendance;
    }
}
