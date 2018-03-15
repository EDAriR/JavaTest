package sideProjectTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class ExcelBarChart {

    public void createExcelHaveBarChart(List<Data> datas) {

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");

        setExcelBody(sheet, datas);

//        Sheet barSheet = wb.createSheet("BarSheet1");

        Drawing drawing = sheet.createDrawingPatriarch();
        // 圖表大小
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 20, 40);

        Chart chart = drawing.createChart(anchor);

        CTChart ctChart = ((XSSFChart)chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        // COL 直的 BAR 橫的
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);


        CTBarSer ctBarSer = null;
        CTSerTx ctSerTx = null;
        CTStrRef ctStrRef = null;


        for (int r = 0; r < datas.size(); r++) {


            ctBarSer = ctBarChart.addNewSer();
            ctSerTx = ctBarSer.addNewTx();
            ctStrRef = ctSerTx.addNewStrRef();


            ctStrRef.setF("Sheet1!$A$" + r);
            ctBarSer.addNewIdx().setVal(r);


            CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();

            // 柱子 正下的字
            ctStrRef = cttAxDataSource.addNewStrRef();
            ctStrRef.setF("Sheet1!$B$1:$D$1");
//            ctStrRef.setF("Sheet1!$A$" + r);

            CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
//            ctNumRef.setF("Sheet1!$B$" + r + ":$D$" + r);

            //值 A-Z AA-AZ 橫的列 1-N 直的行
            System.out.println(r);
            switch (r){
                case 2:
                    ctNumRef.setF("Sheet1!$B$2:$B$5");
                    break;
                case 3:
                    ctNumRef.setF("Sheet1!$C$2:$C$5");
                    break;
                case 4:
                    ctNumRef.setF("Sheet1!$D$2:$D$5");
                    break;
                default:
            }

            //at least the border lines in Libreoffice Calc ;-)
            // 柱子 框框顏色 bar color
            ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});

        }

        //telling the BarChart that it has axes and giving them Ids
        // bar 下面的字
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(5);
//
        //cat axis
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(1000000000); //id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(555); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
//
//        //legend
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
//
//        System.out.println(ctChart);

        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("BarChart.xlsx");
            System.out.println("success");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setExcelBody(Sheet sheet, List<Data> datas) {

        Row row;
        Cell cell;

        row = sheet.createRow(0);
        row.createCell(0).setCellValue("地區");
        row.createCell(1).setCellValue("血壓（男）");
        row.createCell(2).setCellValue("血壓（女）");
        row.createCell(3).setCellValue("血壓（合計）");

        int index = 0;
        for(Data d:datas){
            System.out.println("index: " + index);
            System.out.println(d.getUnitName());

            row = sheet.createRow(index+1);
            System.out.println("index+1 : " + index);


            row.createCell(0).setCellValue(d.getUnitName());
            row.createCell(1).setCellValue(d.getMaleNumber());
            row.createCell(2).setCellValue(d.getFamaleNumber());

            index++;
            System.out.println("index ++ :" + index);
        }
    }

    public static void main(String[] args) {

        ArrayList<Data> datas = setDatas();

        ExcelBarChart ebc = new ExcelBarChart();
        ebc.createExcelHaveBarChart(datas);
    }

    private static ArrayList<Data> setDatas() {


        ArrayList<Data> datas  = new ArrayList<>();

        Data data = new Data();
        data.setUnitName("unti_1");
        data.setFamaleNumber(new Random().nextInt(20));
        data.setMaleNumber(new Random().nextInt(20));
        datas.add(data);
        Data data2 = new Data();
        data2.setUnitName("unti_2");
        data2.setFamaleNumber(new Random().nextInt(20));
        data2.setMaleNumber(new Random().nextInt(20));
        datas.add(data2);
        Data data3 = new Data();
        data3.setUnitName("unti_3");
        data3.setFamaleNumber(new Random().nextInt(20));
        data3.setMaleNumber(new Random().nextInt(20));
        datas.add(data3);

        for(Data d:datas)
            System.out.println("rrr  : " + d.getUnitName());

        return datas;
    }
}
class Data{

    private String unitName;
    private int maleNumber;
    private int famaleNumber;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getMaleNumber() {
        return maleNumber;
    }

    public void setMaleNumber(int maleNumber) {
        this.maleNumber = maleNumber;
    }

    public int getFamaleNumber() {
        return famaleNumber;
    }

    public void setFamaleNumber(int famaleNumber) {
        this.famaleNumber = famaleNumber;
    }
}