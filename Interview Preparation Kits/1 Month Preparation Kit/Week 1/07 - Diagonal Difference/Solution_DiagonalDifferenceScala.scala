import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import scala.collection.immutable.*
import scala.collection.mutable.*
import scala.collection.concurrent.*
import scala.concurrent.*
import scala.io.*
import scala.language.postfixOps
import scala.math.*
import scala.sys.*
import scala.util.matching.*
import scala.reflect.*

object Result {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  def diagonalDifference_cfernandezcairo(arr: Array[Array[Int]]): Int = {
    // Write your code here

    var sumD: Int = 0
    var sumAd: Int = 0
    var n: Int = arr.length

    Range(0, n) foreach (i => {
      sumD = sumD + arr(i)(i)
      sumAd = sumAd + arr(i)((n - 1) - i)
    })

    Math.abs(sumD - sumAd)
  }


}

object Solution_DiagonalDifferenceScala {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.diagonalDifference_cfernandezcairo(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
