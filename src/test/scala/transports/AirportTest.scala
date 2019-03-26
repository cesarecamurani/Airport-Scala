package transports

import org.scalatest._
import org.scalatest.Matchers._

import scala.collection.mutable.ListBuffer

class AirportTest extends FunSuite {

  var hangar = new ListBuffer[Plane]
  val boeing = new Plane("boeing")
  val gatwick = new Airport(hangar)

  def assert(assertion: Assertion): Any = 0

  test("Airport.permitLanding add a plane to the Hangar2") {
    gatwick.permitLanding(boeing)
    assert(gatwick.hangar should contain(boeing))
  }
}
