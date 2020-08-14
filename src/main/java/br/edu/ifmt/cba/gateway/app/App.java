package br.edu.ifmt.cba.gateway.app;

import br.edu.ifmt.cba.gateway.database.DatabaseConnection;
import br.edu.ifmt.cba.gateway.server.Server;

/**
 * @author daohn on 14/08/2020
 * @project gateway_server
 */
public class App {

    public static void main(String... args) {
        try {
            var port = -1;
            // verificando se foi informado 1 argumento de linha de comando
            if(args.length < 1) {
                System.err.println("Uso: java tcp.server <port>");
                System.exit(1);
            }
            // para garantir que somente inteiros serão atribuídos a porta
            port = Integer.parseInt(args[0]);
            if(port < 1024) {
                System.err.println("A porta deve ser maior que 1024");
                System.exit(1);
            }

            DatabaseConnection.getEntityManager();

            var server = new Server();
            server.listen(port);
        }
        catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            System.exit(1);
        }
    }

}
