import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class {
    // Attributes
    private List<Student> allStudents;
    private List<Student> presentStudents;
    private List<Group> groups;

    // Methods

    // Checks every student in AllStudents<Student> and saves every attending student to presentStudents<Student>
    public void doAttendance() {
        List<Student> newPresentStudents = new ArrayList<>();

        for(int i = 0; i < this.allStudents.size(); i++)   {
            if(this.allStudents.get(i).getAttendance()) {
                newPresentStudents.add(this.allStudents.get(i));
            }
        }
        this.presentStudents = newPresentStudents;
    }

    // Splits presentStudents<Student> into groupNum number of groups
    public void createGroups(int groupNum) {
        List<Group> finalGroups = new ArrayList<Group>();
        int count = 0;
        int totalStudents = this.presentStudents.size();
        int groupSize = totalStudents / groupNum;


        List<Student> randomizedClass = this.presentStudents;
        Collections.shuffle(randomizedClass);

        for(int i = 0; i < groupNum; i++)  {
            Group newGroup = new Group();

            for(int j = 0; j < groupSize; j++)    {
                newGroup.addMember(randomizedClass.get(count));
                count++;
            }

            finalGroups.add(newGroup);
        }

        int leftovers = totalStudents - count;
        if (leftovers != 0)  {
            for(int i = 0; i < leftovers; i++)  {
                finalGroups.get(i).addMember(randomizedClass.get(count));
                count++;
            }
        }

        this.groups = finalGroups;
    }

    // Picks a random Student in each group in groups<Group> to be scribe
    public void pickScribes()   {
        for(int i = 0; i < this.groups.size(); i++)  {
            this.groups.get(i).pickScribe();
        }
    }

    // Prints the names of the scribes of each group in groups<Group>, if any
    public void printScribes()    {
        for(int i = 0; i < this.groups.size(); i++) {
            System.out.print(this.groups.get(i).getScribe().getName() + '\n');
        }
    }

    // Prints the names of every member of each group in groups<Group>, if any
    public void printGroups()   {
        for(int i = 0; i < this.groups.size(); i++) {
            for(int j = 0; j < this.groups.get(i).getMembers().size(); j++) {
                System.out.print(this.groups.get(i).getMembers().get(j).getName() + '\t');
            }
            System.out.print('\n');
        }
    }

    // Setters
    public void setAllStudents(List<Student> newAllStudents)    {
        this.allStudents = newAllStudents;
    }
    public void setPresentStudents(List<Student> newPresentStudents)    {
        this.presentStudents = newPresentStudents;
    }
    public void setGroups(List<Group> newGroups)    {
        this.groups = newGroups;
    }

    // Getters
    public List<Student> getAllStudents()   {
        return this.allStudents;
    }
    public List<Student> getPresentStudents()   {
        return this.presentStudents;
    }
    public List<Group> getGroups()   {
        return this.groups;
    }
}
