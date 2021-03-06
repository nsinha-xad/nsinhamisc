package main.scala.com.nsinha.data.Csv.generated

import com.nsinha.data.Csv.{CsvQuoteRow, Percent, Price, Volume}

case class GenCsvQuoteRowScottrade(datetimeStart : Long, datetimeEnd : Long, symbol : String, prevprice : Price, endprice : Price, startprice : Price, highprice : Price, lowprice : Price, volume : Volume, companyname : String, percentagechange : Percent) extends CsvQuoteRow() {
  override def getKey() : String = symbol
}

object GenCsvQuoteRowScottrade {
  def sort[A <: CsvQuoteRow, B <: CsvQuoteRow](by : String, asc : Boolean) : Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] = {
    val fn : Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] =
      (by, asc) match {
        case ("volume", true) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if (x.volume >= y.volume) true else false
          }
        }
        case ("volume", false) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if (x.volume <= y.volume) true else false
          }
        }
        case ("percent", true) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if (x.percentagechange >= y.percentagechange) true else false
          }
        }
        case ("percent", false) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if (x.percentagechange <= y.percentagechange) true else false
          }
        }
        case ("flow", true) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if ((x.percentagechange.value * x.volume.value) >= (y.percentagechange.value * y.volume.value)) true else false
          }
        }
        case ("flow", false) ⇒ new Function2[GenCsvQuoteRowScottrade, GenCsvQuoteRowScottrade, Boolean] {
          override def apply(x : GenCsvQuoteRowScottrade, y : GenCsvQuoteRowScottrade) : Boolean = {
            if ((x.percentagechange.value * x.volume.value) <= (y.percentagechange.value * y.volume.value)) true else false
          }
        }
      }
    fn

  }

  def normalizePrice(tobeNormalized : Price, normal : Price) : Price = {
    if (normal.value == 0) return Price(0)
    Price(tobeNormalized.value / normal.value)
  }

  def normalizeVolume(tobeNormalized : Volume, normal : Volume) : Volume = {
    if (normal.value == 0) return Volume(0)
    Volume(tobeNormalized.value / normal.value)
  }

  def normalize(tobeNormalized : GenCsvQuoteRowScottrade, normalElem : GenCsvQuoteRowScottrade) : GenCsvQuoteRowScottrade = {
    tobeNormalized.copy(
      prevprice = normalizePrice(tobeNormalized.prevprice, normalElem.endprice),
      endprice = normalizePrice(tobeNormalized.endprice, normalElem.endprice),
      startprice = normalizePrice(tobeNormalized.startprice, normalElem.endprice),
      highprice = normalizePrice(tobeNormalized.highprice, normalElem.endprice),
      lowprice = normalizePrice(tobeNormalized.lowprice, normalElem.endprice),
      volume = normalizeVolume(tobeNormalized.volume, normalElem.volume)
    )
  }
}

