import java.io.*;
import java.util.Scanner;

public class Servidor{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;
        while(true){
            System.out.print("Aguardando usuário: ");
            comando = scanner.next();
            Runnable runnable = new Gerenciador();
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

class Gerenciador implements Runnable{

    private String filename;
    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String comando;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo: ");
        filename = scanner.nextLine();
        while (true){
            System.out.print("Esperando comando: ");
            saveFile();
            comando = scanner.next();
            if(comando.equalsIgnoreCase("Salvar")){
                saveFile();
                System.out.println("Arquivo " + filename + "salvo!");
            }
            else if(comando.equalsIgnoreCase("Sair")){
                break;
            }
        }
    }

    private void saveFile(){
        file = new File(filename);

        try{
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}