package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for University employee below
class UniversityEmployeeTest extends StandardTest {
  "UniversityEmployee" when {
    "instantiated" should {
      "have a name property" in {
        true shouldBe true
      }
      "description method should contain name" in {
        // true shouldBe true
        val cole : UniversityEmployee = new UniversityEmployee("Cole", "cole_crawford@fas.harvard.edu")
        val fred : UniversityEmployee = new UniversityEmployee("Fred", "fred@gmail.com")
        (cole.description contains "Cole") && (fred.description contains "Fred")
      }
      "description method should include email" in {
        // true shouldBe true
        val cole : UniversityEmployee = new UniversityEmployee("Cole", "cole_crawford@fas.harvard.edu")
        val fred : UniversityEmployee = new UniversityEmployee("Fred", "fred@gmail.com")
        (cole.description contains "cole_crawford@fas.harvard.edu") && (fred.description contains "fred@gmail.com")
      }
    }
  }
}
