/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;

public class App {
    public static List<barem> readBaremFile(String path) {
        List<barem> baremList = new ArrayList<>();
        barem baremObj = new barem();
        try {
            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader(path);
                br = new BufferedReader(fr);

                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {
                    if(sCurrentLine.contains("|")){
                        System.out.println(sCurrentLine);
                        baremObj = parseBarem(sCurrentLine);

                        baremList.add(baremObj);
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (br != null)
                        br.close();
                    if (fr != null)
                        fr.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return baremList;
    }

    public static List<thanhphan> readThanhPhan(String path) {
        List<thanhphan> thanhphanList = new ArrayList<>();
        thanhphan thanhphan = new thanhphan();
        try {
            BufferedReader brTp = null;
            FileReader frTp = null;
            try {
                frTp = new FileReader(path);
                brTp = new BufferedReader(frTp);

                String sCurrentLine;

                while ((sCurrentLine = brTp.readLine()) != null) {
                    if(sCurrentLine.contains("|")){
                        System.out.println(sCurrentLine);
                        thanhphan = parseThanhPhan(sCurrentLine);

                        thanhphanList.add(thanhphan);
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (brTp != null)
                        brTp.close();
                    if (frTp != null)
                        frTp.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thanhphanList;
    }

    public String getFileWithUtil(String fileName) {
        String path = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            File file = new File(classLoader.getResource(fileName).getFile());
            path = file.getPath();
        } catch (Exception e) {
            System.out.println(e);
        }
        return path;
    }

    private static barem parseBarem(String inpString) {
        barem baremObj = new barem();
        String h = "";
        String v = "";
        String vLe = "";
        try {
            String[] arrInput = inpString.split("\\|");
            for (int i = 0; i < arrInput.length; i++) {
                if (i == 0) {
                    h = arrInput[0];
                    baremObj.setH(h);
                } else if (i == 1) {
                    v = arrInput[1];
                    baremObj.setV(v);
                } else if (i == 2) {
                    vLe = arrInput[2];
                    baremObj.setvLe(vLe);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return baremObj;
    }

    private static thanhphan parseThanhPhan(String inpString) {
        thanhphan thanhphanObj = new thanhphan();
        String stt = "";
        String title = "";
        String ten = "";
        String chucvu = "";
        try {
            String[] arrInput = inpString.split("\\|");
            for (int i = 0; i < arrInput.length; i++) {
                if (i == 0) {
                    stt = arrInput[0];
                    thanhphanObj.setStt(stt);
                } else if (i == 1) {
                    title = arrInput[1];
                    thanhphanObj.setTittle(title);
                } else if (i == 2) {
                    ten = arrInput[2];
                    thanhphanObj.setTenNV(ten);
                } else if (i == 3){
                    chucvu = arrInput[3];
                    thanhphanObj.setChucvu(chucvu);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thanhphanObj;
    }

    public static double convertVCF(String nhietdo){
        double vcf = 0.0;
        double nhietdoDb = 0.0;
        try{
            if(!StringUtils.isEmpty(nhietdo)){
                nhietdoDb = Double.parseDouble(nhietdo);
                if(nhietdoDb == 23){
                    vcf = 0.9904;
                } else {
                    vcf = 0.9904 - (nhietdoDb - 23) * 0.0012;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        return vcf;
    }

    public static double findInBarem(String Htp, List<barem> baremList){
        double Vthucte = 0.0;
        try{
            for (int i = 0; i < baremList.size(); i++){
                if(baremList.get(i).getH().equals(Htp)){
                    String Vstr = baremList.get(i).getV();
                    Vthucte = Double.parseDouble(Vstr);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return Vthucte;
    }
}

