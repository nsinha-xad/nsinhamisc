package com.nsinha.impls.CSV

import java.io.File

import com.nsinha.utils.Loggable
import main.scala.com.nsinha.data.CSV.CsvRow
import main.scala.com.nsinha.data.CSV.generated.GenCsvRows
import main.scala.com.nsinha.impls.CSV.CsvImplVer1
import org.scalatest.{FunSuite, ShouldMatchers}
import scaldi.Injectable

class CsvImplVer1Test extends FunSuite with  ShouldMatchers with Injectable with Loggable {

  test("test1") {
    val csvImpl = new CsvImplVer1(modelFilePath = "/Users/nishchaysinha/nsinhamisc/stocks/src/test/resources/modelforcsv.txt", csvFilePath = "/Users/nishchaysinha/nsinhamisc/stocks/src/test/resources/05302016T12:44:00.csv", classzz = GenCsvRows.getClass)
    val topFlowers = csvImpl.writeTopFlowers(10)
    logger.info(topFlowers.toString())
  }


}
