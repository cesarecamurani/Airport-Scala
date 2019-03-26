package transports

import org.scalatest._
import org.scalatest.Matchers._

import scala.collection.mutable.ListBuffer

class AirportSpec extends FlatSpec with BeforeAndAfter {

  var hangar = new ListBuffer[Plane]
  var boeing = new Plane()
  var gatwick = new Airport(hangar)

  def assert(assertion: Assertion): Any = 0

  it should "Airport.setCapacity change the hangar capacity" in {
    gatwick.setCapacity(15)
    assert(gatwick.hangarCapacity equals 15)
  }

  it should "Airport.permitLanding add a plane to the Hangar" in {
    gatwick.permitLanding(boeing)
    assert(gatwick.hangar should contain(boeing))
  }

  it should "Airport.permitTakeoff remove a plane from the Hangar" in {
    gatwick.permitTakeoff(boeing)
    assert(gatwick.hangar shouldNot contain(boeing))
  }

  it should "Airport.permitLanding should throw an error if Hangar is full" in {
    var a = 0;
    for( a <- 1 to gatwick.hangarCapacity){
      gatwick.permitLanding(new Plane())
    }
    assertThrows[Error] { gatwick.permitLanding(boeing) }
  }

  it should "Airport.permitTakeoff should throw an error if plane is not in Hangar" in {
    gatwick.setCapacity(20)
    gatwick.permitLanding(boeing)
    gatwick.permitTakeoff(boeing)
    assertThrows[Error] { gatwick.permitTakeoff(boeing) }
  }

  it should "Airport.permitLanding should throw an error if plane is already in Hangar" in {
    gatwick.permitLanding(boeing)
    assertThrows[Error] { gatwick.permitLanding(boeing) }
  }
}
