package ga.scenarios

import java.lang.Integer.valueOf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import ga.Constants.{BASE_URL, PROXY_HOST, PROXY_PORT, V_USERS}


object HttpProtocol {

  var INSTANCE = http
    .baseUrl(BASE_URL)
    .inferHtmlResources(BlackList(""".*.ico""", """.*.js""", """.*.css"""), WhiteList())
    //.acceptHeader("application/json, text/plain, */*")
    .acceptHeader("text/html,text/xml,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36")
    .headers(Map("Proxy-Connection" -> "keep-alive"))


  /*if (PROXY_HOST != null && PROXY_PORT != null) {
    INSTANCE = INSTANCE.proxy(Proxy(PROXY_HOST, valueOf(PROXY_PORT)))
  }*/
}
