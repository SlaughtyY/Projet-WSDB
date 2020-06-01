package controllers;

import models.User;
import play.mvc.*;

public class HomeController extends Controller {
    

    
    //Page d'accueil
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result getcookie(Http.Request request) {
        return ok(request.session().get("session").get());
    }



    public Result getstat(String valeur) {

        if (valeur.equals("nbjoueur")){
            return ok(""+Userapp.getnbjoueur());
        }
        if (valeur.equals("nbmatch")){
            return ok(""+Jeuxapp.getmatchencours());
        }

        return ok("Error bad request "+valeur);
    }

    //Page de redirection
    public Result messagetempo(String t){
        return ok(views.html.messagetempo.render(t));
    }

}


