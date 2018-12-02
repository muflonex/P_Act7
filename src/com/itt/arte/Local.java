package com.itt.arte;

public abstract class Local {
    
    private int metros;
    private int accesos;
    private String domicilio;
    
    public Local(String domicilio, int metros, int accesos ){
        this.domicilio = domicilio;
        this.metros = metros;
        this.accesos = metros;
    };
    
    @Override
    public String toString(){
        return  this.getDomicilio() + ", local de "
                + this.getMetros() + " metros, con "
                + this.getAccesos() + " accesos";
    }

    /**
     * @return the metros
     */
    public int getMetros() {
        return metros;
    }

    /**
     * @param metros the metros to set
     */
    public void setMetros(int metros) {
        this.metros = metros;
    }

    /**
     * @return the accesos
     */
    public int getAccesos() {
        return accesos;
    }

    /**
     * @param accesos the accesos to set
     */
    public void setAccesos(int accesos) {
        this.accesos = accesos;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
