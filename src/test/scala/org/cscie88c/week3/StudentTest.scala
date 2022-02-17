package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }

class StudentTest extends StandardTest {
  "Student Management System" when {
    "creating a student" should {
      val coleEnglish: Student =
        new Student("Cole", "cole@fas.harvard.edu", "English", 98)
      val coleMath: Student =
        new Student("Cole", "cole@fas.harvard.edu", "Math", 87)
      val badStudent: Student =
        new Student("Bob", "emailnotvalid.com", "Math", 27)
      val emma: Student = new Student("Emma", "emma@harvard.edu", "English", 65)
      val emmaSci: Student =
        new Student("Emma", "emma@harvard.edu", "Science", 85)
      val studentList: List[Student] = List(
        coleEnglish,
        coleMath,
        badStudent,
        emma,
        emmaSci
      )

      "have properties - name, email, subject and score" in {
        assert(coleEnglish.name == "Cole")
        assert(coleEnglish.email == "cole@fas.harvard.edu")
        assert(coleEnglish.subject == "English")
        assert(coleEnglish.score == 98)
      }
      "student with valid email should validate" in {
        assert(Student.validateEmail(coleEnglish))
      }
      "student with invalid email should not validate" in {
        assert(!Student.validateEmail(badStudent))
      }
      "studentList should return correct average score by subject" in {
        assert(Student.averageScoreBySubject("English", studentList) == 81.5)
        assert(Student.averageScoreBySubject("Math", studentList) == 57)
        assert(Student.averageScoreBySubject("Science", studentList) == 85)
      }
      "studentList should return correct average score by student" in {
        assert(Student.averageScoreByStudent(coleMath, studentList) == 92.5)
        assert(Student.averageScoreByStudent(emma, studentList) == 75)
        assert(Student.averageScoreByStudent(badStudent, studentList) == 27)
      }
    }
  }

}
