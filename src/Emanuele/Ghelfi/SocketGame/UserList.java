package Emanuele.Ghelfi.SocketGame;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Emanuele on 21/04/2016.
 */
public class UserList {

    private Vector<User> users;

    public UserList(Vector<User> vector) {
        this.users = vector;
    }

    public UserList() {
        this.users = new Vector<User>();
    }

    public void UpdateMaxPoint(User user, int sequenceLength) {

        for(int i = 0; i< users.size();i++){
            if(users.get(i).getUsername().equals(user.getUsername()) && users.get(i).getPw().equals(user.getPw())){
                if(users.get(i).getMaxPoint()<sequenceLength)
                    users.get(i).setMaxPoint(sequenceLength);
            }
        }
    }

    public int size(){
        return users.size();
    }

    public void SendRecord(PrintWriter out) {

    }

    public boolean Login(User userToVerify){
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).getUsername().equals(userToVerify.getUsername())){
                if(users.get(i).getPw().equals(userToVerify.getPw()))
                    return true;
                else return false;
            }
        }
        users.add(userToVerify);
        return true;
    }

    public Iterator<User> getIterator(){
        return users.iterator();
    }
}
