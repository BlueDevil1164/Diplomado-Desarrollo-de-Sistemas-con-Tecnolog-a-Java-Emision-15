package mx.unam.dgtic.adapters;


import mx.unam.dgtic.service.LogAnalizerService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class LogToJsonAdapterTest {

    @Test
    public void givenAnalizerServiceWhenProcessLogThenVerifyLogValide() {
        //GIVEN
        LogAnalizerService logAnalyzerMock = Mockito.mock(LogAnalizerService.class);
        LogToJsonAdapter adapter = new LogToJsonAdapter(logAnalyzerMock);
        String log = "Error occurred in data center A";

        //WHEN
        adapter.processLog(log);

        //THEN
        ArgumentCaptor<String> jsonLogCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(logAnalyzerMock).analyzeLog(jsonLogCaptor.capture());

        //AND
        String capturedJsonLog = jsonLogCaptor.getValue();

        //AND
        String expectedJsonLog = "{ \"message\":\"" + log + "\", \" date\": \"" + LocalDateTime.now() + "\"}";

        //THEN
        Assert.assertTrue(expectedJsonLog.contains(log));
    }

}