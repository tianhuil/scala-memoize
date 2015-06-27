/**
	* Memoization based on https://michid.wordpress.com/2009/02/23/function_mem/
	*/

class Memoize1[-T, +R](f: T => R) extends (T => R) {
  import scala.collection.mutable
  private[this] val vals = mutable.Map.empty[T, R]

  def apply(x: T): R = {
  	vals.getOrElse(x, {
	      val y = f(x)
	      vals += (x -> y)
	      y
  		})
  }
}

object Memoize1 {
  def apply[T, R](f: T => R) = new Memoize1(f)

  def apply[T, R](f: (T, T => R) => R) = {
    var yf: T => R = null
    yf = new Memoize1(f(_, yf(_)))
    yf
  }
}

