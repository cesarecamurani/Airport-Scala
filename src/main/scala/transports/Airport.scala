package transports

import scala.collection.mutable.ListBuffer

class Airport(var hangar:ListBuffer[Plane]) {

  def permitLanding(plane: Plane): Unit ={
    hangar += plane
  }
}
