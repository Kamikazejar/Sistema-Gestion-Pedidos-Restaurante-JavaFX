/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1algoritmoyestructuras;

public class Pedido {
    private int id;
    private String nombre;
    private String detalle;
    private int telefono;
    private int precioTotal;
    private boolean pagado;
    private boolean cocinado;
    private boolean entregado;
    private String  StreetorPay;    

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public void setCocinado(boolean cocinado) {
        this.cocinado = cocinado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public boolean isCocinado() {
        return cocinado;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getId() {
        return id;
    }

    public Pedido(int id, String nombre, String detalle, int telefono, int precioTotal, boolean pagado, boolean cocinado, boolean entregado, String StreetorPay) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.telefono = telefono;
        this.precioTotal = precioTotal;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.StreetorPay = StreetorPay;
    }
}
