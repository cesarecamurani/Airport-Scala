package transports

class Plane (var model: String){
  var flyingStatus = true

  def land(): Unit ={
    flyingStatus = false
  }

  def takeOff(): Unit ={
    if(flyingStatus equals true){
      throw new Error("Plane's already flying!")
    }
    flyingStatus = true
  }
}
