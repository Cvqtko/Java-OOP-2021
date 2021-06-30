package ex_03;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem()
    {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.studentsByName;
    }

    public void parseCommand(String[] args)
    {

        if (args[0].equals("Create"))
        {
            var name = args[1];
            var age = Integer.parseInt(args[2]);
            var grade =Double.parseDouble(args[3]);
            if (!studentsByName.containsKey(name))
            {
                var student = new Student(name, age, grade);
                studentsByName.put(name,student);
            }
        }
        else if (args[0].equals("Show"))
        {
            var name = args[1];
            if (studentsByName.containsKey(name))
            {
                var student = studentsByName.get(name);
                String view = String.format("%s is %s years old.",student.getName(),student.getAge());

                if (student.getGrade() >= 5.00)
                {
                    view += " Excellent student.";
                }
                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
                {
                    view += " Average student.";
                }
                else
                {
                    view += " Very nice person.";
                }

                System.out.println(view);
            }
        }
    }
}
