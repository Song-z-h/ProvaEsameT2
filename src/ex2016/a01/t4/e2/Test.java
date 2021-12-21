package ex2016.a01.t4.e2;

public class Test {

    /*
     * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine gui.png fornita, con 
     * un costruttore che prende in ingresso un nome di file DI TESTO e il numero N di pulsanti numerici da visualizzare.
     * In un certo istante, i pulsanti conterranno sempre lo stesso valore, come da figura.
     * 
     * La GUI legge da file di testo una sequenza di numeri interi, scritti uno per linea.
     * Ognuno di questi numeri dovrà essere mostrato su tutti i pulsanti, via via a partire dal primo:
     * premendo un pulsante qualunque (non Reset), la GUI mostrerà quello successivo (sempre su tutti i pulsanti)
     * e così via.
     * Arrivati alla fine del file, tutti i pulsanti vengono disabilitati.
     * Premendo Reset in un qualunque momento, l'esecuzione della GUI ricomincia dall'inizio (rileggendo il contenuto 
     * del file, che nel frattempo potrebbe essere cambiato).
     * 
     * Ad esempio, se il file di testo ha il contenuto:
     * 
     * 1
     * 3
     * 2
     * 1
     * 
     * allora i pulsanti mostreranno prima tutti 1, poi tutti 3, poi tutti 2, poi tutti 1, poi si disabiliteranno tutti.
     * 
     * Per la lettura su file si può usare, ad esempio (ma non solo) BufferedReader che decora FileReader.
     * 
     * Sono considerati opzionali ai fini della possibilità di correggere l'esercizio, ma concorrono comunque al raggiungimento 
     * della totalità del punteggio:
     * - scorporamento di tutti gli aspetti che non sono di view in una interfaccia+classe esterna, via Strategy
     * - effettiva lettura su file (altrimenti la si simuli con la lettura di una sequenza di interi arbitraria e costante)
     * - compilazione e esecuzione dell'esempio da linea di comando
     * 
     * La classe GUI fornita come punto di partenza già contiene in minima parte del codice utile e eventualmente riusabile. 
     * 
     */

    public static void main(String[] args) throws Exception {
        new GUI("src/ex2016/a01/t4/e2/b.txt",10); // Si noti che questo file è presente nella cartella di questo file java 
    }
}
