package io.scalac.beginners.json

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Properties}

/** This specification is invalid and works only as a demonstration. */
object JsStringSpec extends Properties("JsString") {
  implicit val jsString = Arbitrary(
    arbitrary[String].map(JsString)
  )

  property("toString") = forAll { (example: JsString) =>
    example.toString == '"' + example.value + '"'
  }
}
