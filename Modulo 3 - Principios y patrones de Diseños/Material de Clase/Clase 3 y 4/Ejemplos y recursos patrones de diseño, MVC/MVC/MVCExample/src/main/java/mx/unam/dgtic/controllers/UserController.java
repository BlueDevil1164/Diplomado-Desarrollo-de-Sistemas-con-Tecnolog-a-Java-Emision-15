package mx.unam.dgtic.controllers;

import mx.unam.dgtic.models.User.User;
import mx.unam.dgtic.views.UserView;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class UserController {
    private User userModel;
    private UserView userView;

    public UserController(User userModel, UserView userView) {
        this.userModel = userModel;
        this.userView = userView;
    }

    public void setUserName(String name) {
        this.userModel.setUsername(name);
    }


    public void setUserPassword(String password) {
        this.userModel.setPassword(password);
    }

    public void updateView(){
        userView.printUserDetails(userModel.getUsername(), userModel.getPassword());
    }
}
