package sotf

import sotf.DataType.{UInt16, UInt32}

class FontDirectory(tag: UInt32, checksum: UInt32, offset: UInt32, length: UInt32) {}

object FontDirectory {
  class OffsetSubtable(
      scalerType: UInt32,
      numTables: UInt16,
      searchRange: UInt16,
      entrySelector: UInt16,
      rangeShift: UInt16
  )

  sealed trait ScalerType
  case object ScalerTrue extends ScalerType // (0x74727565) and 0x00010000 are recognized by OS X and iOS
  case object ScalerTyp1
      extends ScalerType // (0x74797031) is recognized as referring to the old style of PostScript font
  case object ScalerOtto extends ScalerType // (0x4F54544F) indicates an OpenType font with PostScript outlines

  class TableDirectory
}
