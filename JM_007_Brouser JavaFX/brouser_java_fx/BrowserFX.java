/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package brouser_java_fx;

import br.com.jmary.utilidades.JOPM;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

/**
 *
 * @author AnaMariana
 */
public class BrowserFX extends JFXPanel{
    public String url;
    public WebViewPane WebViewPane;
    public WebView view;    
    public WebEngine eng;
    public WebHistory history;
    
    public BrowserFX( String url2 ) { // acessar_URL_Interna
        url = url2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            // create JavaFX scene
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    acessar_URL_Interna();
                }
            });      
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "BrowserFX( String url2 ), \n"
                + e.getMessage() + "\n", "BrowserFX" ); } } }.start();      
    }
    
    public BrowserFX(String url2, boolean b1) { // media_player
        url = url2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            // create JavaFX scene
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    media_player("",true);
                }
            });      
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "BrowserFX( String url2 ), \n"
                + e.getMessage() + "\n", "BrowserFX" ); } } }.start(); 
    }

    public BrowserFX(String url2, boolean b1, boolean b2) {  // acessar_URL_Externa sem histórico e sem barra de pesquisa  
        url = url2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            // create JavaFX scene
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    acessar_URL_Externa_sem_historico_sem_barra_de_pesquisa("",true,true);
                }
            });      
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "BrowserFX( String url2 ), \n"
                + e.getMessage() + "\n", "BrowserFX" ); } } }.start(); 
    }
    
    public BrowserFX(String url2, boolean b1, boolean b2, boolean b3) {  // acessar_URL_Externa com histórico e com barra de pesquisa  
        url = url2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            // create JavaFX scene
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    acessar_URL_Externa_com_historico_com_barra_de_pesquisa("",true,true,true);
                }
            });      
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "BrowserFX( String url2 ), \n"
                + e.getMessage() + "\n", "BrowserFX" ); } } }.start(); 
    }
    
    public BrowserFX(String url2, boolean b1, boolean b2, boolean b3, boolean b4) {  // setar_codigo_html  
        url = url2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            // create JavaFX scene
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    setar_codigo_html("",true,true,true,true);
                }
            });      
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "BrowserFX( String url2 ), \n"
                + e.getMessage() + "\n", "BrowserFX" ); } } }.start(); 
    }
        
    private void acessar_URL_Interna() { 
        WebViewPane = new WebViewPane( url, this );
        this.setScene(new Scene( WebViewPane ));
    } 
    
    private void media_player(String str, boolean b1) { 
        WebViewPane = new WebViewPane( url, true, this );       
        this.setScene(new Scene( WebViewPane ));       
    }
    
    private void acessar_URL_Externa_sem_historico_sem_barra_de_pesquisa(String str, boolean b1, boolean b2) { 
        WebViewPane = new WebViewPane( url, true, true, this );
        this.setScene(new Scene( WebViewPane ));
    }
    
    private void acessar_URL_Externa_com_historico_com_barra_de_pesquisa(String str, boolean b1, boolean b2, boolean b3) { 
        WebViewPane = new WebViewPane( url, true, true, true, this );
        this.setScene(new Scene( WebViewPane ));
    }
    
    private void setar_codigo_html(String str, boolean b1, boolean b2, boolean b3, boolean b4) { 
        WebViewPane = new WebViewPane( url, true, true, true, true, this );
        this.setScene(new Scene( WebViewPane ));
    }
        
}
