/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1algoritmoyestructuras;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USUARIO
 */
public class Lab1AlgoritmoyEstructuras extends Application implements EventHandler<ActionEvent>  {
    private Stage frame;
    private Scene Scene1, Scene2, Scene3;
    private Button buttoncocina, buttoncaja, buttondespachar, buttoncocina2, buttoncaja2, buttondespachar2;
    String auxiliarorden = "";
    //boolean metodopago=false;
    String metodopago="";
    int idorden=1;
    TextArea textareaid = new TextArea();
    TextArea textareaidEntregar = new TextArea();
    ArrayList<Pedido> Ordenes = new ArrayList<Pedido>();
    
    @Override
    public void start(Stage primeraescena) {
        frame= primeraescena;
      
        //SCENE 1(CAJERO)
        buttoncocina = new Button("Cocinero");
        buttoncocina.setOnAction(this);
      
        buttondespachar = new Button("Despachar");
        buttondespachar.setOnAction(this);
        
        Button buttonentregar = new Button("Entregar orden");
        
        Label labelcajero = new Label("Agregar pedido");
        
        Label labelname = new Label("Nombre cliente");
        Label labelphone = new Label("Telefono cliente");
        Label labelstreet = new Label("Direccion cliente");
        Label labelpedido = new Label("Detalle pedido");
        Label labeltotal = new Label("Precio total ");
        Label labelpay = new Label("Forma de pago");
        
        TextField textfieldname = new TextField();
        textfieldname.setPrefWidth(160);
        textfieldname.setMaxWidth(160);
        
        TextField textfieldphone = new TextField();
        textfieldphone.setPrefWidth(100);
        textfieldphone.setMaxWidth(100);
        
        TextField textfieldstreet = new TextField();
        textfieldstreet.setPrefWidth(160);
        textfieldstreet.setMaxWidth(160);
        
        TextField textfieldpedido = new TextField();
        textfieldpedido.setPrefWidth(160);
        textfieldpedido.setMaxWidth(160);
        
        TextField textfieldtotal = new TextField();
        textfieldtotal.setPrefWidth(100);
        textfieldtotal.setMaxWidth(100);
        
        ToggleGroup toggleg = new ToggleGroup();
        RadioButton radiobutton1 = new RadioButton("Orden presencial");
        RadioButton radiobutton2 = new RadioButton("Orden domiciliar");
        radiobutton1.setToggleGroup(toggleg);
        radiobutton2.setToggleGroup(toggleg);
        

        
        
        ToggleGroup toggleg2 = new ToggleGroup();
        RadioButton radiobuttoncash = new RadioButton("Efectivo");
        RadioButton radiobuttoncard = new RadioButton("Tarjeta");
        radiobuttoncash.setToggleGroup(toggleg2);
        radiobuttoncard.setToggleGroup(toggleg2);
        
        radiobuttoncash.setOnAction(e -> {
            metodopago="cash";
        });

        radiobuttoncard.setOnAction(e -> {
            metodopago="card";
        });
       
       
        
        
        
        
        
        
        StackPane Stcajero = new StackPane(); 
        Stcajero.getChildren().addAll(buttoncocina,buttondespachar,labelcajero,radiobutton1,radiobutton2,
                labelname,labelphone,labelpedido,labeltotal,textfieldname,textfieldphone,textfieldpedido, 
                textfieldtotal,buttonentregar);
        
        Stcajero.setMargin(buttoncocina, new Insets(-520,450, 0, 0));
        Stcajero.setMargin(buttondespachar, new Insets(-520,200, 0, 0));
        Stcajero.setMargin(labelcajero, new Insets(-420,450, 0, 0));
        Stcajero.setMargin(radiobutton1, new Insets(-320,450, 0, 0));
        Stcajero.setMargin(radiobutton2, new Insets(-220,450, 0, 0));
        Stcajero.setMargin(labelname, new Insets(-420,0, 0, 0));
        Stcajero.setMargin(textfieldname, new Insets(-420,-260, 0, 0));
        Stcajero.setMargin(labelphone, new Insets(-320,0, 0, 0));
        Stcajero.setMargin(textfieldphone, new Insets(-320,-200, 0, 0));
        Stcajero.setMargin(labelstreet, new Insets(-220,0, 0, 0));
        Stcajero.setMargin(textfieldstreet, new Insets(-220,-260, 0, 0));
        Stcajero.setMargin(labelpedido, new Insets(-120,0, 0, 0));
        Stcajero.setMargin(textfieldpedido, new Insets(-120,-260, 0, 0));
        Stcajero.setMargin(labelpay, new Insets(-20,0, 0, 0));
        Stcajero.setMargin(radiobuttoncash, new Insets(-20,-180, 0, 0));
        Stcajero.setMargin(radiobuttoncard, new Insets(-20,-350, 0, 0));
        Stcajero.setMargin(labeltotal, new Insets(80,0, 0, 0));
        Stcajero.setMargin(textfieldtotal, new Insets(80,-200, 0, 0));
        Stcajero.setMargin(buttonentregar, new Insets(200,-200, 0, 0));
      //  Stcajero.getChildren().remove(buttoncocina);
       // Stcajero.getChildren().add(buttoncocina);
       
               // si se apreta botton redondo presencial...
        radiobutton1.setOnAction(e -> {
          Stcajero.getChildren().remove(labelstreet);
          Stcajero.getChildren().remove(textfieldstreet);
          Stcajero.getChildren().add(labelpay);
          Stcajero.getChildren().add(radiobuttoncash);
          Stcajero.getChildren().add(radiobuttoncard);
          auxiliarorden= "Presencial";
        
        });
        
         // si se apreta boton redondo domiciliar..
        radiobutton2.setOnAction(e -> {
          Stcajero.getChildren().remove(labelpay);
          Stcajero.getChildren().remove(radiobuttoncash);
          Stcajero.getChildren().remove(radiobuttoncard);
          Stcajero.getChildren().add(labelstreet);
          Stcajero.getChildren().add(textfieldstreet);
          auxiliarorden="Domiciliar";
        
        });
        
         buttonentregar.setOnAction(e -> {
             
            String name = textfieldname.getText();
            String phone = textfieldphone.getText();
            String street = textfieldstreet.getText();
            int numphone = 0;
            int numtotal = 0;
            String pedido = textfieldpedido.getText();
            String total = textfieldtotal.getText();
            
             if ((name == "") || (phone == "") || (pedido == "") || (total == "")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error en nuevo pedido");
                alert.setHeaderText("Error al momento de ordenar ");
                alert.setContentText("Rellene todo los campos.");
                alert.showAndWait();

            } else if (auxiliarorden == "") {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error en nuevo pedido");
                alert.setHeaderText("Error al momento de ordenar ");
                alert.setContentText("Elija presencial o domicilio.");
                alert.showAndWait();
            }else if ((!(ComprobarNumero(phone))) || !(ComprobarNumero(total))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error en nuevo pedido");
                alert.setHeaderText("Error al momento de ordenar");
                alert.setContentText("Ingrese un numero valido en telefono o en total");
                alert.showAndWait();
          
            }else{
                numphone = Integer.parseInt(phone);
                numtotal = Integer.parseInt(total);
               if(auxiliarorden=="Presencial"){
                   if(metodopago==""){
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setTitle("Error en nuevo pedido");
                       alert.setHeaderText("Error al momento de ordenar");
                       alert.setContentText("Elija con quien pagar");
                       alert.showAndWait();                   
                   }else{
                       Pedido orden = new Pedido(idorden,name, pedido,numphone,numtotal, false, false, false, metodopago);
                       Ordenes.add(orden);
                       textareaid.setText(IDsAcocinar());
                       idorden += 1;
                       textfieldname.setText("");
                       textfieldphone.setText("");
                       textfieldstreet.setText("");
                       textfieldpedido.setText("");
                        toggleg.selectToggle(null);
                        toggleg2.selectToggle(null);
                        textfieldtotal.setText("");
                        metodopago = "";
                        auxiliarorden= "";
                        Stcajero.getChildren().remove(labelstreet);
                        Stcajero.getChildren().remove(textfieldstreet);
                        Stcajero.getChildren().remove(labelpay);
                        Stcajero.getChildren().remove(radiobuttoncash);
                        Stcajero.getChildren().remove(radiobuttoncard);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Pedido Listo");
                        alert.setHeaderText("Pedido Exitoso");
                        alert.setContentText("Se ingreso el pedido con id: "+ (idorden-1));
                        alert.showAndWait();

                   
                   
                   
                   }
               }else if(auxiliarorden=="Domiciliar"){
                   if(street==""){
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setTitle("Error en nuevo pedido");
                       alert.setHeaderText("Error al momento de ordenar");
                       alert.setContentText("Ingrese domicilio");
                       alert.showAndWait();           
                   
                   
                   }else{
                       Pedido orden = new Pedido(idorden,name, pedido,numphone,numtotal, false, false, false, street);
                       Ordenes.add(orden);
                       textareaid.setText(IDsAcocinar());
                       
                       idorden += 1;
                       textfieldname.setText("");
                       textfieldphone.setText("");
                       textfieldstreet.setText("");
                       textfieldpedido.setText("");
                        toggleg.selectToggle(null);
                        toggleg2.selectToggle(null);
                        textfieldtotal.setText("");
                        metodopago = "";
                        auxiliarorden= "";
                        Stcajero.getChildren().remove(labelstreet);
                        Stcajero.getChildren().remove(textfieldstreet);
                        Stcajero.getChildren().remove(labelpay);
                        Stcajero.getChildren().remove(radiobuttoncash);
                        Stcajero.getChildren().remove(radiobuttoncard);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Pedido Listo");
                        alert.setHeaderText("Pedido Exitoso");
                        alert.setContentText("Se ingreso el pedido con id: "+ (idorden-1));
                        alert.showAndWait();
                   
                   
                   
                   }
               
               
               
               
               
               }
            
            
            
            }
         
         });
        
      
        //SCENE 2(COCINA)
        buttoncaja = new Button("Cajero");
        buttoncaja.setOnAction(this);
     
      
        buttondespachar2 = new Button("Despachar");
        buttondespachar2.setOnAction(this);
        
        Label labelID = new Label("ID orden");
        Label idcocinar = new Label("Ingrese orden a cocinar");
        
        
        textareaid.setEditable(false);
        textareaid.setMaxWidth(100);
        textareaid.setMaxHeight(300);
        
        TextField areaidcocina = new TextField();
        areaidcocina.setMaxWidth(50);
        areaidcocina.setMaxHeight(20);
        
        Button detalle = new Button("Ver Detalle");
        
        TextArea textoDetalle = new TextArea();
        textoDetalle.setEditable(false);
        textoDetalle.setMaxWidth(300);
        textoDetalle.setMaxHeight(200);
        
        Button listo = new Button("Orden Lista");
     
     
   
        StackPane Stcocina = new StackPane();
        Stcocina.getChildren().addAll(buttoncaja,buttondespachar2,labelID,idcocinar,textareaid,areaidcocina,detalle,textoDetalle,listo);
        Stcocina.setMargin(buttoncaja, new Insets(-520,450, 0, 0));
        Stcocina.setMargin(buttondespachar2, new Insets(-520,200, 0, 0));
        Stcocina.setMargin(labelID, new Insets(-420,450, 0, 0));
        Stcocina.setMargin(idcocinar, new Insets(-420,0, 0, 0));
        Stcocina.setMargin(textareaid, new Insets(-50,450, 0, 0));
        Stcocina.setMargin(areaidcocina, new Insets(-420,-200, 0, 0));
        Stcocina.setMargin(detalle, new Insets(-350,-200, 0, 0));
        Stcocina.setMargin(textoDetalle, new Insets(-100,-200, 0, 0));
        Stcocina.setMargin(listo, new Insets(140,-400, 0, 0));
        
        detalle.setOnAction(e -> {
          String idstring = areaidcocina.getText();
          int id=0;
          if(idstring==""){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error ");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("Introduzca un id");
              alert.showAndWait();
          
          
          }else if(ComprobarNumero(idstring)==false){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("ID invalido");
              alert.showAndWait();  
          
          
          
          }else{
              id = Integer.parseInt(idstring);
              String encontrado="No";
              String detallePedido="";
              for (Pedido p : Ordenes) {
                  if(p.getId() == id){
                      detallePedido= p.getDetalle();
                      encontrado="Si";
                      break;
                  }
              }
              if(encontrado=="No"){
                  textoDetalle.setText("");
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Error detalle pedido");
                  alert.setHeaderText("Error con ver el detalle del pedido");
                  alert.setContentText("No se encontro el id");
                  alert.showAndWait();   
        
                  
              }else{
                  textoDetalle.setText(detallePedido);
              }
                 
          
          
          
          }
    
         });
        
        listo.setOnAction(e -> {
            String idstring = areaidcocina.getText();
          int id=0;
          if(idstring==""){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error ");
              alert.setHeaderText("Error para cocinar");
              alert.setContentText("Introduzca un id");
              alert.showAndWait();
          
          
          }else if(ComprobarNumero(idstring)==false){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error");
              alert.setHeaderText("Error para cocinar");
              alert.setContentText("ID invalido");
              alert.showAndWait();  
          
          
          
          }else{
              id = Integer.parseInt(idstring);
              String cocinado="SI";
              String detallePedido="";
              for (Pedido p : Ordenes) {
                  if(p.getId() == id && p.isCocinado()==false){
                      p.setCocinado(true);
                      textareaid.setText(IDsAcocinar());
                      textareaidEntregar.setText(IDsADespachar());
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Actualización de pedido");
                      alert.setHeaderText("Pedido cocinado!");
                      alert.setContentText("Cocinaste el pedido numero: " + idstring);
                      alert.showAndWait();
                      cocinado="No";
                      break;
                  }
              }
              if(cocinado=="SI"){
                  textoDetalle.setText("");
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Error cocinar pedido");
                  alert.setHeaderText("Error con cocinar el pedido");
                  alert.setContentText("El pedido ya esta cocinado");
                  alert.showAndWait();   
        
                  
              }
        
          }
        });
     
        //SCENE 3(DESPACHAR) 
        
        
    
        buttoncaja2 = new Button("Cajero");
        buttoncaja2.setOnAction(this);
     
      
        buttoncocina2 = new Button("Cocina");
        buttoncocina2.setOnAction(this);
        
        textareaidEntregar.setEditable(false);
        textareaidEntregar.setMaxWidth(200);
        textareaidEntregar.setMaxHeight(300);
        
        Label Adespachar = new Label("ID de ordenes a despachar");
       
        Label IDdespachar    = new Label("Ingrese ID orden a Despachar");
        TextField textfieldDespachar = new TextField();
        textfieldDespachar.setMaxWidth(100);
        textfieldDespachar.setMaxHeight(10);
        
        Button datosCliente = new Button("Ver Datos Cliente");
        Label labelName = new Label("Nombre");
        
        TextField textfieldname2 = new TextField();
        textfieldname2.setMaxWidth(100);
        textfieldname2.setMaxHeight(10);
        textfieldname2.setEditable(false);
        
        Label labelPhone= new Label("Telefono");
        
        TextField textfieldphone2 = new TextField();
        textfieldphone2.setMaxWidth(100);
        textfieldphone2.setMaxHeight(10);
        textfieldphone2.setEditable(false);
        
        Button entregado = new Button("Entregado");
     
     
        StackPane Stdespachar = new StackPane();
        Stdespachar.getChildren().addAll(buttoncaja2,buttoncocina2,Adespachar,IDdespachar,textfieldDespachar,datosCliente,
                labelName,textfieldname2,labelPhone,textfieldphone2,entregado,textareaidEntregar);
        Stdespachar.setMargin(buttoncaja2, new Insets(-520,450, 0, 0));
        Stdespachar.setMargin(buttoncocina2, new Insets(-520,200, 0, 0));
        Stdespachar.setMargin(Adespachar, new Insets(-400,300, 0, 0));
        Stdespachar.setMargin(textareaidEntregar, new Insets(-20,300, 0, 0));
        Stdespachar.setMargin(IDdespachar, new Insets(-300,-200, 0, 0));
        Stdespachar.setMargin(textfieldDespachar, new Insets(-200,-150, 0, 0));
        Stdespachar.setMargin(datosCliente, new Insets(-100,-150, 0, 0));
        Stdespachar.setMargin(labelName, new Insets(0,0, 0, 0));
        Stdespachar.setMargin(textfieldname2, new Insets(0,-160, 0, 0));
        Stdespachar.setMargin(labelPhone, new Insets(100,0, 0, 0));
        Stdespachar.setMargin(textfieldphone2, new Insets(100,-160, 0, 0));
        Stdespachar.setMargin(entregado, new Insets(200,-160, 0, 0));
        
        datosCliente.setOnAction(e -> {
            String IDdetalle = textfieldDespachar.getText();
            if(IDdetalle==""){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error ");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("Introduzca un id");
              alert.showAndWait();
          
          
          }else if(ComprobarNumero(IDdetalle)==false){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("ID invalido");
              alert.showAndWait();  
          
          
          
          }else{
              String nameC = "";
              String phoneC ="";
              int intIDdetalle = Integer.parseInt(IDdetalle);
              boolean encontrado2=false;
              
              for (Pedido p : Ordenes) {
                     if(p.getId() == intIDdetalle){
                         nameC = p.getNombre();
                         phoneC =String.valueOf(p.getTelefono());
                         encontrado2=true;
                         break;
                     }
                    
                 }
              if(encontrado2==false){
                     textfieldDespachar.setText("");
                     Alert alert = new Alert(Alert.AlertType.WARNING);
                     alert.setTitle("Error detalle pedido");
                     alert.setHeaderText("Error con ver el detalle del pedido");
                     alert.setContentText("No se encontro el id");
                     alert.showAndWait();   
                    
                 }else{
                  textfieldname2.setText(nameC);
                  textfieldphone2.setText(phoneC);
                    
                     
                 }
              
          
          
          }
            
        
        
        });
        
        entregado.setOnAction(e -> {
            String IDdetalle = textfieldDespachar.getText();
            if(IDdetalle==""){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error ");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("Introduzca un id");
              alert.showAndWait();
          
          
          }else if(ComprobarNumero(IDdetalle)==false){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error");
              alert.setHeaderText("Error para ver detalle");
              alert.setContentText("ID invalido");
              alert.showAndWait();  
          
          
          
          }else{
              int intIDdetalle = Integer.parseInt(IDdetalle);
              boolean PEntregado = true;
              for (Pedido p : Ordenes) {
                     if(p.getId() == intIDdetalle && p.isEntregado()==false){
                          p.setEntregado(true);
                          p.setPagado(true);
                         PEntregado=false;
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Pedido listo");
                         alert.setHeaderText("Pedido entregado y pagado");
                         alert.setContentText("Entregaste el pedido numero: " + intIDdetalle);
                         alert.showAndWait();
                         textareaidEntregar.setText(IDsADespachar());
                         
                         
                         break;
                     }
                    
                 }
             if(PEntregado==true){
              textoDetalle.setText("");
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Error");
              alert.setHeaderText("Error para Entregar");
              alert.setContentText("Ya se entrego ese pedido");
              alert.showAndWait();  
             
             
             
             
             }
              
          
          
          }        
        
        
        });
      

      

      
      Scene1 = new Scene(Stcajero, 600, 600);
      Scene2 = new Scene(Stcocina, 600, 600);
      Scene3 = new Scene(Stdespachar, 600, 600);
      
      
      frame.setScene(Scene1);
      frame.setResizable(false);
      frame.setTitle("Comida Rapida");
      frame.show();
    }
    
    
    /**
     * 
     * @param e Captura eventos para actualizar las escenas que se elege Scene1(Caja),Scene2(Cocina) o Scene(Despachar)
 
     */
    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == buttoncocina || e.getSource() == buttoncocina2) {
            frame.setScene(Scene2);
        } else if (e.getSource() == buttoncaja || e.getSource() == buttoncaja2) {
            frame.setScene(Scene1);
        } else if (e.getSource() == buttondespachar || e.getSource() == buttondespachar2) {
            frame.setScene(Scene3);
        } else;

    }
    /**
     * Es un metodo que devuelve un booleano dependiendo si el numero es un entero o no.
     * @param str String requerida para ver si es el string es un numero.
     * @return true o false en funcion si es num entero.
     */
    private static boolean ComprobarNumero(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex)
        {
            return false;
        }
    }
    /**
     * Es un metodo que devuelve un string con la cadena de ids a cocinar
     * @return String con los ids a cocinar
     */
     private  String IDsAcocinar(){
         String cadena=new String();
         for (Pedido p : Ordenes) {
             if(p.isCocinado() == false){
                 cadena=String.valueOf(p.getId()+"\n"+cadena);
             }
         }
         return cadena;
     }
     /**
      * Es un metodo que devuelve un string con la cadena de ids a despachar
      * @return String con los ids a despachar
      */
     private  String IDsADespachar(){
         String cadena=new String();
         for (Pedido p : Ordenes) {
             if(p.isCocinado()==true &&p.isEntregado()==false)
                 cadena =String.valueOf(p.getId()+" - No entregado"+"\n"+cadena);
             else if(p.isCocinado()==true && p.isEntregado()==true)
                 cadena =String.valueOf(p.getId()+" - Entregado "+"\n"+cadena);   
         }
         return cadena;
     }
 
    public static void main(String[] args) {
        launch(args);
    }
  
    
}
