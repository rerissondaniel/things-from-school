package edittextlistener.ifpb.edu.br.edittextlistenerapp.entity;

/**
 * Created by rerissondaniel on 05/03/16.
 */
public class UserQuery {
    private String fullName;

    public UserQuery() {
        /*Default constructor.*/
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
