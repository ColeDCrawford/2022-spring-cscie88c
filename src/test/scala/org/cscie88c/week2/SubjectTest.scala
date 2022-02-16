package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Subject below

class SubjectTest extends StandardTest {
  "Subject" when {
      "instantiated" should {
          "create Subject instance from a CSV string correctly" in {
            val sub = Subject("1,Physics,true")
            (sub.name == "Physics") && (sub.isSTEM == true)
          }
          "import CSV file" in {
              (Subject.allSubjects.size == 4) && (Subject.allSubjects(0).name == "Physics")
          }
      }
  }
}
