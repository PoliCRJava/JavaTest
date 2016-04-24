package Emanuele.Ghelfi.SocketGame;

/**
 * Created by Emanuele on 21/04/2016.
 */
public class User {
    private String pw;
    private String username;
    private int maxPoint;

    public User(String pw, String username) {
        this.pw = pw;
        this.username = username;
        this.maxPoint = 0;
    }

    public String getPw() {
        return pw;
    }


    public String getUsername() {
        return username;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)){
            return false;
        }
        else {
            User userToVerify = (User) obj;
            if(pw.equals(userToVerify.getPw()) && username.equals(userToVerify.getUsername())){
                return true;
            }
            else return false;
        }
    }


    @Override
    public String toString() {
        return ""+
                "username='" + username + '\'' +
                ", maxPoint=" + maxPoint;
    }
}
