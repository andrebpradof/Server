package Server;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private final ArrayList<Client> clients = new ArrayList<Client>();
    private final ArrayList<FileServer> fileServers = new ArrayList<FileServer>();
    private static String connect;
    private static String directory;
    private static String input;


    public ArrayList<Client> getClientes() {
        return clients;
    }

    public ArrayList<FileServer> getFileServers() {
        return fileServers;
    }

    public static String getConnect() {
        return connect;
    }

    public static void setConnect(String connectIn) {
        connect = connectIn;
    }

    public static String getDirectory() {
        return directory;
    }

    public static void setDirectory(String directoryIn) {
        directory = directoryIn;
    }

    public static void message(String text, String title, int type){
        JOptionPane optionPane = new JOptionPane(text,type);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public int newFile(String name) throws IOException {
        File file = new File(directory+"/"+name+".txt");
        if(!file.exists()){
            file.createNewFile();
            FileServer help = new FileServer();

            help.setDirectory(directory+"/"+name+".txt");
            help.setSize(0);
            help.setName(name);
            fileServers.add(help);

            return fileServers.lastIndexOf(help);
        }
        else{
            System.out.println("Esse arquivo já existe nesse diretório");
            return -1;
        }
    }

    public void filelist(){

        try {
            File f = new File(directory);

            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    // We want to find only .c files
                    return name.endsWith(".txt");
                }
            };


            File[] files = f.listFiles(filter);

            for (int i = 0; i < files.length; i++) {
                FileServer help = new FileServer();

                help.setDirectory(files[i].getAbsolutePath());
                help.setSize(files[i].length());
                help.setName(files[i].getName());

                fileServers.add(help);
            }

        } catch (Exception e) {
            message("Erro no diretório "+directory+"!", "Erro", 0);
        }
    }

    public void updateFile(int FileId, String text) throws IOException{
        String metDirectory = fileServers.get(FileId).getDirectory();
        File file = new File(metDirectory);
        Writer writer;

        writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(text+"\n");
        writer.close();

    }

    public void showFiles(){
        int i;
        for (i = 0; i < fileServers.size(); i++) {
            System.out.print("id: "+i+" - Nome do arquivo: "+fileServers.get(i).getName());
            System.out.println("");
        }
    }

    public static void main(String []args) throws IOException {
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Diretório para os arquivos: ");
            directory = scanner.nextLine();
            //directory = JOptionPane.showInputDialog("Diretório para os arquivos:");
            if(directory != null){ break; }
            message("Diretório inválido!", "Erro", 0);
        }

        //JOptionPane.showMessageDialog(null,"Diretório de edição desejado: "+directory);


        System.out.println("******** Escutando Usuários ********");
        System.out.print("Digite conectar para logar no servidor: ");

        //lista arquivos da pasta e salva em uma lista
        server.filelist();



        while(true){
            input = scanner.next();
            if("conectar".equals(input)){
                System.out.println("Novo usuário conectado!");
                System.out.println();

                Client user = new Client();

                Runnable runnable = new Connect(user, server);
                Thread t = new Thread(runnable);
                t.start();
                break; //apenas um cliente para testes, sera retirado esse break na terceira fase do trabalho
            }
        }
    }// Fim do método main
}



