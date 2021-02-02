package ga

import java.lang.Integer.valueOf
import java.lang.System.getProperty

import ga.Defaults.{DEFAULT_BASE_URL, DEFAULT_V_USERS}

object Constants {

  val PROXY_HOST: String = getProperty("proxy_host")
  val PROXY_PORT: String = getProperty("proxy_port")
  val BASE_URL: String = if (getProperty("base_url") == null) DEFAULT_BASE_URL else getProperty("base_url")
  val V_USERS: Int = if (getProperty("v_users") == null) DEFAULT_V_USERS else valueOf(getProperty("v_users"))

}
