package br.com.sistema.mgs.dao;

import br.com.sistema.mgs.model.Orcamento;
import br.com.sistema.mgs.view.FrmOrcamento;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class OrcamentoDAO {
  
    public void ImprimirOrcamento(List lista){
        
        String src = "relatorios/orcamentos.jasper";
        InputStream relJasper = getClass().getClassLoader().getResourceAsStream(src);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
        
       if(relJasper == null){
           System.out.println("Arquivo não encontrado: " + src);
           return;
       }
       
        Map parametros = new HashMap();
        InputStream inputStreamDaImagem = null;
        String caminhoImagem = "relatorios/logo.pnp";
        try {
            File file = new File(caminhoImagem);
            if(file.exists()){
                inputStreamDaImagem = new FileInputStream(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        parametros.put("logo", inputStreamDaImagem);
        
        JasperPrint impressao = null;

        try {
            impressao = JasperFillManager.fillReport(relJasper, parametros, ds);
            JasperViewer viewer = new JasperViewer(impressao, false);
            viewer.setVisible(true);
            
        } catch (JRException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
