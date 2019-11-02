package Server;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect implements Runnable{
    private final Server server;
    private final Client client;
    private String input;
    private boolean conect;

    public Connect(Client client, Server server) {
        this.conect = true;
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        int id = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Opção do cliente: 'novo' ou 'abrir' ou 'sair': ");
        input = scanner.next();
        switch(input){

            case "novo":
                System.out.print("Nome do arquivo: ");
                input = scanner.next();
            {
                try {

                    id = server.newFile(input);
                } catch (IOException ex) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "abrir":
                server.printArqs();
                System.out.println("");
                System.out.print("ID do arquivo para abrir: ");
                input = scanner.next();

                break;

            case "sair":
                System.out.println("Conexao encerrada");
                conect = false;
                break;
        }
        client.setFileServer(server.getArqs().get(id));
        System.out.println("Recebe texto do cliente, para sair digite 'sair':");
        while(true){
            //Recebe texto do cliente para adicionar no arquivo
            input = scanner.next();

            //Encerra conexão
            if(input.equals("sair")) {
                System.out.println("Conexao encerrada");
                break;
            }

            //Atualiza arquivo
            try {
                server.UpdateFile(id, input);
            } catch (IOException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
