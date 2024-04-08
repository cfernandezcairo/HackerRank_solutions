import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.{Stream, *}
import scala.collection.immutable.*
import scala.collection.mutable.*
import scala.collection.concurrent.*
import scala.collection.immutable
import scala.concurrent.*
import scala.io.*
import scala.math.*
import scala.sys.*
import scala.util.matching.*
import scala.reflect.*

object Result_CountingSort1Scala {

  /*
   * Complete the 'countingSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def countingSort_cfernandezcairo(arr: Array[Int]): Array[Int] = {
    // Write your code here
    val result = Array.fill(100)(0)
    arr.foreach(i => result(i) = result(i) + 1)
    result
  }

  def countingSort_michaelmaysonet1(arr: Array[Int]): Array[Int] = {
    val l = Array.fill(100)(0)
    arr.groupBy(identity).toList.foreach {
      n => l(n._1) += n._2.length
    }
    return l
  }

}

object Solution_CountingSort1Scala {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result_CountingSort1Scala.countingSort_cfernandezcairo(arr)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}