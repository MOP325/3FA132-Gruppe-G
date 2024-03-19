package dev.hv.consoleClient;
import java.util.Arrays;

// Das ganze Projekt in src/main/java ausführen
// mit javac dev/hv/consoleClient/StartHV.java builden
// mit Java dev.hv.consoleClient.StartHV <args> ausführen
public class StartHV {
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        switch (args[0]) {
            case "-h":
                printHelp();
                break;
            case "--delete":
                deleteTables();
                break;
            case "export":
                handleExport(Arrays.copyOfRange(args, 1, args.length));
                break;
            case "import":
                handleImport(Arrays.copyOfRange(args, 1, args.length));            
                break;
            default:
                System.out.println("Unrecognized command: " + args[0]);
                System.out.println("Use Command -h for help");
        }
    }

    private static void handleExport(String[] args) {
        String format = args[0];
        switch (format) {
            case "-c":
                dev.hv.consoleClient.ExportHV.exportToCSV(args[1], args[2]);
                break;
            case "-j":
                dev.hv.consoleClient.ExportHV.exportToJSON(args[1], args[2]);
                break;
            case "-x":
                dev.hv.consoleClient.ExportHV.exportToXML(args[1], args[2]);    
                break;
            case "-t":
                dev.hv.consoleClient.ExportHV.exportToText(args[1], args[2]);    
                break;
            default:
                printHelp();    
                break;
        }
    }

    private static void handleImport(String[] args) {
        String format = args[0];
        switch (format) {
            case "-c":
                dev.hv.consoleClient.ImportHV.importFromCSV(args[1], args[2]);
                break;
            case "-j":
                dev.hv.consoleClient.ImportHV.importFromJson(args[1], args[2]);
                break;
            case "-x":
                dev.hv.consoleClient.ImportHV.importFromXML(args[1], args[2]);    
                break;
            default:
                printHelp();
                break;
        }
    }

    private static void deleteTables() {
        System.out.println("Test");        

    }

    private static void printHelp() {
        System.out.println("StartHV - Java Console Client\n");
        System.out.println("Version: 1.0\n");
        System.out.println("Beschreibung:");
        System.out.println("Dies ist ein Java-Konsolen-Client für bestimmte Datenbankoperationen.\n");
        System.out.println("Aufruf:");
        System.out.println("java de.gc.hv.console.StartHV [Optionen]\n");
        System.out.println("Optionen:");
        System.out.println("-h                            Zeigt diesen Hilfetext mit allen Parametern an und die Versionsnummer der Laufzeitumgebung.");
        System.out.println("--delete                      Löscht alle Tabellen und setzt die Primärschlüssel-Zähler, falls vorhanden, zurück.\n");
        System.out.println("Exportieren:");
        System.out.println("export <tablename>            Führt einen Export von Daten (Tabelle) durch.");
        System.out.println("-o, --output=<fileout>        Gibt den Namen der Ausgabedatei an.\n");
        System.out.println("Importieren:");
        System.out.println("import <tablename>            Führt einen Import von Daten (Tabelle) durch.");
        System.out.println("-i, --input=<filein>          Gibt den Namen der Eingabedatei an.\n");
        System.out.println("Formate:");
        System.out.println("-c                            Verwendet das CSV-Format.");
        System.out.println("-j                            Verwendet das JSON-Format.");
        System.out.println("-x                            Verwendet das XML-Format.");
        System.out.println("-t                            Verwendet das Text-Tabellenformat (nur beim Export).\n");
    }
}