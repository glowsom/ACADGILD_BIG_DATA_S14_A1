class Calculator () {
  /**
    * Create a calculator to work with rational numbers.
    * Requirements:
    * ○ It should provide capability to add, subtract, divide and multiply rational numbers
    *
    * Add option to work with whole numbers which are also rational numbers i.e. (n/1)
    * - achieve the above using auxiliary constructors???
    * ***AUXILIARY CONSTRUCTORS ARE IRRELEVANT. The Calculator class doesn't require params whatsoever
    * ***Only one instance of the class will be needed for all calculations.
    *
    */

  //Methods for whole numbers
  def add(x:Int, y:Int): Int = {    //returns the sum of params
    x+y
  }

  def sub(x:Int, y:Int): Int = {    //returns first param minus second param
    x-y
  }

  def prod(x:Int, y:Int): Int = {   //returns product of params
    x*y
  }

  def div(x:Int, y:Int): Int = {    //returns first param divided by second param
    x/y
  }


  /**
    * Overloaded methods to accommodate Rational numbers.
    * Every result is first simplified(refer to simplify function) before returned.
    */
  
  /**
    * The numerator of each param must be multiplied by the denominator of the other param
    * Add the new numerators together (1st + 2nd) as the final numerator.
    * Denominator is the product of the denominators of both params.
    */
  def add(x:(Int, Int), y:(Int, Int)): (Int, Int) = {
    simplify( (x._1*y._2)+(y._1*x._2) , x._2*y._2)
  }
  /**
    * The numerator of each param must be multiplied by the denominator of the other param
    * Subtract the new numerators (1st - 2nd) as the final numerator.
    * Denominator is the product of both denominators
    */
  def sub(x:(Int, Int), y:(Int, Int)):  (Int, Int) = {
    simplify( (x._1*y._2)-(y._1*x._2) , x._2*y._2)
  }
  //Multiply the numerators together as the final numerator, and do the same with denominator
  def prod(x:(Int, Int), y:(Int, Int)):  (Int, Int) = {
    simplify(x._1*y._1 , x._2*y._2)
  }

  /** Multiply the x numerator and y denominator together as the final numerator,
    * Multiply the x denominator and y numerator together as the final denominator.
    */
  def div(x:(Int, Int), y:(Int, Int)):  (Int, Int) = {
    simplify(x._1 * y._2, x._2 * y._1)
  }

  /**
    * Calculates the gcd of 2 numbers.
    * For the sake of optimization: the gcd can't be greater the the lesser number, so range of numbers
    * to be considered is from 1 to end, where end is (1 + lesser number) so as to include lesser number.
    * A list is created for each param which is filtered out of the range as follows: 
    * @param x    x%value == 0, includes all that are completely divisible by x. thus divisors of x is div1
    * @param y    y%value == 0, includes all that are completely divisible by y. thus divisors of y is div2
    * @return     maximum of all numbers that are present in both div1 and div2
    */
  def gcd(x:Int, y:Int): Int = {

    val end:Int = if (x < y) x+1 else y+1
    
    val div1 = List.range(1, end).filter(x%_==0)
    val div2 = List.range(1, end).filter(y%_==0)
    
    (for{
      n <- div2 if div1.contains(n)   //Yields every number in div2 which is present in div1 as a list
    } yield n).max                   //Maximum of this list is returned
  }

  /**
    * This simplifies the results of rational number functions to their simplest form.
    * @param x  represents the numerator
    * @param y  represents denominator
    * @return   Both numerator and denominator are divided by their gcd
    */
  def simplify (x:Int, y:Int): (Int, Int) = {

    val gcdValue:Int = gcd(Math.abs(x),Math.abs(y)) //Absolute values are passed in case any param is negative
    (x/gcdValue, y/gcdValue)
  }
  

}
