package Server;

import java.io.FileReader;

public class Client {

    private FileServer fileServer;
    private String name;
    private String ip;


    public FileServer getFileServer() {
        return fileServer;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public void setFileServer(FileServer fileServer) {
        this.fileServer = fileServer;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }


}
