package ex2016.a01.t4.e1;

import static org.junit.Assert.*;

import java.util.*;

/**
 * Si consulti la documentazione delle interfacce BuilderFactory e ListBuilder. 
 * 
 * BuilderFactory (da implementare in una class BuilderFactoryImpl con costruttore senza argomenti) modella una factory per oggetti 
 * di tipo ListBuilder.
 *  
 * ListBuilder modella un builder per liste immutabili, ossia un oggetto che si usa per indicare passo passo 
 * una lista di elementi a proprio piacimento, per poi generarne una lista immutabile da produrre in uscita (si ricordi
 * l'uso del metodo Collections.unmodifiableList).
 * 
 * Si noti che BuilderFactory richiedere di produrre 4 builder di tipo diverso: la cosa va fatta cercando di evitare al massimo le
 * duplicazioni di codice.
 * 
 * Sono considerati opzionali ai fini della possibilit√† di correggere l'esercizio, ma concorrono comunque al raggiungimento 
 * della totalit√† del punteggio:
 * - implementazione dell'ultimo builder (il suo test √® indicato come opzionale)
 * - la non duplicazione di codice, e in generale, la buona progettazione della soluzione
 * 
 * Si osservi con attenzione il test seguente, che assieme ai commenti delle interfacce date
 * costituisce la definizione del problema da risolvere.
 * 
 * Si tolga il commento al codice del test.
 */

public class Test {
    
    
    @org.junit.Test
    public void testBasicBuilder() {
        // Istanzio la factory per i builder
        final BuilderFactory builderFactory = new BuilderFactoryImpl();
        // Un builder usato per creare la lista immutabile di elementi "a","b","c" 
        final ListBuilder<String> b1 = builderFactory.makeBasicBuilder();
        b1.add("a");
        b1.add("b");
        b1.add("c");
        assertEquals(b1.build(), Arrays.asList("a","b","c"));
        // Esempio simile, ma con gli Integer
        final ListBuilder<Integer> b2 = builderFactory.makeBasicBuilder();
        b2.add(10);
        b2.add(50);
        b2.add(20);
        b2.add(30);
        assertEquals(b2.build(), Arrays.asList(10,50,20,30));
        // Nota, dopo aver chiamato la build, il builder non √® pi√Ļ usabile
        try {
            b2.add(40);
            fail("cannot add after build");
        } catch (IllegalStateException e){}
        catch (Exception e){
            fail("should throw an IllegalStateException, not a "+e.getClass());
        }
        // ..n√© si possono fare altre build
        try{
            b2.build();
            fail("cannot build after building!");
        } catch (IllegalStateException e){}
          catch (Exception e){
              fail("should throw an IllegalStateException, not a "+e.getClass());
          }
    }
    
    @org.junit.Test
    public void testBuilderWithSize() {
        // Un builder per stringhe di 3 elementi, n√© pi√Ļ n√© meno
        final BuilderFactory builderFactory = new BuilderFactoryImpl();
        final ListBuilder<String> b1 = builderFactory.makeBuilderWithSize(3);
        b1.add("a");
        b1.add("b");
        b1.add("c");
        assertEquals(b1.build(), Arrays.asList("a","b","c"));
        // Se si prova a costruire una lista con meno o pi√Ļ elementi.. fallisce
        final ListBuilder<String> b2 = builderFactory.makeBuilderWithSize(3);
        b2.add("a");
        b2.add("b");
        try{
            b2.build();
            fail("cannot build, we need 3 elements, not 2!");
        } catch (IllegalStateException e){}
          catch (Exception e){
              fail("should throw an IllegalStateException, not a "+e.getClass());
          }
        // in caso di tentativo di build errato si pu√≤ andare avanti!
        b2.add("c");
        assertEquals(b2.build(), Arrays.asList("a","b","c"));
    }
    
    @org.junit.Test
    public void testBuilderWithoutElements() {
        final BuilderFactory builderFactory = new BuilderFactoryImpl();
        final ListBuilder<String> b1 = builderFactory.makeBuilderWithoutElements(Arrays.asList("2","3"));
        // Un builder che escluda le stringhe "2" e "3"
        b1.add("0");
        b1.add("1");
        b1.add("1");
        assertEquals(b1.build(), Arrays.asList("0","1","1"));
        final ListBuilder<String> b2 = builderFactory.makeBuilderWithoutElements(Arrays.asList("2","3"));
        b2.add("0");
        // provare a inserire un "2" genera un errore
        try{
            b2.add("2");
            fail("cannot get a 2");
        } catch (IllegalArgumentException e){}
          catch (Exception e){
              fail("should throw an IllegalArgumentException, not a "+e.getClass());
          }
        //.. ma poi si pu√≤ andare avanti
        b2.add("1");
        assertEquals(b2.build(), Arrays.asList("0","1"));
    }
    
    @org.junit.Test
    public void optionalTestBuilderWithoutElementsAndWithSize() {
        final BuilderFactory builderFactory = new BuilderFactoryImpl();
        final ListBuilder<String> b1 = builderFactory.makeBuilderWithoutElementsAndWithSize(Arrays.asList("2","3"),4);
        // Un builder per stringhe di 4 elementi, che escluda "2" e "3"
        b1.add("0");
        b1.add("1");
        b1.add("1");
        b1.add("0");
        assertEquals(b1.build(), Arrays.asList("0","1","1","0"));
        ListBuilder<String> b2 = builderFactory.makeBuilderWithoutElementsAndWithSize(Arrays.asList("2","3"),4);
        b2.add("0");
        try{
            b2.add("2");
            fail("cannot add 2, just a 0 or 1");
        } catch (IllegalArgumentException e){}
          catch (Exception e){
              fail("should throw an IllegalArgumentException, not a "+e.getClass());
          }
        b2.add("1");
        try{
            b2.build();
            fail("cannot build, we need 4 elements, not 2!");
        } catch (IllegalStateException e){}
          catch (Exception e){
              fail("should throw an IllegalStateException, not a "+e.getClass());
          }
        b2.add("0");
        b2.add("0");
        assertEquals(b2.build(), Arrays.asList("0","1","0","0"));
    }
    
}
