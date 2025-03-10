package org.cscie88c.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
  ) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {

  def validateEmail(student: Student): Boolean =
    return student.email.contains("@")

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
    ): Double = {
    val scores = studentList
      .filter(_.subject == subject)
      .map(_.score)
    return scores.sum.toDouble / scores.length
  }

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
    ): Double = {
    val scores = studentList
      .filter(_.name == student.name)
      .map(_.score)
    return scores.sum.toDouble / scores.length
  }
}
