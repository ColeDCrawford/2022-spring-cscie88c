package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

class UtilFunctionsTest extends StandardTest {

  "UtilFunctions" when {
    "maximum" should {
      "return maximum of two ints when first integer is greater" in {
        UtilFunctions.maximum(2, 1) should be(2)
      }
      "return maximum of two ints when second integer is greater" in {
        UtilFunctions.maximum(1, 2) should be(2)
      }
      "return one of the two ints when they are equal" in {
        UtilFunctions.maximum(1, 1) should be(1)
      }
    }

    // add unit tests for average below
    "average" should {
      "return average of two ints as double" in {
        UtilFunctions.average(3, 4) should be(3.5)
      }
      "return average of two ints when one is zero" in {
        UtilFunctions.average(0, 4) should be(2.0)
      }
      "return zero when both inputs are zero" in {
        UtilFunctions.average(0, 0) should be(0.0)
      }
      "return average of two ints when one is negative" in {
        UtilFunctions.average(-2, 3) should be(0.5)
      }
      "return average of two ints when both are negative" in {
        UtilFunctions.average(-2, -3) should be(-2.5)
      }
    }

  }
}
