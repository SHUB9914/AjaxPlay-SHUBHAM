package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class LoginAjaxController @Inject() extends Controller {

  def index = Action { implicit request =>

    Ok(views.html.AjaxLogin())
  }

}
