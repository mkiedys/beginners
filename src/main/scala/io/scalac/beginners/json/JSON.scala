package io.scalac.beginners

/** Yet Another JSON Library. */
package json {

sealed trait JsValue

case object JsNull extends JsValue

case class JsString(value: String) extends JsValue {
  /** This is broken and only for demonstration. */
  override def toString = '"' + value + '"'
}

case class JsBool(value: Boolean) extends JsValue

case class JsObject(values: (JsString, JsValue)*) extends JsValue

case class JsArray(elements: JsValue*) extends JsValue

case class JsNumber(value: BigDecimal) extends JsValue

}