import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result_PangramsScala {

  /*
   * Complete the 'pangrams' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def pangrams_cfernandezcairo(s: String): String = {
    // Write your code here
    return "sss"
  }

}

object Solution_PangramsScala {
  def main(args: Array[String]) = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val result = Result_PangramsScala.pangrams_cfernandezcairo(s)

    printWriter.println(result)

    printWriter.close()
  }
}
