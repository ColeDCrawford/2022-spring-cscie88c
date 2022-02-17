package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Administrator below
class AdministratorTest extends StandardTest {
  "Administrator" when {
    "instantiated" should {
      "include name in the description string" in {
        val gretchen: Administrator =
          new Administrator("Gretchen", "gretchen@fas.harvard.edu", 32453789)
        val robin_kelsey: Administrator =
          new Administrator("Robin Kelsey", "robin@fas.harvard.edu", 32453789)
        (gretchen.description contains "Gretchen") && (robin_kelsey.description contains "Robin")
      }
      "include email in the description string" in {
        val gretchen: Administrator =
          new Administrator("Gretchen", "gretchen@fas.harvard.edu", 32453789)
        val robin_kelsey: Administrator =
          new Administrator("Robin Kelsey", "robin@fas.harvard.edu", 32453789)
        (robin_kelsey.description contains "robin@fas.harvard.edu") && (gretchen.description contains "gretchen@fas.harvard.edu")
      }
      "include budget in the description string" in {
        val alan: Administrator =
          new Administrator("Alan Wolf", "alan@harvard.edu", 4536781)
        val robin_kelsey: Administrator =
          new Administrator("Robin Kelsey", "robin@fas.harvard.edu", 32453789)
        (alan.description contains "4536781") && (robin_kelsey.description contains "32453789")
      }
    }
  }
}
