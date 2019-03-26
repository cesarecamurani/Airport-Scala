package transports

import scala.collection.mutable.ListBuffer

class Airport(var hangar:ListBuffer[Plane]) {

  val capacity = 10

  def permitLanding(plane: Plane): Unit ={
    if(hangar contains plane) {
      throw new Error("Plane has already landed!");
    }
    if(hangar.length >= capacity) {
      throw new Error("Hangar is full!")
    }
    hangar += plane
  }

  def permitTakeoff(plane: Plane): Unit ={
    if(!(hangar contains plane)) {
      throw new Error("Plane not in hangar!")
    }
    hangar -= plane
  }
}
