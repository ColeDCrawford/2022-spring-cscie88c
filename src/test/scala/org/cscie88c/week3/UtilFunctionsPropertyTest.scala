package org.cscie88c.week3

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._
import ch.qos.logback.classic.pattern.Util

class UtilFunctionsPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val triplesGen: Gen[(Int, Int, Int)] = Gen.oneOf(
    UtilFunctions.pythTriplesUpto100
  ) // Generate a random Pythogorean triple using values up to 100

  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }

  test("mult2 test distributive property") {
    // This version does 100 tests
    val distributiveProperty = Prop.forAll { (a: Int, b: Int, c: Int) =>
      UtilFunctions.mult2(a, (b + c)) == (UtilFunctions.mult2(
        a,
        b
      ) + UtilFunctions.mult2(a, c))
    }
    distributiveProperty.check()
  }

  test(
    "verify that if (x,y,z) is a Pythagorean triple that (y,x,z) is also a triple"
  ) {
    // this does 10 tests
    forAll(triplesGen) { (triple: (Int, Int, Int)) =>
      assert(UtilFunctions.pythTest(triple._1, triple._2, triple._3) == UtilFunctions
        .pythTest(triple._2, triple._1, triple._3))
    }
  }

  test(
      "verify that if (x,y,z) is a Pythagorean triple that (2x,2y,2z) is also a triple"
  ) {
    forAll(triplesGen) { (triple: (Int, Int, Int)) => 
      assert(UtilFunctions.pythTest(triple._1, triple._2, triple._3) == UtilFunctions.pythTest(triple._1 * 2, triple._2 * 2, triple._3 * 2))
    }
  }
}
