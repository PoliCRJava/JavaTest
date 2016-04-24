/**
 * Created by Samuele on 21/04/2016.
 */
public class Giocatore {
    private String nome;
    private String password;
    private int punti;

    public Giocatore (String nome, String password,int punti){
        this.nome=nome;
        this.password=password;
        this.punti=punti;}

    public int getPunti(){
        return punti;
    }

    public String getNome(){
        return nome;
    }

    public String getPassword(){
        return password;
    }

    public void setPunti(int punti){
        this.punti=punti;}

    public void addPunti(){
        punti++;
    }
}
