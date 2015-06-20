import dispatch._
import org.scalatest._
import org.scalatest.time._

/**
 * Unit test specification
 *
 * Created by dhaval kolapkar
 */
trait UnitSpec extends FunSpec with BeforeAndAfter with Matchers with concurrent.ScalaFutures {
  implicit val config = PatienceConfig(scaled(Span(90000, Millis)), scaled(Span(80, Millis)))
  // you can customize the http client executor here
  lazy val http = new Http
}
