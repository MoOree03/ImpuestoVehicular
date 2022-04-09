/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuestovehicular;

import java.text.NumberFormat;

/**
 *
 * @author Miguel Moreno
 */
public class Impuesto {

    protected double tarifa;
    protected String impuesto;
    protected final double DESCUENTOPP = 0.10; //Pronto pago
    protected final double DESCUENTOTC = 0.60; // Translado cuenta
    protected final double DESCUENTOPU = 0.015; //Publico
    protected final int[] diaArray = {3, 17};

    public double getTarifa() {
        return tarifa;
    }

    public String getImpuesto() {
        return impuesto;
    }

    protected void CalcularTarifa(double precio) {
        if (precio > 0 && precio < 50954000) {
            tarifa = 0.015;
        }
        if (precio > 50954000 && precio < 114644000) {
            tarifa = 0.025;
        }
        if (precio > 114644000) {
            tarifa = 0.035;
        }
    }

    protected void CalcularImpuesto(double precio) {
        double doubleValor = precio * tarifa;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        impuesto = formatter.format(doubleValor);

    }

    protected void AplicaDescuento(boolean isPublic, boolean isAccount, boolean isPay) {
        impuesto = impuesto.replace("$", "");
        impuesto = impuesto.replace(",", "");

        double douImp = Double.parseDouble(impuesto);
        if (isPublic) {
            douImp *= DESCUENTOPU;
        }
        if (isAccount) {
            douImp *= DESCUENTOTC;
        }
        if (isPay) {
            douImp *= DESCUENTOPP;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        impuesto = formatter.format(douImp);
    }

}
