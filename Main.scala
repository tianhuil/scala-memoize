object Main {
  def main(args: Array[String]) {
		def facRec(n: BigInt, f: BigInt => BigInt): BigInt = {
		  if (n == 0) 1
		  else n*f(n - 1)
		}
    val fac = Memoize1(facRec _)

		for (k <- 0 to 100 by 10) { println(f"${ fac(k).toDouble }%.2e") }
  }
}
