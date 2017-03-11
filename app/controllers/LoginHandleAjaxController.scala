package controllers
import play.api.cache._
import javax.inject._
import play.api.mvc._

@Singleton
class LoginHandleAjaxController @Inject()(cache: CacheApi) extends Controller {

  def index(id:String,password:String) = Action { implicit request =>

    val user = cache.get[(String,String)](id)
    println("id==="+id)
println("=========================================================="+user)
    println("ppppppppppppppppp"+password)
    val ps= password
    user match {
      case Some((name,pass)) =>  if(pass==ps) Ok(views.html.AjaxProfile(id,name,ps))
      else Ok("please enter correct pasword")
      case None => Ok("you are not valid user please signup first")
    }

  }

}
