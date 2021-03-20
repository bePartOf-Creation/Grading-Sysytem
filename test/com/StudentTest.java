package com;

import com.enums.Department;
import com.enums.Gender;
import com.enums.Grade;
import com.exceptions.StudentIdentityException;
import com.exceptions.SubjectException;
import com.student.Student;
import com.student.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    Department department;
    Grade grade;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        student = new Student("Olasunkanmi", "Akin");
        department = Department.ART;
        department = Department.COMMERCIAL;
        department = Department.SCIENCE;
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @Test
    void testThatAStudentHasAFirstName() {
        student = new Student("Olasunkanmi", "Akin");
        String firstName = student.getFirstName();
        assertEquals("Olasunkanmi", firstName);
    }
    @Test
    void testThatAStudentEnterACorrectName() throws StudentIdentityException {
        student.setFirstName("Ola");
        assertThrows(StudentIdentityException.class, ()-> student.setFirstName(null));
        assertEquals("Ola", student.getFirstName());
    }

    @Test
    void testThatAStudentHasALateName() {
        student = new Student("Olasunkanmi", "Akin");
        String lastName = student.getLastName();
        assertEquals("Akin", lastName);
    }
    @Test
    void testThatAStudentEnterACorrectLastName() throws StudentIdentityException {
        student.setLastName("Akinola");
        assertThrows(StudentIdentityException.class, ()-> student.setLastName(null));
        assertEquals("Akinola", student.getLastName());
    }
    @Test
    void testThatStudentCanSelectGenderToMale() throws StudentIdentityException {
        student.selectYourGender("male");
        assertEquals(Gender.MALE, student.getGender());
        assertThrows(StudentIdentityException.class, ()-> student.setGender(null));
    }
    @Test
    void testThatStudentCanSelectGenderToFemale() throws StudentIdentityException {
        student.selectYourGender("female");
        assertEquals(Gender.FEMALE, student.getGender());
    }
    @Test
    void testThatStudentCanHaveSelectDepartment() throws StudentIdentityException {
        student.selectYourDepartment("Science");
        assertEquals(Department.SCIENCE, student.getDepartment());
        student.selectYourDepartment("Commercial");
        assertEquals(Department.COMMERCIAL, student.getDepartment());
        student.selectYourDepartment("Art");
        assertEquals(Department.ART, student.getDepartment());
        assertThrows(StudentIdentityException.class,()-> student.setDepartment(null));
    }
    @Test
    void testThatASubjectCanHaveGrades() throws SubjectException {
      Grade grade = Subject.estimateGrade(100.0);
      assertEquals(Grade.EXCELLENT,grade);
      grade = Subject.estimateGrade(75);
      assertEquals(Grade.VERY_GOOD,grade);
      grade = Subject.estimateGrade(74);
      assertEquals(Grade.CREDIT,grade);
      grade = Subject.estimateGrade(56);
      assertEquals(Grade.PASS,grade);
      grade = Subject.estimateGrade(0.5);
      assertEquals(Grade.FAIL,grade);
      assertThrows(SubjectException.class,()-> Subject.estimateGrade(-1));
    }
    @Test
    void testThatStudentCanAddSubjects() throws SubjectException {
        student = new Student("Olasunkanmi", "Akin");
        boolean result = student.addSubject(Subject.BIOLOGY);
        assertTrue(result);
        assertEquals(1,student.getSubjects().size());
        result = student.addSubject(Subject.CHEMISTRY);
        assertTrue(result);
        assertEquals(2,student.getSubjects().size());
        result = student.addSubject(Subject.ENGLISH);
        assertTrue(result);
        assertEquals(3,student.getSubjects().size());
        result = student.addSubject(Subject.FURTHER_MATHEMATICS);
        assertTrue(result);
        assertEquals(4,student.getSubjects().size());
        result = student.addSubject(Subject.GEOGRAPHY);
        assertTrue(result);
        assertEquals(5,student.getSubjects().size());
        result = student.addSubject(Subject.MATHEMATICS);
        assertTrue(result);
        assertEquals(6,student.getSubjects().size());
        result = student.addSubject(Subject.PHYSICS);
        assertTrue(result);
        assertEquals(7,student.getSubjects().size());
        result = student.addSubject(Subject.YORUBA);
        assertTrue(result);
        assertEquals(8,student.getSubjects().size());

        assertThrows(SubjectException.class, ()-> student.addSubject(null));
}
@Test
    void testThatStudentCanAddSScoresForAll() throws SubjectException {
        boolean result = student.addScoreAndSubject(Subject.BIOLOGY,98.5);
        assertEquals(1,student.getSubjects().size());
        assertTrue(result);
        result = student.addScoreAndSubject(Subject.GEOGRAPHY,98.5);
        assertEquals(2,student.getSubjects().size());
        assertTrue(result);
}
@Test
    void testThatStudentScoresAndSubjectCanBeGraded() throws SubjectException {
       student.addScoreAndSubject(Subject.BIOLOGY, 45.9);
       grade = student.gradeScores(Subject.BIOLOGY,45.9);
    try {
        assertEquals(Grade.PASS, Subject.estimateGrade(student.getSubjects().get(Subject.BIOLOGY)));
    } catch (SubjectException e) {
        e.printStackTrace();
    }
}

}

