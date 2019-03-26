package transports

class Plane (var model: String){
  var flyingStatus = true

  def land(): Unit ={
    flyingStatus = false
  }

  def takeOff(): Unit ={
    flyingStatus = true
  }
}
