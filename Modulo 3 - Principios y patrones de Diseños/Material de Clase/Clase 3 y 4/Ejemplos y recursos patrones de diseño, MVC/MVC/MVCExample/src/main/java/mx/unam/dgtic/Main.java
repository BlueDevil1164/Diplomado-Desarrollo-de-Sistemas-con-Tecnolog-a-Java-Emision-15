package mx.unam.dgtic;

import mx.unam.dgtic.controllers.UserController;
import mx.unam.dgtic.models.User.User;
import mx.unam.dgtic.views.UserView;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User model=new User();
        UserView view=new UserView();
        UserController controller=new UserController(model,view);
        controller.setUserName("Adrian");
        controller.setUserPassword("admin123");
        controller.updateView();
    }
}