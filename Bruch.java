package uebung5neu;

public class Bruch {

    static int anzahlBrueche = 0; // Z�hlt die Bruchobjekte die von der klasse erstellt wurden

    // Variablen, in der jedes Objekt seine Werte f�r Nenner und Z�hler speichern kann
    private int zaheler;
    private int nenner;

    Bruch(){
        // ruft den Konstruktor "Bruch (int z, int n) auf
        this(0,1);
    }

    Bruch(int nenner){
        // ruft den Konstruktor Bruch (int z, int n) auf
        this(1, nenner);
    }

    Bruch (int z, int n){
        // ruft die Methode setze(z,n) auf um die Werte zu setzen
        setze(z,n);
        // erh�ht die statische (Klassen Variable) vom Objekt aus, so das wir z�hlen k�nnen wie viele Objekte erstellt wurden
        anzahlBrueche++;
    }

    void ausgeben(){
        System.out.println(getZaheler() + (getNenner() == 1 ? "":"/"+ getNenner()));

        /*
        * Die Ausf�hrliche Variante zu der obigen Zeile - besser verst�ndlich, aber mehr zu Tippen
        if(nenner == 1){
            System.out.println( zaheler );
        }
        else
        {
            System.out.println( zaheler + "/" + nenner);
        }
        */

    }

    void kuerzen(){
        int hz, hn, r; // Deklaration

        hz = getZaheler();  //Wertzuweisung
        hn = getNenner();

        r  = hz % hn;  // der Rest veim Teilen von Z�hler / Nenner

        while(r > 0){  // Solange wie es einen Rest git, weiter teilen
            hz  = hn;
            hn = r;
            r = hz % hn;
        }
        // neuem gek�rzte Werte Zetzen
        setZaheler(getZaheler() /hn);
        setNenner(getNenner()  / hn);
    }

 
    void gekuerztausgeben(){
        kuerzen();      // Methoden aufruf
        ausgeben();     // Methoden aufruf

    }


    void multiplizieren(Bruch m){
        // mit get den Wert Holen, ausrechnen und im set wieder setzen lassen
        setZaheler(getZaheler() * m.getZaheler());
        setNenner(getNenner() * m.getNenner());

    }


    void setze(int z){
        setze(z,1);
    }


    void setze(int z, int n){

        setZaheler(z);
        setNenner(n);

    }

    void erweitern(int a){

        setZaheler( getZaheler() * a);
        setNenner( getNenner() * a);
    }


    double dezimalwert(){
        return (double) getZaheler() / getNenner();
    }

    int signum(){
        if( this.dezimalwert() == 0){
            return 0;
        }else if(this.dezimalwert() > 0){
            return 1;
        }else{
            return -1;  // kleiner 0
        }
    }

    // GET und SET Methoden - nutzt man statt immer direkt auf die Variable zu gehen, so kann man
    // z.B. immer Pr�fen ob der nenner ungleich null ist um div durch 0 zu vermeiden

    public int getZaheler() {
        return zaheler;
    }

    public void setZaheler(int zaheler) {
        this.zaheler = zaheler;
    }

    public int getNenner() {
        return nenner;
    }

    public void setNenner(int nenner) {
        if(nenner==0){
            System.out.println("Fehler, der Nenner darf nicht 0 sein!");
            nenner = 1;

        }
        this.nenner = nenner;
    }
}