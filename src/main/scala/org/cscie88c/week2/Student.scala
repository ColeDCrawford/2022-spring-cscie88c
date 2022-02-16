package org.cscie88c.week2

import scala.io.Source

// complete the definition of the Student case class and companion object
final case class Student(
  val id: Int,
  val firstName: String,
  val lastName: String,
  val email: String,
  val gender: String,
  val country: String
)

object Student {
  
  val allStudents: List[Student] = readFile("data/student_data.csv")

  def apply(csvRow: String): Student = {
    val fields = csvRow.split(",")
    Student(
      id = fields(0).toInt,
      firstName = fields(1),
      lastName = fields(2),
      email = fields(3),
      gender = fields(4),
      country = fields(5)
    )
  }

  def readFile(fileName: String): List[Student] = {
    Source
      .fromResource(fileName)
      .getLines()
      .toList.tail
      .map(Student(_))
  }

  def fullName(student: Student): String = s"${student.firstName} ${student.lastName}"

  def studentNamesByCountry(country: String): List[String] = {
    Student.allStudents
      .filter(_.country == country)
      .map(fullName)
  }

  def studentTotalsByCountry(country: String): Int = {
    Student.allStudents
      .filter(_.country == country)
    val countryStudents = Student.allStudents.filter(_.country == country)
    countryStudents.size
  }

}