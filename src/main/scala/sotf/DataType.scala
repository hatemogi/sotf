package sotf

object DataType {
  type UInt32 = Long
  type UInt16 = Int
  case class ShortFrac(value: Short)

  val tags = List("cmap", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "name", "post")
}
