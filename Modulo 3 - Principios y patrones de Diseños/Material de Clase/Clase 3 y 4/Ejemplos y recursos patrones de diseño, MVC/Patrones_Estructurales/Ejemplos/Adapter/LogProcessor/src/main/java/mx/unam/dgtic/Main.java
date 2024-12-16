package mx.unam.dgtic;

import java.util.List;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var logs= List.of("Error occurred in data center A",
                "Warning: High CPU usage in Server B",
                "Info: Data replication completed in Cloud Server C");

        ServerMonitor monitor=new ServerMonitor();
        monitor.processLogs(logs);
    }
}