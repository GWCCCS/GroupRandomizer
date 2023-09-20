import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group {
    // Attributes
    private List<Student> members = new ArrayList<Student>();
    private Student scribe;

    // Methods

    // Adds a Student newMember to end of members<Student>
    public void addMember(Student newMember) {
        this.members.add(newMember);
    }

    // Picks a random Student in members<Student> to be scribe
    public void pickScribe()    {
        Random random = new Random();
        int num = random.nextInt(this.members.size());
        setScribe(this.members.get(num));
    }

    // Setters
    public void setMembers(List<Student> newMembers)    {
        this.members = newMembers;
    }
    public void setScribe(Student newScribe)    {
        this.scribe = newScribe;
    }

    // Getters
    public List<Student> getMembers()   {
        return this.members;
    }
    public Student getScribe()  {
        return this.scribe;
    }

}
