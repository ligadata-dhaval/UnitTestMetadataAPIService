import java.io.File

import dispatch._, Defaults._

/**
 * Unit spec
 *
 * Created by dhaval kolapkar.
 *
 * CRUD operations on message, container, model, function, type, concept, or configuration.
 */
class RestApiUnitSpec extends UnitSpec {

  describe("A metadata API service for CRUD operations on messages") {
    val host = :/("localhost",8081).secure
    //val host = :/("demo1319324.mockable.io")

    it("should upload a new message object to the metadata server (C)") {
      val request=host / "api"/"message"
      val uri=getClass.getResource("/message/HelloWorld_Msg_Def.json").toURI
      val body: java.io.File=new File(uri)
      whenReady(http(request.POST <<< body  OK dsl.asJson )) {
        json => (json \ "APIResults" \ "Result Description").as[String] should include regex ("Message Added Successfully*"  )
      }
    }

    it("should get all the messages in a metadata server (R)") {
      val request=host / "api" /"keys"/"message"
      whenReady(http(request OK dsl.asJson)) {
        json =>
          (json \ "APIResults" \ "Result Description").as[String] should be ("Successfully fetched all object keys")
      }
    }
  }

}
