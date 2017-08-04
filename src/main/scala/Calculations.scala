object Calculations{
/**
  * Create a calculator to work with rational numbers.
  * Requirements:
  * ○ It should provide capability to add, subtract, divide and multiply rational numbers
  * ○ Create a method to compute GCD (this will come in handy during operations on rational)
  *
  * Add option to work with whole numbers which are also rational numbers i.e. (n/1)
  * - achieve the above using auxiliary constructors
  * - enable method overloading to enable each function to work with numbers and rational.
  */

  def main(args: Array[String]): Unit = {

    val calc: Calculator = new Calculator

    //Using calculator for whole number operations
    println( "5 + 6 = "+ calc.add(5,6) )

    println( "9 - 3 = "+ calc.sub(9,3) )

    println( "4 x 7 = "+ calc.prod(4,7) )

    println( "6 ÷ 3 = "+ calc.div(6,3) )

    /** Using calculator for rational number operations.
      * The functions return tuples. Therefore, to format them appropriately,
      * .productIterator takes every item and .toList groups them into a list
      * which allows formatting via .mkString
      */
    println( "2/4 + 1/6 = "+ calc.add((2,4),(1,6)).productIterator.toList.mkString("","/","") )

    println( "1/3 - 6/7 = "+ calc.sub((1,3),(6,7)).productIterator.toList.mkString("","/",""))

    println( "4/5 x 7/9 = "+ calc.prod((4,3),(7,9)).productIterator.toList.mkString("","/","") )

    println( "5/2 ÷ 8/7 = "+ calc.div((5,2),(8,7)).productIterator.toList.mkString("","/","") )
  }
}
