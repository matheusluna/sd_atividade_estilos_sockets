import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Logger;

public class No_1 {
    private static final Logger log = Logger.getLogger(No_1.class.getName());

    public static void main(String args[]) throws IOException {
        Socket client = new Socket("127.0.0.1", 4321);

        Map<String, Integer> operacao = Map.of("num1", 2, "num2", 4, "node", 1);

        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(operacao);

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        log.info("[NODE1] Resultado: " + ois.readInt());
    }
}
