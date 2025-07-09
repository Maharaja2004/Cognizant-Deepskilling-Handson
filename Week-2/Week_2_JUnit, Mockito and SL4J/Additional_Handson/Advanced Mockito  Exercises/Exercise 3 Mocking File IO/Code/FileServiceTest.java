package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {
	@Test
    public void testServiceWithMockFileIO() {        // Step 1: Mock file reader and writer
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);        // Step 2: Stub fileReader to return mock content
        when(mockFileReader.read()).thenReturn("Mock File Content");

        
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

     
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);

      
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
