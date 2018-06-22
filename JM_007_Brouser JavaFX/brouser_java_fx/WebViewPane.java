/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package brouser_java_fx;

import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import jdk.nashorn.api.scripting.JSObject;

/**
 *
 * @author AnaMariana
 */
public class WebViewPane extends Pane { 
    
    BrowserFX BrowserFX;
    
    public WebViewPane( String url, BrowserFX BrowserFX2 ) { try{  // acessar_URL_Interna                   
        BrowserFX = BrowserFX2;                
        BrowserFX.view = new WebView();
        BrowserFX.eng = BrowserFX.view.getEngine();
        BrowserFX.history = BrowserFX.eng.getHistory();
        
////////////////////////////////////////////////////////////////////////////////          
        //opcoesHtppObtidas( BrowserFX.eng, url );
////////////////////////////////////////////////////////////////////////////////        
        
        BrowserFX.view.getEngine().load( url );
                 
        GridPane grid = new GridPane();
        GridPane.setConstraints(BrowserFX.view, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll( BrowserFX.view );
        getChildren().add(grid);        
    } catch( Exception e ){ e.printStackTrace(); } }
        
    WebViewPane(String url, boolean b, BrowserFX BrowserFX2 ) { try{  // media_player        
        BrowserFX = BrowserFX2;                
        BrowserFX.view = new WebView();
        BrowserFX.eng = BrowserFX.view.getEngine();
        BrowserFX.history = BrowserFX.eng.getHistory();
        
////////////////////////////////////////////////////////////////////////////////          
        //opcoesHtppObtidas( BrowserFX.eng, url );
////////////////////////////////////////////////////////////////////////////////          
             
        Media m = new Media( url );
        MediaPlayer mp = new MediaPlayer(m);
        mp.setAutoPlay(false);
        MediaControl mediaControl = new MediaControl(mp);
 
        GridPane grid = new GridPane();
        GridPane.setConstraints( mediaControl, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll( mediaControl );
        getChildren().add(grid);        
    } catch( Exception e ){ e.printStackTrace(); } }
    
    WebViewPane(String url, boolean b1, boolean b2, BrowserFX BrowserFX2 ) {  try{ // acessar_URL_Externa sem histórico e sem barra de pesquisa   
        BrowserFX = BrowserFX2;                
        BrowserFX.view = new WebView();
        BrowserFX.eng = BrowserFX.view.getEngine();
        BrowserFX.history = BrowserFX.eng.getHistory();
        
        String nova_url = "";
        if( ( url.startsWith("http://") == true )  || ( url.startsWith("https://") ) ){
            
            nova_url = url;
        }
        else{
            
            nova_url = "http://" + url;
        }
        
////////////////////////////////////////////////////////////////////////////////          
        opcoesHtppObtidas( BrowserFX.eng, nova_url );
////////////////////////////////////////////////////////////////////////////////          
                        
        ////// view.getEngine().loadContent
        BrowserFX.view.getEngine().load( nova_url );
 
        GridPane grid = new GridPane();
        GridPane.setConstraints(BrowserFX.view, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll( BrowserFX.view );
        getChildren().add(grid);
    } catch( Exception e ){ e.printStackTrace(); } }
    
    WebViewPane(String url, boolean b1, boolean b2, boolean b3, BrowserFX BrowserFX2 ) { try{  // acessar_URL_Externa com histórico e com barra de pesquisa 
        BrowserFX = BrowserFX2;                
        BrowserFX.view = new WebView();
        BrowserFX.eng = BrowserFX.view.getEngine();
        BrowserFX.history = BrowserFX.eng.getHistory();
        
        /*eng*/                       
        String nova_url = "";
        if( ( url.startsWith("http://") == true )  || ( url.startsWith("https://") ) ){
            nova_url = url;
        }
        else{
            nova_url = "http://" + url;
        }
        
////////////////////////////////////////////////////////////////////////////////          
        opcoesHtppObtidas( BrowserFX.eng, nova_url );
////////////////////////////////////////////////////////////////////////////////          
        
        /*             
        String nova_url = "";
        if( ( url.startsWith("http://") == true )  || ( url.startsWith("https://") ) ){
            nova_url = url;
        }
        else{
            nova_url = "http://" + url;
        }
        ////// view.getEngine().loadContent
        BrowserFX.view.getEngine().load( nova_url );
 
        GridPane grid = new GridPane();
        GridPane.setConstraints(BrowserFX.view, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll( BrowserFX.view );
        getChildren().add(grid);
        */
        VBox.setVgrow(this, Priority.ALWAYS);
            setMaxWidth(Double.MAX_VALUE);
            setMaxHeight(Double.MAX_VALUE);
            
            //view.setMinSize(500, 400);
            //view.setPrefSize(500, 400);
            
            
            BrowserFX.eng.load( nova_url );
            
            //eng.loadContent("");
            final TextField locationField = new TextField( nova_url );
            //locationField.setEditable(false);
            locationField.setPrefWidth( 300 );
            locationField.setMaxHeight(Double.MAX_VALUE);            
            Button goButton = new Button("IR");
            goButton.setDefaultButton(true);
            EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent event) {

                    BrowserFX.eng.load(locationField.getText().startsWith("http://") || locationField.getText().startsWith( "https://" )
                            ? locationField.getText() :
                            "http://" + locationField.getText());
                }
            };
            goButton.setOnAction(goAction);
            locationField.setOnAction(goAction);
            BrowserFX.eng.locationProperty().addListener(new ChangeListener<String>() {
                 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    locationField.setText(newValue);
                }
            });
            /*eng*/ 
            
            /*History*/ 
            final ComboBox comboBox = new ComboBox();
            BrowserFX.history.getEntries().addListener(new 
            ListChangeListener<WebHistory.Entry>() {
            @Override
            public void onChanged(Change<? extends Entry> c) {
                     c.next();
                     for (Entry e : c.getRemoved()) {
                        comboBox.getItems().remove(e.getUrl());
                    }
                    for (Entry e : c.getAddedSubList()) {
                        comboBox.getItems().add(e.getUrl());
                    }
                }
            }
            );
         
            comboBox.setPrefWidth(60);
            comboBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent ev) {
                    int offset = comboBox.getSelectionModel().getSelectedIndex() - BrowserFX.history.getCurrentIndex();
                        BrowserFX.history.go(offset);
                }
            });
            HBox toolBar = new HBox();
            toolBar.setAlignment(Pos.CENTER_LEFT);
            toolBar.getChildren().add(comboBox);
            toolBar.getChildren().add(locationField);
            toolBar.getChildren().add(goButton);
            //toolBar.getChildren().add(createSpacer());
            /*History*/ 
            
            /*grid*/ 
            GridPane grid = new GridPane();
            grid.setVgap(5);
            grid.setHgap(5);
            GridPane.setConstraints(locationField, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.SOMETIMES);
            GridPane.setConstraints(goButton,1,0);
            GridPane.setConstraints(BrowserFX.view, 0, 1, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
            grid.getColumnConstraints().addAll(
                    new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                    new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
            );
            grid.getChildren().addAll( toolBar, BrowserFX.view ); // locationField, goButton, view
            getChildren().add(grid);
            /*grid*/ 
    } catch( Exception e ){ e.printStackTrace(); } }
    
    WebViewPane(String url, boolean b1, boolean b2, boolean b3, boolean b4, BrowserFX BrowserFX2 ) { try{ // setar código html   
        BrowserFX = BrowserFX2;                
        BrowserFX.view = new WebView();
        BrowserFX.eng = BrowserFX.view.getEngine();
        BrowserFX.history = BrowserFX.eng.getHistory();
        
////////////////////////////////////////////////////////////////////////////////          
        //opcoesHtppObtidas( BrowserFX.eng, url );
////////////////////////////////////////////////////////////////////////////////          
        
        ////// view.getEngine().load
        BrowserFX.view.getEngine().loadContent( url );
 
        GridPane grid = new GridPane();
        GridPane.setConstraints(BrowserFX.view, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        grid.getColumnConstraints().addAll(
                new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
                new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true)
        );
        grid.getChildren().addAll( BrowserFX.view );
        getChildren().add(grid);
    } catch( Exception e ){ e.printStackTrace(); } }

    @Override 
    protected void layoutChildren() { try{
        List<Node> managed = getManagedChildren();
        double width = getWidth();
        double height = getHeight();
        double top = getInsets().getTop();
        double right = getInsets().getRight();
        double left = getInsets().getLeft();
        double bottom = getInsets().getBottom();
        for (int i = 0; i < managed.size(); i++) {
            Node child = managed.get(i);
            layoutInArea(child, left, top, width - left - right, height - top - bottom,
                    0, Insets.EMPTY, true, true, HPos.CENTER, VPos.CENTER);
        }
    } catch( Exception e ){ e.printStackTrace(); } }
    
    private void opcoesHtppObtidas(WebEngine webEngine, String url_str ) { try{

        webEngine.setJavaScriptEnabled(true);
        
        Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
        headers.put("Set-Cookie", Arrays.asList( "c_user=4" ) );
        URI uri = URI.create("http://mysite.com");
        java.net.CookieHandler.getDefault().put(uri, headers);
        
        JSObject jdoc = (JSObject) webEngine.getDocument(); 
                
        //JSObject window = (JSObject) webEngine.executeScript("window");
        //window.setMember("app", new JavaApplication());
        //JSObject history = (JSObject) webEngine.executeScript("history");
        //webEngine.setUserAgent("Mozilla/5.0 (Windows NT 6.1)");
        
        //Element p = (Element) ebEngine.executeScript("document.getElementById('para')");
        //p.setAttribute("style", "font-weight: bold");
        
        //webEngine.executeScript("changeBgColor();");
        
        System.out.println( webEngine.getUserAgent() );
        
    } catch( Exception e ){ e.printStackTrace(); } }
}