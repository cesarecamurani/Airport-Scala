package transports

import org.scalatest._
import org.scalatest.Matchers._

class PlaneTest extends FunSuite {

  var airbus = new Plane("Airbus")

  def assert(assertion: Assertion): Any = 0

  test("Plane.land should change flying status to false ") {
    airbus.land()
    assert(airbus.flyingStatus should equal (false))
  }

  test("Plane.takeOff should change flying status to true again ") {
    airbus.takeOff()
    assert(airbus.flyingStatus should equal (true))
  }
}
