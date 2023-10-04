import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TicTacGameTest {

    @Test
    public void testMultipleCasesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] inputValues = line.split(",");
            int row = Integer.parseInt(inputValues[0]);
            int col = Integer.parseInt(inputValues[1]);
            TicTacGame.initializeBoard();
            boolean isValidMove = TicTacGame.isValidMove(row, col);
            assertTrue(isValidMove);
        }
        reader.close();
    }
}
