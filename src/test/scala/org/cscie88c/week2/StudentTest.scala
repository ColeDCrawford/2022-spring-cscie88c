package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Student below

class StudentTest extends StandardTest {
  "Student" when {
    "instantiated" should {
      "create student instance from a CSV string correctly" in {
        val s = Student("1, Cole, Crawford, cole@fas.harvard.edu, male, USA")
        s.firstName == "Cole"
      }
      "import CSV file" in {
        (Student.allStudents.size == 5) && (Student.allStudents(0).firstName == "Emmy")
      }
      "filter all students by country correctly" in {
        val chineseStudentTotal = Student.studentTotalsByCountry("China")
        val americanStudentTotal = Student.studentTotalsByCountry("United States")
        (chineseStudentTotal == 3) && (americanStudentTotal == 2)
      }
      "filter students by country and map to names" in {
        val chineseStudentNames = Student.studentNamesByCountry("China")
        val americanStudentNames = Student.studentNamesByCountry("United States")
        chineseStudentNames(0) contains "Emmy Conrart"
        americanStudentNames(0) contains "Marin Blasoni"
      }
    }
  }
}
