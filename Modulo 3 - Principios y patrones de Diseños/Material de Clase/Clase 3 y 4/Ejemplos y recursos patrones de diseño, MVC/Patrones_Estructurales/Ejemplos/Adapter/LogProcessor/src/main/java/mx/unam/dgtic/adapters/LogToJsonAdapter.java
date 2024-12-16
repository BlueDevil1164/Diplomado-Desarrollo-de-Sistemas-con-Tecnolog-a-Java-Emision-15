package mx.unam.dgtic.adapters;

import mx.unam.dgtic.service.LogAnalizerService;

import java.time.LocalDateTime;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class LogToJsonAdapter implements LogProcessor {
    private LogAnalizerService logAnalyzer;

    public LogToJsonAdapter(LogAnalizerService logAnalyzer) {
        this.logAnalyzer = logAnalyzer;
    }

    @Override
    public void processLog(String log) {
        String jsonLog=convertToJSON(log);
        logAnalyzer.analyzeLog(jsonLog);
    }

    private String convertToJSON(String log){
        return new StringBuffer()
                .append("{ ")
                .append("\"message\":")
                .append("\""+log+"\"")
                .append(", \" date\": ")
                .append("\""+ LocalDateTime.now()+"\"")
                .append("}")
                .toString();
    }
}
