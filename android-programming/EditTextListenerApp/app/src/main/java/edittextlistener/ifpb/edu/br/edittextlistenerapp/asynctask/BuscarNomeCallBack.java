package edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask;

import java.util.List;

/**
 * Created by rerissondaniel on 25/02/16.
 */
public interface BuscarNomeCallBack {
    void backBuscarNome(List<String> names);

    void errorBuscarNome(String error);
}
