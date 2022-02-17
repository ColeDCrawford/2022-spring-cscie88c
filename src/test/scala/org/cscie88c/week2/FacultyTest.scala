package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  "Faculty" when {
    "instantiated" should {
      "include name in the description string" in {
        val jinah: Faculty =
          new Faculty("Jinah Kim", "jinah@fas.harvard.edu", "ArtArch123")
        jinah.description contains "Jinah Kim"
      }
      "include email in the description string" in {
        val peter: Faculty =
          new Faculty("Peter Bol", "peter@fas.harvard.edu", "Chinese101")
        peter.description contains "peter@fas.harvard.edu"
      }
      "include courseId in the description string" in {
        val jon: Faculty =
          new Faculty("Jonathan Bobaljik", "jon@harvard.edu", "Russian221")
        jon.description contains "Russian221"
      }
    }
  }
}
