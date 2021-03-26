/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

public class PropiedadesModel {

    /**
     * @return the basedatos
     */
    public String getBasedatos() {
        return basedatos;
    }

    /**
     * @param basedatos the basedatos to set
     */
    public void setBasedatos(String basedatos) {
        this.basedatos = basedatos;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    private String basedatos;
    private String usuario;
    private String clave;
    
    
}
