package sotf

import org.scalatest.funsuite.AnyFunSuite
import scodec._
import scodec.bits._
import scodec.codecs._

import java.io.{FileInputStream, InputStream}

class ReadTest extends AnyFunSuite {
  case class TableHeader(version: Long, numTables: Int, searchRange: Int, entrySelector: Int, rangeShift: Int)

  test("read test") {
    val in: InputStream          = new FileInputStream("src/test/resources/d2coding.ttf")
    val bits: BitVector          = BitVector.fromInputStream(in)
    val head: Codec[TableHeader] = (uint32 :: uint16 :: uint16 :: uint16 :: uint16).as[TableHeader]
    head.decode(bits).map { h =>
      println(h.value)
      assert(h.value.version == 0x00010000)
    }
    in.close()
  }
}
