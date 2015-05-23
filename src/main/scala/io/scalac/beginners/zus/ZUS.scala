package io.scalac.beginners.zus

import io.scalac.beginners.citizen.{Female, Male}
import io.scalac.beginners.elections.Candidate


trait Bankrupt {
  val liabilitiesGreaterThanAssets = true
}

object ZUS extends Bankrupt {
  def mayRetire(candidate: Candidate): Boolean = candidate match {
    case Candidate(_, age, Male)   if age >= 65 => true
    case Candidate(_, age, Female) if age >= 60 => true
    case _ => false
  }
}
