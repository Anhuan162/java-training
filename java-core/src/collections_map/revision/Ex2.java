package collections_map.revision;

import java.security.SecureRandom;
import java.util.*;

class Student {
    private String student_code;
    private String name;

    public Student(String student_code, String name) {
        this.student_code = student_code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }
}

public class Ex2 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();
    private static final int size = 10000;
    private static List<Student> students = new ArrayList<>();

    private static String generate(int lengh) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengh; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    private static List<Student> getStudents(List<String> ids) {
        Map<String, Student> map = new HashMap<>();
        for (Student student : students) {
            map.put(student.getStudent_code(), student);
        }

        return ids.stream().map(i -> Objects.nonNull(map.get(i)) ? map.get(i) : null).filter(m -> Objects.nonNull(m)).toList();
    }

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            students.add(new Student(generate(16), "student" + i));
        }

        List<String> ids = new ArrayList<>();
        for (int i=0; i<5; i++) {
            ids.add(generate(i));
        }
        List<Student> res = getStudents(ids);
        for (Student student : res) {
            System.out.println(student.getStudent_code() + " " + student.getName());
        }
    }
}
