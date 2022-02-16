package org.cscie88c.week2

import scala.io.Source

// complete the definition of the Subject case class and companion object
final case class Subject(
  id : Int,
  name : String,
  isSTEM: Boolean
)

object Subject {
  val allSubjects: List[Subject] = readFile("data/subject_data.csv")

  def stemSubjects: List[Subject] = {
    allSubjects.filter(_.isSTEM == true)
  }

  def apply(csvRow: String): Subject = {
    val fields = csvRow.split(",")
    Subject(
      id = fields(0).toInt,
      name = fields(1),
      isSTEM = fields(2).toBoolean,
    )
  }

  def readFile(fileName: String): List[Subject] =
    Source
      .fromResource(fileName)
      .getLines()
      .toList.tail
      .map(Subject(_))
  
}