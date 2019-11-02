package Server;

import java.util.ArrayList;

/**
 * Classe modelo de arquivo do servidor.
 * Contem todos os atributos e metodos diretamente relacionados aos arquivos manipulados pelo servidor
 */
public class FileServer {
    private String name; //nome do arquivo
    private String directory;  //diretorio do arquivo
    private ArrayList<Client> clients; //lista de clientes conectados
    private long size; //tamanho do arquivo
    private String modificationDate; //data de modificação
    private String creator; //nome do criador do arquivo

    /**
     * Inicializa um FileServer de tamanho 0
     */
    public FileServer(){
        this.size = 0;
    }

    /**
     * seta a string com o nome do arquivo
     * @param name - string com nome do arquivo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * seta a string do diretorio do arquivo
     * @param directory - string do diretorio do arquivo
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * seta a lista dos clientes conectados
     * @param clients ArrayList de clients
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * seta o tamanho do arquivo
     * @param size long do tamanho do arquivo
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * seta a data de modificação do arquivo
     * @param modificationDate string
     */
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
