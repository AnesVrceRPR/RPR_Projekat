package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Exception.unosNijeIspravan;

public class UcesnikManager {

    public void spravanRejting(int rejting)
    {
        if(rejting < 0) throw new unosNijeIspravan("Rejting ne može biti manji od 0");
    }



}
