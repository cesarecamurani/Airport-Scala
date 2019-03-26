package transports

import org.scalatest._
import org.scalatest.Matchers._

import scala.collection.mutable.ListBuffer

class AirportSpec extends FlatSpec {

  var hangar = new ListBuffer[Plane]
  var boeing = new Plane()
  var airport = new Airport()
  var today = new Weather()

  def assert(assertion: Assertion): Any = 0

  it should "Airport.setCapacity change the hangar capacity" in {
    airport.setCapacity(15)
    assert(airport.hangarCapacity equals 15)
  }

  it should "Airport.permitLanding add a plane to the Hangar" in {
    today.currentWeather = "Sunny"
    airport.permitLanding(boeing, today)
    assert(airport.hangar should contain(boeing))
  }

  it should "Airport.permitTakeoff remove a plane from the Hangar" in {
    today.currentWeather = "Sunny"
    airport.permitTakeoff(boeing, today)
    assert(airport.hangar shouldNot contain(boeing))
  }

  it should "Airport.permitLanding should throw an error if Hangar is full" in {
    today.currentWeather = "Sunny"
    var a = 0;
    for( a <- 1 to airport.hangarCapacity){
      airport.permitLanding(new Plane(), today)
    }
    assertThrows[Error] { airport.permitLanding(boeing, today) }
  }

  it should "Airport.permitTakeoff should throw an error if plane is not in Hangar" in {
    today.currentWeather = "Sunny"
    airport.setCapacity(20)
    airport.permitLanding(boeing, today)
    airport.permitTakeoff(boeing, today)
    assertThrows[Error] { airport.permitTakeoff(boeing, today) }
  }

  it should "Airport.permitLanding should throw an error if plane is already in Hangar" in {
    today.currentWeather = "Sunny"
    airport.permitLanding(boeing, today)
    assertThrows[Error] { airport.permitLanding(boeing, today) }
  }

  it should "Airport.permitLanding should throw an error if weather is Stormy" in {
    today.currentWeather = "Stormy"
    assertThrows[Error] { airport.permitLanding(boeing, today) }
  }

  it should "Airport.permitTakeoff should throw an error if weather is Stormy" in {
    today.currentWeather = "Stormy"
    assertThrows[Error] { airport.permitTakeoff(boeing, today) }
  }
}
