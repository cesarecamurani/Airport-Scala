package transports

import scala.collection.mutable.ListBuffer
import scala.util.control._

class Airport(var hangar:ListBuffer[Plane]) {

  var hangarCapacity = 10

  def setCapacity(capacity: Int): Unit ={
    hangarCapacity = capacity
  }

  def permitLanding(plane: Plane): Unit ={
    if(hangar contains plane) {
      throw new Error("Plane has already landed!")
    }
    if(hangar.length.>=(hangarCapacity)) {
      throw new Error("Hangar is full!")
    }
    hangar += plane
  }
  @throws[Error]("if the file doesn't exist")
  def permitTakeoff(plane: Plane): Unit ={
    if(!(hangar contains plane)) {
      throw new Error("Plane not in hangar!")
    }
    hangar -= plane
  }
}
