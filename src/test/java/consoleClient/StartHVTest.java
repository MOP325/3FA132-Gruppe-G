package consoleClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import dev.hv.consoleClient.StartHV;

public class StartHVTest {

    @Test
    public void testPrintHelp() {
        // Redirect System.out for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call printHelp method
        StartHV.printHelp();

        String expectedOutput = "StartHV - Java Console Client\n" +
                "\n" +
                "Version: 1.0\n" +
                "\n" +
                "Beschreibung:\n" +
                "Dies ist ein Java-Konsolen-Client für bestimmte Datenbankoperationen.\n" +
                "\n" +
                "Aufruf:\n" +
                "java de.gc.hv.console.StartHV [Optionen]\n" +
                "\n" +
                "Optionen:\n" +
                "-h                            Zeigt diesen Hilfetext mit allen Parametern an und die Versionsnummer der Laufzeitumgebung.\n" +
                "--delete                      Löscht alle Tabellen und setzt die Primärschlüssel-Zähler, falls vorhanden, zurück.\n" +
                "\n" +
                "Exportieren:\n" +
                "export <tablename>            Führt einen Export von Daten (Tabelle) durch.\n" +
                "-o, --output=<fileout>        Gibt den Namen der Ausgabedatei an.\n" +
                "\n" +
                "Importieren:\n" +
                "import <tablename>            Führt einen Import von Daten (Tabelle) durch.\n" +
                "-i, --input=<filein>          Gibt den Namen der Eingabedatei an.\n" +
                "\n" +
                "Formate:\n" +
                "-c                            Verwendet das CSV-Format.\n" +
                "-j                            Verwendet das JSON-Format.\n" +
                "-x                            Verwendet das XML-Format.\n" +
                "-t                            Verwendet das Text-Tabellenformat (nur beim Export).\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
