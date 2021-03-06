import scala.quoted._
import scala.quoted.staging._
import scala.reflect.ClassTag

object Test {
  given Toolbox = Toolbox.make(this.getClass.getClassLoader)
  def main(args: Array[String]): Unit = withQuoteContext {
    val '[List[Int]] = Type[List[Int]]

    Type[List[Int]] match
      case '[List[$Int]] =>
        println(Type[Int].show)
        println()

    Type[Int => Double] match
      case  '[Function1[$T1, $R]] =>
        println(Type[T1].show)
        println(Type[R].show)
        println()

    Type[(Int => Short) => Double] match
      case '[Function1[Function1[$T1, $R0], $R]] =>
        println(Type[T1].show)
        println(Type[R0].show)
        println(Type[R].show)

  }
}
