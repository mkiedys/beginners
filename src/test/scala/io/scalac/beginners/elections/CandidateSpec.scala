package io.scalac.beginners.elections

import io.scalac.beginners.citizen.{Female, Male, Sex}
import io.scalac.beginners.json._
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Properties}


object CandidateSpec extends Properties("Candidate") {
  implicit val sex = Arbitrary[Sex](
    Gen.oneOf(Male, Female)
  )

  implicit val candidate = Arbitrary(
    for {
      name <- arbitrary[String]
      age  <- arbitrary[Int] suchThat (_ >= Candidate.MinAge)
      sex  <- arbitrary[Sex]
    } yield Candidate(name, age, sex)
  )

  property("toJson") = forAll { (candidate: Candidate) =>
    candidate.toJson == JsObject(
      JsString("name") -> JsString(candidate.name),
      JsString("age")  -> JsNumber(candidate.age)
    )
  }
}