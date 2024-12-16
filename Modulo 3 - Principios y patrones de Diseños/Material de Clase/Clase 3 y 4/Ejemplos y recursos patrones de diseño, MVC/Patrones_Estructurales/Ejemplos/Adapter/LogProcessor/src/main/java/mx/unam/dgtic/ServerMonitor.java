package mx.unam.dgtic;

import mx.unam.dgtic.adapters.LogProcessor;
import mx.unam.dgtic.adapters.LogToJsonAdapter;
import mx.unam.dgtic.service.LogAnalyzerServiceImpl;

import java.util.List;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ServerMonitor {

    private LogProcessor processor;

    public ServerMonitor() {
        this.processor = new LogToJsonAdapter(new LogAnalyzerServiceImpl());
    }

    public ServerMonitor(LogProcessor processor) {
        this.processor = processor;
    }

    public void processLogs(List<String > logs){
        logs.stream().forEach(processor::processLog);
    }
}
