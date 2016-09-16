package uebung5neu;

import javax.swing.*;

public class Test {


    //ausführbare Methode (sonst kann man das Programm nicht starten)
    public static void main (String[]args){

        Bruch b = new Bruch();      // eine neue Instanz / Objekt aus der Klasse anlegen (Ein Bauplan, viele Objekte davon)

        b.setZaheler(16);           // Werte für dieses eine Objekt setzen
        b.setNenner(4);

        b.gekuerztausgeben();       // Funktionen dieses Objekts nutzen

  

        Bruch c = new Bruch(3);     // Noch ein Objekt aus der Klasse anlegen (nun sind 2 im Speicher)

        Bruch d = c;                // Objekte zeigen beim gleichsetzen auf den Selben speicherbereich

        c.setNenner(9);             // Dieser eine wird nun so geändert das dort nun 1/9 steht, also steht es auch für
                                    // d genauso da!

        c.ausgeben();               // nun dieses c.ausgeben, welches anders als b "aussieht"
        d.ausgeben();               // d, obwohl nicht direkt geändert ist wieder zu c identisch


        int w = 5;                  // Bei Primitiven wird der Wert nur Kopiert
        int y = w;                  // das gleiche für w

        System.out.println(w +"  "+ y); // 5 und 5 - beide haben den Wert 5

        w = 10;                         // nur w ändert sich, y aber nicht es bleibt auf 5,
                                        // oben beim Objekt wären nun beide auf 5!

        System.out.println(w +"  "+ y);  // 10 und 5



        boolean doit = true;  // eine Variable um die while scheilfe laufen zu lassen

        while (doit) { // Scheige die zu erst einmal immer weiter läuft - der Benutzer muss Sie abbrechen
            int z = Integer.parseInt( JOptionPane.showInputDialog(null, "Zähler?") );   // Dialog für Nenner - Abfrage zeigen
            int n = Integer.parseInt( JOptionPane.showInputDialog(null, "Nenner?"));

            Bruch x = new Bruch(z,n);   // Eine neue Klasse erstellen und für den Konstruktor die Werte z,n übergeben

            x.ausgeben(); // den Bruch ausgeben

            x.gekuerztausgeben();   // den Bruch nun gekuertztausgeben lassen

            // Abfragen zeigen um unsere boolean Variable zu setzen und ggf. die Schleife abzubrechen
            if (JOptionPane.YES_OPTION != JOptionPane.showOptionDialog(null, "Noch eine?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null))
            {
                doit = false;
            }

        }

        // Über das Statische Feld der Klasse (Das sich alle Objekte Teilen) kann man sehen wie viele Objekte angelegt wurden
        System.out.println("Anzahl erstellter Brüche= "+Bruch.anzahlBrueche);



    }

}