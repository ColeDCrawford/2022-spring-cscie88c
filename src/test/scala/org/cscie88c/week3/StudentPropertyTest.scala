package org.cscie88c.week3
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class StudentPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val studentGen: Gen[Student] = for {
    nameG <- Gen.alphaStr
    emailG <- Gen.alphaStr
    subjectG <- Gen.oneOf(List("English", "Math", "Science"))
    scoreG <- Gen.choose(0, 100)
  } yield Student(
    name = nameG,
    email = emailG,
    subject = subjectG,
    score = scoreG
  )

  // complete the student list generator below if attempting bonus problem
  val studentListGen: Gen[List[Student]] = Gen.listOf(studentGen)

  test("description contains name and email") {
    forAll(studentGen) { (s: Student) =>
      s.description should (include(s.name) and include(s.email))
    }
  }

  test("average score for math is <= 100"){
    forAll(studentListGen) { (l: List[Student]) =>
      // println(l)
      // println(Student.averageScoreBySubject("Math", l))
      assert(Student.averageScoreBySubject("Math", l) <= 100)
    }
  }
}
