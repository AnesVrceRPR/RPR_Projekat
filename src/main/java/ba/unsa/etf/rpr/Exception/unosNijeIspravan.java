package ba.unsa.etf.rpr.Exception;

/**
 * Korisnicki definisan Exception
 */

public class unosNijeIspravan extends RuntimeException{

    public unosNijeIspravan(String poruka){
        super(poruka);
    }
}
