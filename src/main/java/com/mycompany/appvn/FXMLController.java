package com.mycompany.appvn;

import java.awt.Dimension;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import org.apache.commons.lang.StringUtils;

import com.mycompany.calData.App;
import com.mycompany.calData.barem;
import com.mycompany.calData.product;
import com.mycompany.calData.thanhphan;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class FXMLController implements Initializable {

	String beso11 = "";
	String beso12 = "";
	String tiepnhan1 = "";
	String capphat1 = "";
	String baoquan1 = "";
	String vanchuyen1 = "";
	String nhietdoBe1 = "";
	String tontheoSSBe1 = "";

	String beso21 = "";
	String beso22 = "";
	String beso23 = "";
	String tiepnhan2 = "";
	String capphat2 = "";
	String baoquan2 = "";
	String vanchuyen2 = "";
	String nhietdoBe2 = "";
	String tontheoSSBe2 = "";

	String beso31 = "";
	String beso32 = "";
	String tiepnhan3 = "";
	String capphat3 = "";
	String baoquan3 = "";
	String vanchuyen3 = "";
	String nhietdoBe3 = "";
	String tontheoSSBe3 = "";

	private product prd;

	@FXML
	TextField txtBeso11;
	@FXML
	TextField txtBeso12;
	@FXML
	TextField txtTiepNhanBs1;
	@FXML
	TextField txtCapPhatBs1;
	@FXML
	TextField txtBaoquanBs1;
	@FXML
	TextField txtVanchuyenBs1;
	@FXML
	TextField txtnhietdoBe1;
	@FXML
	TextField txttontheoSSBe1;

	@FXML
	TextField txtBeso31;
	@FXML
	TextField txtBeso32;
	@FXML
	TextField txtTiepNhanBs3;
	@FXML
	TextField txtCapPhatBs3;
	@FXML
	TextField txtBaoquanBs3;
	@FXML
	TextField txtVanchuyenBs3;
	@FXML
	TextField txtnhietdoBe3;
	@FXML
	TextField txttontheoSSBe3;

	@FXML
	TextField txtBeso21;
	@FXML
	TextField txtBeso22;
	@FXML
	TextField txtBeso23;
	@FXML
	TextField txtTiepNhanBs2;
	@FXML
	TextField txtCapPhatBs2;
	@FXML
	TextField txtBaoquanBs2;
	@FXML
	TextField txtVanchuyenBs2;
	@FXML
	TextField txtnhietdoBe2;
	@FXML
	TextField txttontheoSSBe2;

	@FXML
	private void handleSubmitButton(ActionEvent event) {
		beso11 = txtBeso11.getText();
		beso12 = txtBeso12.getText();
		tiepnhan1 = txtTiepNhanBs1.getText();
		capphat1 = txtCapPhatBs1.getText();
		baoquan1 = txtBaoquanBs1.getText();
		vanchuyen1 = txtVanchuyenBs1.getText();
		nhietdoBe1 = txtnhietdoBe1.getText();
		tontheoSSBe1 = txttontheoSSBe1.getText();

		beso21 = txtBeso21.getText();
		beso22 = txtBeso22.getText();
		beso23 = txtBeso23.getText();
		tiepnhan2 = txtTiepNhanBs2.getText();
		capphat2 = txtCapPhatBs2.getText();
		baoquan2 = txtBaoquanBs2.getText();
		vanchuyen2 = txtVanchuyenBs2.getText();
		nhietdoBe2 = txtnhietdoBe2.getText();
		tontheoSSBe2 = txttontheoSSBe2.getText();

		beso31 = txtBeso31.getText();
		beso32 = txtBeso32.getText();
		tiepnhan3 = txtTiepNhanBs3.getText();
		capphat3 = txtCapPhatBs3.getText();
		baoquan3 = txtBaoquanBs3.getText();
		vanchuyen3 = txtVanchuyenBs3.getText();
		nhietdoBe3 = txtnhietdoBe3.getText();
		tontheoSSBe3 = txttontheoSSBe3.getText();

		prd = dataReport();

		List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("beso11", prd.getBeso11());
		m.put("beso12", prd.getBeso12());
		m.put("tiepnhan1", prd.getTiepnhan1());
		m.put("capphat1", prd.getCapphat1());
		m.put("baoquan1", prd.getBaoquan1());
		m.put("vanchuyen1", prd.getVanchuyen1());
		m.put("VCF11", prd.getVCF11());
		m.put("VCF12", prd.getVCF12());
		m.put("Vthucte11", prd.getVthucte11());
		m.put("Vthucte12", prd.getVthucte12());
		m.put("V15_11", prd.getV15_11());
		m.put("V15_12", prd.getV15_12());
		m.put("nhietdo1", prd.getNhietdo1());
		m.put("tontheoSS1", prd.getTontheoSS1());
		m.put("beso21", prd.getBeso21());
		m.put("beso22", prd.getBeso22());
		m.put("beso23", prd.getBeso23());
		m.put("capphat2", prd.getCapphat2());
		m.put("tiepnhan2", prd.getTiepnhan2());
		m.put("baoquan2", prd.getBaoquan2());
		m.put("vanchuyen2", prd.getVanchuyen2());
		m.put("VCF21", prd.getVCF21());
		m.put("VCF22", prd.getVCF22());
		m.put("VCF23", prd.getVCF23());
		m.put("Vthucte21", prd.getVthucte21());
		m.put("Vthucte22", prd.getVthucte22());
		m.put("Vthucte23", prd.getVthucte23());
		m.put("V15_21", prd.getV15_21());
		m.put("V15_22", prd.getV15_22());
		m.put("V15_23", prd.getV15_23());
		m.put("nhietdo2", prd.getNhietdo2());
		m.put("tontheoSS2", prd.getTontheoSS2());
		m.put("capphat3", prd.getCapphat3());
		m.put("tiepnhan3", prd.getTiepnhan3());
		m.put("beso32", prd.getBeso32());
		m.put("beso31", prd.getBeso31());
		m.put("baoquan3", prd.getBaoquan3());
		m.put("vanchuyen3", prd.getVanchuyen3());
		m.put("tontheoSS3", prd.getTontheoSS3());
		m.put("nhietdo3", prd.getNhietdo3());
		m.put("V15_32", prd.getV15_32());
		m.put("V15_31", prd.getV15_31());
		m.put("Vthucte31", prd.getVthucte31());
		m.put("Vthucte32", prd.getVthucte32());
		m.put("VCF31", prd.getVCF31());
		m.put("VCF32", prd.getVCF32());
		m.put("thieu1", prd.getThieu1());
		m.put("thieu2", prd.getThieu2());
		m.put("thieu3", prd.getThieu3());
		// Add thanhphan into dataSource
		App app = new App();
		List<thanhphan> thanhphan = app.readThanhPhan("Data/thanhPhan.txt");
		for(int i = 0; i< thanhphan.size(); i++){
			m.put("stt"+i, thanhphan.get(i).getStt());
			m.put("tittle"+i, thanhphan.get(i).getTittle());
			m.put("tenNV"+i, thanhphan.get(i).getTenNV());
			m.put("chucvu"+i, thanhphan.get(i).getChucvu());
		}
		
		//Filling page 3
		if(!StringUtils.isEmpty(tiepnhan1)){
			Double tiepnhan1DB = (Double.parseDouble(tiepnhan1) * 0.35)/100;
			m.put("tiepnhan1DB", String.valueOf(Math.round(tiepnhan1DB)));
		}
		if(!StringUtils.isEmpty(capphat1)){
			Double capphat1DB = (Double.parseDouble(capphat1) * 0.6)/100;
			m.put("capphat1DB", String.valueOf(Math.round(capphat1DB)));
		}
		if(!StringUtils.isEmpty(baoquan1)){
			Double baoquan1DB = (Double.parseDouble(baoquan1) * 0.15)/100;
			m.put("baoquan1DB",  String.valueOf(Math.round(baoquan1DB)));
		}
		if(!StringUtils.isEmpty(vanchuyen1)){
			Double vanchuyen1DB = (Double.parseDouble(vanchuyen1) * 0.16)/100;
			m.put("vanchuyen1DB",  String.valueOf(Math.round(vanchuyen1DB)));
		}
		
		dataSource.add(m);
		JRDataSource frDataSource = new JRBeanCollectionDataSource(dataSource);
		InputStream jasperJRXML = this.getClass().getResourceAsStream("/Data/newApp_3.jrxml");

		JasperReport report;
		try {
			report = JasperCompileManager.compileReport(jasperJRXML);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, frDataSource);
			JRViewer jv = new JRViewer(jasperPrint);
			JFrame jf = new JFrame();
			jf.getContentPane().add(jv);
			jf.validate();
//			jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//			jf.setUndecorated(true);
			jf.setVisible(true);
			jf.setSize(new Dimension(1000, 800));
			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		} catch (JRException ex) { 
			System.err.println(ex);
			
		}
	}

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		txtBeso11.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		txtBeso12.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		
		txtBeso21.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		txtBeso22.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		txtBeso23.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		
		txtBeso31.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		txtBeso32.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(3));
		
		txtnhietdoBe1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(5));
		txtnhietdoBe2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(5));
		txtnhietdoBe3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(5));

		txtTiepNhanBs1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtTiepNhanBs2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtTiepNhanBs3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		
		txtCapPhatBs1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtCapPhatBs2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtCapPhatBs3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		
		txtBaoquanBs1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtBaoquanBs2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtBaoquanBs3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		
		txtVanchuyenBs1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtVanchuyenBs2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txtVanchuyenBs3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		
		txttontheoSSBe1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txttontheoSSBe2.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
		txttontheoSSBe3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
	}
	
	public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
	    return new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent e) {
	            TextField txt_TextField = (TextField) e.getSource();                
	            if (txt_TextField.getText().length() >= max_Lengh) {                    
	                e.consume();
	            }
	            if(e.getCharacter().matches("[0-9.]")){ 
	                if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
	                    e.consume();
	                }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
	                    e.consume(); 
	                }
	            }else{
	                e.consume();
	            }
	        }
	    };
	} 
    
	private product dataReport() {
		product product = new product();
		App app = new App();
		double VCF11 = 0.0;
		double VCF12 = 0.0;
		double Vthucte11 = 0.0;
		double Vthucte12 = 0.0;
		double V15_11 = 0.0;
		double V15_12 = 0.0;
		int thieu1 = 0;

		double VCF21 = 0.0;
		double VCF22 = 0.0;
		double VCF23 = 0.0;
		double Vthucte21 = 0.0;
		double Vthucte22 = 0.0;
		double Vthucte23 = 0.0;
		double V15_21 = 0.0;
		double V15_22 = 0.0;
		double V15_23 = 0.0;
		int thieu2 = 0;

		double VCF31 = 0.0;
		double VCF32 = 0.0;
		double Vthucte31 = 0.0;
		double Vthucte32 = 0.0;
		double V15_31 = 0.0;
		double V15_32 = 0.0;
		int thieu3 = 0;
		
		DecimalFormat formatDouble = new DecimalFormat("#0.00");

		try {
			List<barem> beso1 = app.readBaremFile("Data/Data_Be1.txt");
			List<barem> beso2 = app.readBaremFile("Data/Data_Be2.txt");
			List<barem> beso3 = app.readBaremFile("Data/Data_Be3.txt");
			

			if (!StringUtils.isEmpty(nhietdoBe1)) {
				VCF11 = App.convertVCF(nhietdoBe1);
				VCF12 = App.convertVCF(nhietdoBe1);
			}

			if (!StringUtils.isEmpty(nhietdoBe2)) {
				VCF21 = App.convertVCF(nhietdoBe2);
				VCF22 = App.convertVCF(nhietdoBe2);
				VCF23 = App.convertVCF(nhietdoBe2);
			}

			if (!StringUtils.isEmpty(nhietdoBe3)) {
				VCF31 = App.convertVCF(nhietdoBe3);
				VCF32 = App.convertVCF(nhietdoBe3);
			}

			if (!StringUtils.isEmpty(beso11) && !StringUtils.isEmpty(beso12)) {
				Vthucte11 = app.findInBarem(beso11, beso1);
//				Vthucte12 = app.findInBarem(beso12, beso1);
				Vthucte12 = Double.parseDouble(beso12);
				V15_11 = Vthucte11 * VCF11;
				V15_12 = Math.round(Vthucte12 * VCF12);
				
				String dx1= formatDouble.format(V15_11).replace(",", ".");
				String dx2= formatDouble.format(V15_12).replace(",", ".");
				V15_11 = Double.valueOf(dx1);
				V15_12 = Double.valueOf(dx2);
						
			}

			if (!StringUtils.isEmpty(beso21) && !StringUtils.isEmpty(beso22)&& !StringUtils.isEmpty(beso23)) {
				Vthucte21 = app.findInBarem(beso21, beso2);
				Vthucte22 = app.findInBarem(beso22, beso2);
//				Vthucte23 = app.findInBarem(beso23, beso3);
				Vthucte23 = Math.round(Double.parseDouble(beso23));

				V15_21 = Vthucte21 * VCF21;
				V15_22 = Vthucte22 * VCF22;
				V15_23 = Vthucte23 * VCF23;
				
				String dx1= formatDouble.format(V15_21).replace(",", ".");
				String dx2= formatDouble.format(V15_22).replace(",", ".");
				String dx3= formatDouble.format(V15_23).replace(",", ".");
				V15_21 = Double.valueOf(dx1);
				V15_22 = Double.valueOf(dx2);
				V15_23 = Double.valueOf(dx3);
			}

			if (!StringUtils.isEmpty(beso31) && !StringUtils.isEmpty(beso32)) {
				Vthucte31 = app.findInBarem(beso31, beso3);
//				Vthucte32 = app.findInBarem(beso32, beso3);
				Vthucte32 = Double.parseDouble(beso32);

				V15_31 = Vthucte31 * VCF31;
				V15_32 = Math.round(Vthucte32 * VCF32);
				
				String dx1= formatDouble.format(V15_31).replace(",", ".");
				String dx2= formatDouble.format(V15_32).replace(",", ".");
				V15_31 = Double.valueOf(dx1);
				V15_32 = Double.valueOf(dx2);
			}

			if (!StringUtils.isEmpty(tontheoSSBe1)) {
				BigDecimal a1 = new BigDecimal(Double.parseDouble(tontheoSSBe1));
				BigDecimal a2 = new BigDecimal(V15_11 + V15_12);
				BigDecimal thieu1Double = a1.subtract(a2);
				thieu1 = thieu1Double.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			}
			
			if (!StringUtils.isEmpty(tontheoSSBe2)) {
				BigDecimal a1 = new BigDecimal(Double.parseDouble(tontheoSSBe2));
				BigDecimal a2 = new BigDecimal(V15_21 + V15_22 + V15_23);
				BigDecimal thieu2Double = a1.subtract(a2);
				thieu2 = thieu2Double.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			}
			
			if (!StringUtils.isEmpty(tontheoSSBe3)) {
				BigDecimal a1 = new BigDecimal(Double.parseDouble(tontheoSSBe3));
				BigDecimal a2 = new BigDecimal(V15_31 + V15_32);
				BigDecimal thieu3Double = a1.subtract(a2);
				thieu3 = thieu3Double.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			}
			product.setBeso11(beso11);
			product.setBeso12(beso12);
			product.setVCF11(String.valueOf(VCF11));
			product.setVCF12(String.valueOf(VCF12));
			product.setVthucte11(String.valueOf(Vthucte11));
			product.setVthucte12(String.valueOf(Vthucte12));
			product.setV15_11(String.valueOf(V15_11));
			product.setV15_12(String.valueOf(V15_12));
			product.setCapphat1(capphat1);
			product.setBaoquan1(baoquan1);
			product.setTiepnhan1(tiepnhan1);
			product.setVanchuyen1(vanchuyen1);
			product.setNhietdo1(nhietdoBe1);
			product.setTontheoSS1(tontheoSSBe1);

			product.setBeso21(beso21);
			product.setBeso22(beso22);
			product.setBeso23(beso23);
			product.setVCF21(String.valueOf(VCF21));
			product.setVCF22(String.valueOf(VCF22));
			product.setVCF23(String.valueOf(VCF23));
			product.setVthucte21(String.valueOf(Vthucte21));
			product.setVthucte22(String.valueOf(Vthucte22));
			product.setVthucte23(String.valueOf(Vthucte23));
			product.setV15_21(String.valueOf(V15_21));
			product.setV15_22(String.valueOf(V15_22));
			product.setV15_23(String.valueOf(V15_23));
			product.setCapphat2(capphat2);
			product.setBaoquan2(baoquan2);
			product.setTiepnhan2(tiepnhan2);
			product.setVanchuyen2(vanchuyen2);
			product.setNhietdo2(nhietdoBe2);
			product.setTontheoSS2(tontheoSSBe2);
			
			product.setBeso31(beso31);
			product.setBeso32(beso32);
			product.setVCF31(String.valueOf(VCF31));
			product.setVCF32(String.valueOf(VCF32));
			product.setVthucte31(String.valueOf(Vthucte31));
			product.setVthucte32(String.valueOf(Vthucte32));
			product.setV15_31(String.valueOf(V15_31));
			product.setV15_32(String.valueOf(V15_32));
			product.setCapphat3(capphat3);
			product.setBaoquan3(baoquan3);
			product.setTiepnhan3(tiepnhan3);
			product.setVanchuyen3(vanchuyen3);
			product.setNhietdo3(nhietdoBe3);
			product.setTontheoSS3(tontheoSSBe3);
			
			product.setThieu1(Integer.toString(thieu1));
			product.setThieu2(Integer.toString(thieu2));
			product.setThieu3(Integer.toString(thieu3));
		} catch (Exception e) {
			System.out.println(e);
			
		}
		return product;
	}
}
