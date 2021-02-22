package console;


import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoadFile {

    @Mock
    CommandReader commandReader;

    @InjectMocks
    FileLoader fileLoader;

    @Test
    void ifExitCloseApp() throws Exception {
        //given
        when (commandReader.getNextCommand()).thenReturn("exit");

        //when
        int statusCode = SystemLambda.catchSystemExit(() -> { fileLoader.loadFile(); });

        //then
        assertEquals(0, statusCode);
    }

}
