import java.net.*;
import java.io.*;


public class Client
{
    private final static int PORT=3000;
    private final static int NUMSPAZI=100;
    private final static int TempoFisso=500;
    private final static int TempoVariabile=50;
    
    private final static String address="localhost";
    
    private Socket socket;
    private BufferedReader inSocket;
    private PrintWriter outSocket;
    private BufferedReader inKeyboard;
    private PrintWriter outVideo;
    
    public Client()
    {
        System.out.println("Client avviato");
        
        try
        {
            esegui();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
        finally
        {
            // Always close it:
            try {
                socket.close();
            } catch(IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
    
    private void connetti()
    {
        try
        {
            System.out.println("Il client tenta di connettersi");

            socket = new Socket(address, PORT);
            //canali di comunicazione
            inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outSocket = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            inKeyboard = new BufferedReader(new InputStreamReader(System.in));
            outVideo = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
            
            System.out.println("Client connesso");
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();

            // Always close it:
            try {
                socket.close();
            } catch(IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
    
    
    private void esegui()
    {
        try
        {
            connetti();
            login();
            gioca();
            chiudi();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
        finally
        {
            // Always close it:
            try {
                socket.close();
            } catch(IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
    
    private void gioca()
    {
        while(true)
        {
            outVideo.println("Scegliere cosa si vuol fare");
            outVideo.println("p --> partita");
            outVideo.println("r --> vedi record dei giocatori");
            outVideo.println("q --> esci");
            
            try
            {
                String scelta=inKeyboard.readLine();

                if(scelta.equals("p"))
                    partita();
                else if(scelta.equals("r"))
                    vediRecord();
                else if(scelta.equals("q"))
                {
                    outSocket.println("fine");
                    outVideo.println("ARRIVEDERCI!!!!!");
                    break;
                }
                else
                    outVideo.println("INPUT ERRATO");
            }
            catch(Exception e)
            {
                System.out.println("Exception: "+e);
                e.printStackTrace();
                
                // Always close it:
                try
                {
                    socket.close();
                }
                catch(IOException ex)
                {
                    System.err.println("Socket not closed");
                }
            }
        }
    }
    
    private void partita()
    {
        try
        {
            //codice partite
            outVideo.println("Inizio partita\n");
            outVideo.println("Leggi i numeri, memorizzali, riscrivili\n");
            
            outSocket.println("partita");
            
            boolean continua=true;
            while(continua)
            {
                String sequenza=inSocket.readLine();
                outVideo.println("Sequenza: "+sequenza);
                Thread.sleep(TempoFisso+TempoVariabile*sequenza.length());
                generaBianco();
                outVideo.println("Riinserisci la sequenza:");
                sequenza=inKeyboard.readLine();
                outSocket.println(sequenza);
                continua=Boolean.valueOf(inSocket.readLine()).booleanValue();
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
                   
            // Always close it:
            try {
                socket.close();
            } catch(IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
    
    private void vediRecord()
    {
        try
        {
            //codice partite
            outVideo.println("Record dei giocatori\n");
            
            outSocket.println("record");
            outVideo.println("record:");
            
            int numGiocatori=Integer.parseInt(inSocket.readLine());
            
            for(int i=0;i<numGiocatori;i++)
            {
                String record=inSocket.readLine();
                outVideo.println(record);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
                   
            // Always close it:
            try {
                socket.close();
            } catch(IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
    
    private void generaBianco()
    {
        for(int i=0;i<NUMSPAZI;i++)
            outVideo.println();
    }
    
    private void chiudi()
    {
        try
        {
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
        finally
        {
            // Always close it:
            try
            {
                socket.close();
            }
            catch(IOException ex)
            {
                System.err.println("Socket not closed");
            }
        }
    }


    private void login()
    {
        try
        {
            boolean loggato=false;
            
            while(!loggato)
            {
                outVideo.println("Inserire login:");
                String username=inKeyboard.readLine();
                
                outVideo.println("Inserire password:");
                String password=inKeyboard.readLine();
                
                outSocket.println("login");
                outSocket.flush();
                outSocket.println(username);
                outSocket.flush();
                outSocket.println(password);
                outSocket.flush();
                
                loggato=Boolean.valueOf(inSocket.readLine()).booleanValue();
                
                if(loggato)
                    outVideo.println("Login effettuato correttamente");
                else
                    outVideo.println("Nome utente in uso con altra password");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        
            try {
                socket.close();
            }
            catch(IOException ex)
            {
                System.err.println("Socket not closed");
            }
        }
    }
    
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Client c=new Client();
    }
}