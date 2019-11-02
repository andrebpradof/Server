package Server;

import java.io.FileReader;

public class Client {

    private FileServer fileServer;
    private String name;


    public FileServer getFileServer() {
        return fileServer;
    }

    public String getName() {
        return name;
    }


    public void setFileServer(FileServer fileServer) {
        this.fileServer = fileServer;
    }


    public void setName(String name) {
        this.name = name;
    }


}
