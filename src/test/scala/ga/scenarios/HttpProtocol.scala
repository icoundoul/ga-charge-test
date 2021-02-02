package ga.scenarios

import java.lang.Integer.valueOf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import ga.Constants.{BASE_URL, PROXY_HOST, PROXY_PORT, V_USERS}

object HttpProtocol {
  
  val INSTANCE = http
    .baseURL("http://webpage")
    .acceptHeader("text/html,text/xml,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .connection("keep-alive")


  if (PROXY_HOST != null && PROXY_PORT != null) {
    INSTANCE = INSTANCE.proxy(Proxy(PROXY_HOST, valueOf(PROXY_PORT)))
  }
}
