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

  test("Airport.permitLanding should throw an error if Hangar is full") {
    var a = 0;
    for( a <- 1 to gatwick.capacity){
      gatwick.permitLanding(boeing)
    }
    assertThrows[Error] { gatwick.permitLanding(boeing) }
  }

  test("Airport.permitTakeoff should throw an error if plane is not in Hangar") {
    gatwick.permitLanding(boeing)
    gatwick.permitTakeoff(boeing)
    assertThrows[Error] { gatwick.permitTakeoff(boeing) }
  }

  test("Airport.permitLanding should throw an error if plane is already in Hangar") {
    gatwick.permitLanding(boeing)
    assertThrows[Error] { gatwick.permitLanding(boeing) }
  }
}
