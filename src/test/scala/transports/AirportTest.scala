package transports

import org.scalatest._
import org.scalatest.Matchers._

import scala.collection.mutable.ListBuffer

class AirportTest extends FunSuite {

  var hangar = new ListBuffer[Plane]
  var boeing = new Plane("boeing")
  var gatwick = new Airport(hangar)

  def assert(assertion: Assertion): Any = 0

  test("Airport.permitLanding add a plane to the Hangar") {
    gatwick.permitLanding(boeing)
    assert(gatwick.hangar should contain(boeing))
  }

  test("Airport.permitTakeoff remove a plane from the Hangar") {
    gatwick.permitTakeoff(boeing)
    assert(gatwick.hangar shouldNot contain(boeing))
  }
}
