package io.scalac.beginners.elections

import io.scalac.beginners.citizen.Sex
import io.scalac.beginners.elections.Candidate.MinAge
import io.scalac.beginners.json._


object Candidate {
  /** Constitution requires that candidate is at least 35 years old. */
  val MinAge = 35
}

case class Candidate(name: String, age: Int, sex: Sex) {
  require(MinAge >= 35, s"age has to be $MinAge or higher")

  def toJson = JsObject(
    JsString("name") -> JsString(name),
    JsString("age") -> JsNumber(age)
  )
}
