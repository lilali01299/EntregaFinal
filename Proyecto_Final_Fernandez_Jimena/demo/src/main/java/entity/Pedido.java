package entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private int cantidad;
    private static int contador = 1;

    private List<LineaPedido> lineas;


    public Pedido() {
        this.idPedido = contador++;
        this.lineas = new ArrayList<>();
    }
    public void agregarLinea (LineaPedido linea) {
        lineas.add (linea);
    }
    public double getTotal() {
        double total = 0;
        for (LineaPedido lp : lineas) {
            total += lp.getSubtotal();
        }
        return total;
    }


    public List<LineaPedido> getLineas() {
        return lineas;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido ID: " + idPedido + "\n");
        for (LineaPedido lp : lineas) {
            sb.append("  ").append(lp).append("\n");
        }
        sb.append("  TOTAL: $").append(getTotal());
        return sb.toString();
    }


}
