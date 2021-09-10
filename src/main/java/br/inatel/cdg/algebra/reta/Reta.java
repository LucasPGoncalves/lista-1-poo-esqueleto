package br.inatel.cdg.algebra.reta;

public class Reta {

    private double coefA;

    Ponto p1,p2;

    public Reta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String calculaAngular() {
        coefA = (p2.getY()- p1.getY())/(p2.getX() - p1.getX()) ;
        String aux = String.valueOf(coefA);
        return aux;
    }

    public String calculaLinear(){
        double coefL = p1.getY() - coefA * p1.getX();
        String aux = String.valueOf(coefL);
        return aux;
    }

}
