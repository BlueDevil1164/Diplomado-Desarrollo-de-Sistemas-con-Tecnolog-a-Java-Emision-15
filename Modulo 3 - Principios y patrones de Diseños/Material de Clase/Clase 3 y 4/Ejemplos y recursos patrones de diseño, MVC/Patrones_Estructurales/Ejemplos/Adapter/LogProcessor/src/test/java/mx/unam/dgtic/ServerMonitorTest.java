package mx.unam.dgtic;

import junit.framework.TestCase;
import mx.unam.dgtic.adapters.LogProcessor;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ServerMonitorTest {

    @Test
    public void givenServerMonitorAndProcessorWhenProcessLogsGivenThenVerifyValidProcess() {
        //Given
        LogProcessor processorMock = Mockito.mock(LogProcessor.class);
        ServerMonitor serverMonitor = new ServerMonitor(processorMock);
        List<String> logs = Arrays.asList("Log 1", "Log 2", "Log 3");

        //WHEN
        serverMonitor.processLogs(logs);

        //Then
        Mockito.verify(processorMock, Mockito.times(logs.size())).processLog(Mockito.anyString());
    }
}