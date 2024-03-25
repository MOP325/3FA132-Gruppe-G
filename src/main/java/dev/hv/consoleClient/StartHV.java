package dev.hv.consoleClient;

import java.util.Arrays;

import dev.hv.consoleClient.ImportFile.ImportCSV;
import dev.hv.consoleClient.ImportFile.ImportJson;
import dev.hv.consoleClient.ImportFile.ImportXML;
import dev.hv.db.init.DbConnect;

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
                dev.hv.consoleClient.ExportFile.ExportHV.exportToCSV(args[1], args[2]);
                break;
            case "-j":
                dev.hv.consoleClient.ExportFile.ExportHV.exportToJSON(args[1], args[2]);
                break;
            case "-x":
                dev.hv.consoleClient.ExportFile.ExportHV.exportToXML(args[1], args[2]);
                break;
            case "-t":
                dev.hv.consoleClient.ExportFile.ExportHV.exportToText(args[1], args[2]);
                break;
            default:
                printHelp();
                break;
        }
    }

    private static void handleImport(String[] args) {
        String format = args[0];
        ImportCSV importCSV = new ImportCSV();
        ImportJson importJson = new ImportJson();
        ImportXML importXML = new ImportXML();

        switch (format) {
            case "-c":
                importCSV.pickTable(args[1], args[2]);
                break;
            case "-j":
                importJson.pickTable(args[1], args[2]);
                break;
            case "-x":
                importXML.pickTable(args[1], args[2]);
                break;
            default:
                printHelp();
                break;
            }
    }

    private static void deleteTables() {
        DbConnect dbConnect = new DbConnect();
        dbConnect.removeAllTables();
    }

    public static void printHelp() {
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
