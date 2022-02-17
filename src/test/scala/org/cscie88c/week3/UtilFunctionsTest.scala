package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }
import ch.qos.logback.classic.pattern.Util

class UtilFunctionsTest extends StandardTest {
  "UtilFunctions" when {
    "with pythTriplesUpto100" should {
      "verify elements in list are pythagorean triples" in {
        val tripleOne = UtilFunctions.pythTriplesUpto100(0)
        val tripleTwo = UtilFunctions.pythTriplesUpto100(1)
        assert(UtilFunctions.pythTest(tripleOne._1, tripleOne._2, tripleOne._3))
        assert(UtilFunctions.pythTest(tripleTwo._1, tripleTwo._2, tripleTwo._3))
      }
    }
  }
}
