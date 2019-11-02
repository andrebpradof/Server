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
        while(true) {
            System.out.println("******** Opções do usuário ******** ");
            System.out.println("1 - Criar novo arquivo");
            System.out.println("2 - Salvar");
            System.out.println("3 - Abrir arquivo");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            input = scanner.next();
            switch (input.charAt(0)) {

                case '1':
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

                case '2':
                    server.showFiles();
                    System.out.println("");
                    System.out.print("Id do arquivo para salvar: ");
                    input = scanner.next();
                    client.setFileServer(server.getFileServers().get(id));
                    try {
                        server.updateFile(id, ""); // Salva vazio por enquanto
                    } catch (IOException e) {
                        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                    }
                    break;
                case '3':
                    server.showFiles();
                    System.out.println("");
                    System.out.print("Id do arquivo para abrir: ");
                    input = scanner.next();
                    client.setFileServer(server.getFileServers().get(id));
                    System.out.println("Digite o texto que viria do editor. Para deconectar digite 'sair':");

                    while (true) {

                        //Recebe texto do cliente para adicionar no arquivo
                        input = scanner.next();

                        //Encerra conexão
                        if (input.compareToIgnoreCase("sair") == 0) {
                            System.out.println("Conexão encerrada");
                            return;
                        }

                        //Atualiza arquivo
                        try {
                            server.updateFile(id, input);
                        } catch (IOException e) {
                            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }


                case '4':
                    System.out.println("Conexão encerrada");
                    conect = false;
                    break;
            }
        }
    }
}
