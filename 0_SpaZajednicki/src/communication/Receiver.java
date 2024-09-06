package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
/**
 *
 * @author Ivana
 */
public class Receiver {
    private Socket socket;
    private ObjectInputStream in;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public Object receive() throws Exception {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
