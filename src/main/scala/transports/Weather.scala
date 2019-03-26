package transports

import scala.util.Random

class Weather {

  var possibleWeather = Array("Stormy", "Sunny", "Sunny")

  var currentWeather : String = {
    possibleWeather(Random.nextInt(possibleWeather.length))
  }
}
