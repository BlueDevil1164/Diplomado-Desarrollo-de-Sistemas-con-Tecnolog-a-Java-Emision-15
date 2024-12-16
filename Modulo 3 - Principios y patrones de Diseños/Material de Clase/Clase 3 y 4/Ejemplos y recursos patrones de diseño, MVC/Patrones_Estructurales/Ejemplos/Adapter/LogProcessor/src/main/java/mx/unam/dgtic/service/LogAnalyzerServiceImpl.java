package mx.unam.dgtic.service;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class LogAnalyzerServiceImpl implements LogAnalizerService{
    @Override
    public void analyzeLog(String log){
        System.out.println("Analyze log: "+log);
    }
}
