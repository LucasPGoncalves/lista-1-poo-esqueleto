package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoef; //Button representa botoes
    private Label p1x, p2x, p1y, p2y,Ca,Cl; //Label representam rótulos
    private TextField textp1x, textp2x, textp1y, textp2y , coefL, coefA,aux; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        aux = new TextField();
        aux.setEditable(false);
        aux.setText("Insira o valor dos pontos abaixo para calcular o Coef Angular e Linear");
        p1x = new Label("P1.x");
        p2x = new Label("P2.x");
        p1y = new Label("P1.y");
        p2y = new Label("P2.y");
        Ca = new Label("Coef Angular");
        coefA = new TextField();
        coefA.setEditable(false);
        coefA.setText("");
        Cl = new Label("Coef Linear");
        coefL = new TextField();
        coefL.setEditable(false);
        coefL.setText("");
        textp1x = new TextField();
        textp2x = new TextField();
        textp1y = new TextField();
        textp2y = new TextField();


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal1 = new HBox(p1x, textp1x,p1y, textp1y);
        HBox grupoHorizontal2 = new HBox(p2x, textp2x,p2y, textp2y);
        HBox grupoHorizontal3 = new HBox(Ca, coefA, Cl, coefL);


        //Criamos o botão
        btnCalcCoef = new Button("Calcular Coeficientes");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoef.setOnAction(evento -> {
            Ponto p1 = new Ponto(Double.parseDouble(textp1x.getText()),Double.parseDouble(textp1y.getText()));
            Ponto p2 = new Ponto(Double.parseDouble(textp2x.getText()),Double.parseDouble(textp2y.getText()));
            Reta reta = new Reta(p1,p2);

            coefA.setText(reta.calculaAngular());
            coefL.setText(reta.calculaLinear());
        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(aux,grupoHorizontal1, grupoHorizontal2,grupoHorizontal3,btnCalcCoef);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
       Scene scene = new Scene(layoutFinal, 500 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
