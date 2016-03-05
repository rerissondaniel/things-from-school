package edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask;

import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.User;

/**
 * Created by rerissondaniel on 25/02/16.
 */
public interface BuscarNomeCallBack {
    void backBuscarUsuario(List<User> users);

    void errorBuscarUsuario(String error);
}
