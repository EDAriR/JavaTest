package sideProjectTest;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class StringNull {

    public static final Map<String, String> getBusinessCode =
            new ImmutableMap.Builder<String, String>()
                    .put("1100", "061100") // 軍人
                    .put("1200", "061200") // 警察
                    .put("1300", "061300") // 公共行政
                    .put("1400", "061400") // 教育機構
                    .put("1410", "061410") // 學生
                    .put("1500", "061500") // 工商服務
                    .put("15A0", "0615A0") // 農林漁牧
                    .put("15B0", "0615B0") // 礦石土石採取
                    .put("15C0", "0615C0") // 製造業
                    .put("15D0", "0615D0") // 水電燃氣業
                    .put("15E0", "0615E0") // 營造業
                    .put("15F0", "0615F0") // 批發零售
                    .put("15G0", "0615G0") // 住宿餐飲
                    .put("15H0", "0615H0") // 運輸倉儲通信
                    .put("15I0", "0615I0") // 金融保險
                    .put("15J0", "0165J0") // 不動產及租賃業
                    .put("1610", "061610") // 專業服務業
                    .put("1620", "061620") // 技術服務業
                    .put("1700", "061700") // 無業、家管、退休
                    .build();

    public static void main(String[] args) {

        String custId = "A223456789";

        char g = custId.charAt(1);

        System.out.println(g == '2');

        System.out.println(getBusinessCode.get("15F0"));

    }
}
