package transports

class Plane (var model: String){
  var flyingStatus = true

  def land(): Unit ={
    flyingStatus = false
  }
}
