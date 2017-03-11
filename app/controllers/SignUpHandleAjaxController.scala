package controllers
import play.api.cache._
import javax.inject._
import play.api.mvc._

@Singleton
class SignUpHandleAjaxController @Inject()(cache: CacheApi) extends Controller {

  def index(id:String,name:String,password:String) = Action { implicit request =>

    val user = cache.get[(String,String)](id)
println("------------------------------"+user)
    user match {

      case Some(_) => Ok("sorry this user already exist")

      case None => cache.set(id,(name,password))
        Ok("user created now user can Login.......")
    }

  }

}
