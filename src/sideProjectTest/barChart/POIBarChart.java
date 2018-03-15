package sideProjectTest.barChart;

import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.util.*;

public class POIBarChart {


    /*
     * @param position 图表坐标 起始行，起始列，终点行，重点列
     *
     * @param xString 横坐标
     *
     * @param serTxName 图形示例
     *
     * @param dataRef 柱状图数据范围 ： sheetName!$A$1:$A$12
     */
    private static void drawBarChart(XSSFSheet sheet, int[] position, List<String> xString, Set<String> serTxName,
                                     List<String> dataRef) {

        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, position[0], position[1], position[2], position[3]);

        Chart chart = drawing.createChart(anchor);

        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();

        ctBarChart.addNewVaryColors().setVal(false);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);

        // telling the Chart that it has axis and giving them Ids
        setAxIds(ctBarChart);
        // set cat axis
        setCatAx(ctPlotArea);
        // set val axis
        setValAx(ctPlotArea);
        // add legend and set legend position
        setLegend(ctChart);
        // set data lable
        setDataLabel(ctBarChart);
        // set chart title
        setChartTitle((XSSFChart) chart, sheet.getSheetName());
        // padding data to chart
        paddingData(ctBarChart, xString, serTxName, dataRef);
    }

    private static void paddingData(CTBarChart ctBarChart, List<String> xString, Set<String> serTxName,
                                    List<String> dataRef) {
        Iterator<String> iterator = serTxName.iterator();
        for (int r = 0, len = dataRef.size(); r < len && iterator.hasNext(); r++) {
            CTBarSer ctBarSer = ctBarChart.addNewSer();

            ctBarSer.addNewIdx().setVal(r);
            // set legend value
            setLegend(iterator.next(), ctBarSer.addNewTx());
            // cat ax value
            setChartCatAxLabel(ctBarSer.addNewCat(), xString);
            // value range
            ctBarSer.addNewVal().addNewNumRef().setF(dataRef.get(r));
            // add border to chart
            ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] { 0, 0, 0 });
        }
    }

    private static void setLegend(String str, CTSerTx ctSerTx) {
        if (str.contains("$"))
            // set legend by str ref
            ctSerTx.addNewStrRef().setF(str);
        else
            // set legend by str
            ctSerTx.setV(str);
    }

    private static void paddingData(CTLineChart ctLineChart, List<String> xString, Set<String> serTxName,
                                    List<String> dataRef) {
        Iterator<String> iterator = serTxName.iterator();
        for (int r = 0, len = dataRef.size(); r < len && iterator.hasNext(); r++) {
            CTLineSer ctLineSer = ctLineChart.addNewSer();
            ctLineSer.addNewIdx().setVal(r);
            setLegend(iterator.next(), ctLineSer.addNewTx());
            setChartCatAxLabel(ctLineSer.addNewCat(), xString);
            ctLineSer.addNewVal().addNewNumRef().setF(dataRef.get(r));
            ctLineSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] { 0, 0, 0 });
        }
    }

    private static void setChartCatAxLabel(CTAxDataSource cttAxDataSource, List<String> xString) {
        if (xString.size() == 1) {
            cttAxDataSource.addNewStrRef().setF(xString.get(0));
        } else {
            CTStrData ctStrData = cttAxDataSource.addNewStrLit();
            for (int m = 0, xlen = xString.size(); m < xlen; m++) {
                CTStrVal ctStrVal = ctStrData.addNewPt();
                ctStrVal.setIdx((long) m);
                ctStrVal.setV(xString.get(m));
            }
        }
    }

    private static void setDataLabel(CTBarChart ctBarChart) {
        setDLShowOpts(ctBarChart.addNewDLbls());
    }

    private static void setDataLabel(CTLineChart ctLineChart) {
        CTDLbls dlbls = ctLineChart.addNewDLbls();
        setDLShowOpts(dlbls);
        setDLPosition(dlbls, null);
    }

    private static void setDLPosition(CTDLbls dlbls, STDLblPos.Enum e) {
        if (e == null)
            dlbls.addNewDLblPos().setVal(STDLblPos.T);
        else
            dlbls.addNewDLblPos().setVal(e);
    }

    private static void setDLShowOpts(CTDLbls dlbls) {
        // 添加图形示例的字符串
        dlbls.addNewShowSerName().setVal(false);
        // 添加x轴的坐标字符串
        dlbls.addNewShowCatName().setVal(false);
        // 添加图形示例的图片
        dlbls.addNewShowLegendKey().setVal(false);
        // 添加x对应y的值---全设置成false 就没什么用处了
        // dlbls.addNewShowVal().setVal(false);
    }

    private static void setAxIds(CTBarChart ctBarChart) {
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);
    }

    private static void setAxIds(CTLineChart ctLineChart) {
        ctLineChart.addNewAxId().setVal(123456);
        ctLineChart.addNewAxId().setVal(123457);
    }

    private static void setLegend(CTChart ctChart) {
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
    }

    private static void setCatAx(CTPlotArea ctPlotArea) {
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); // id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); // id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

    }

    // 不要y轴的标签，或者y轴尽可能的窄一些
    private static void setValAx(CTPlotArea ctPlotArea) {
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); // id of the val axis
        CTScaling ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        // 不现实y轴
        ctValAx.addNewDelete().setVal(true);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); // id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
    }

    // 图标标题
    private static void setChartTitle(XSSFChart xchart, String titleStr) {
        CTChart ctChart = xchart.getCTChart();

        CTTitle title = CTTitle.Factory.newInstance();
        CTTx cttx = title.addNewTx();
        CTStrData sd = CTStrData.Factory.newInstance();
        CTStrVal str = sd.addNewPt();
        str.setIdx(123459);
        str.setV(titleStr);
        cttx.addNewStrRef().setStrCache(sd);

        ctChart.setTitle(title);
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


