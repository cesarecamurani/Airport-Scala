package transports

import org.scalatest._
import org.scalatest.Matchers._

class PlaneSpec extends FlatSpec {

  var airbus = new Plane()

  def assert(assertion: Assertion): Any = 0

  it should "Plane.land should change flying status to false" in {
    airbus.land()
    assert(airbus.flyingStatus should equal (false))
  }

  it should "Plane.takeOff should change flying status to true again" in {
    airbus.takeOff()
    assert(airbus.flyingStatus should equal (true))
  }

  it should "Plane.takeOff should throw an error if plane not in hangar" in {
    airbus.land()
    airbus.takeOff()
    assertThrows[Error] { airbus.takeOff() }
  }
}
