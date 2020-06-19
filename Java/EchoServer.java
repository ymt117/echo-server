import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(final String[] args) throws IOException {
        try (ServerSocket sockListen = new ServerSocket()) {
            sockListen.setReuseAddress(true);
            sockListen.bind(new InetSocketAddress("0.0.0.0", 12345));

            while(true) {
                Socket socketAccept = sockListen.accept();

                try(InputStream in = socketAccept.getInputStream(); OutputStream out = socketAccept.getOutputStream()) {
                    byte[] buffer = new byte[1500];
                    int readBytes = in.read(buffer);
                    out.write(buffer, 0, readBytes);
                }
            }

        }
    }
}