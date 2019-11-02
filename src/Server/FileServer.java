package Server;

import java.util.ArrayList;

public class FileServer {
    private String name;
    private String directory;
    private ArrayList<Client> clients;
    private long size;
    private String modificationDate;
    private String creator;

    public FileServer(){
        this.size = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public String getDirectory() {
        return directory;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public long getSize() {
        return size;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public String getCreator() {
        return creator;
    }
}
