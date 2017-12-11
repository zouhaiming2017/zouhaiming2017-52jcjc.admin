package com.jixi.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 截取两位小数
 * Created by zhm on 2017/11/27.
 */
public class DoubleFormatUtil {
    public static void main(String[] args) {
//        System.out.println(getFormatDouble("999.8848899990001"));
        System.out.println("若为此弦声寄入一段情\n" +
                "北星遥远与之呼应\n" +
                "再为你取出这把桐木琴\n" +
                "我又弹到如此用心\n" +
                "为我解开脚腕枷锁的那个你\n" +
                "哼着陌生乡音走在宫闱里\n" +
                "我为君王抚琴时转头看到你\n" +
                "弦声中深藏初遇的情绪\n" +
                "月光常常常常到故里\n" +
                "送回多少离人唏嘘\n" +
                "咽着你喂给我那勺热粥\n" +
                "这年月能悄悄的过去\n\n" +

                "灯辉摇曳满都城听着雨\n" +
                "夜风散开几圈涟漪\n" +
                "你在门外听我练这支曲\n" +
                "我为你备一件蓑衣\n" +
                "琴声传到寻常百姓的家里\n" +
                "有人欢笑有人在哭泣\n" +
                "情至深处我也落下了泪一滴\n" +
                "随弦断复了思乡的心绪\n\n" +

                "你挽指做蝴蝶从窗框上飞起\n" +
                "飞过我指尖和眉宇\n" +
                "呼吸声只因你渐渐宁静\n" +
                "吹了灯让我拥抱着你\n" +
                "冬至君王释放我孤身归故地\n" +
                "我背着琴步步望回宫闱里\n" +
                "你哼起我们熟知的那半阙曲\n" +
                "它夹杂着你低沉的抽泣\n\n" +

                "路途长长长长至故里\n" +
                "是人走不完的诗句\n" +
                "把悲欢谱作曲为你弹起\n" +
                "才感伤何为身不由己\n" +
                "月光常常常常照故里\n" +
                "我是放回池中的鱼\n" +
                "想着你喂给我那勺热粥\n" +
                "这回忆就完结在那里\n" +
                "这年月依旧悄悄过去");
    }


    /**
     * 截取两位小数，四舍五入（参数为字符型，导入用）
     * @param s
     * @return
     */
    public static Double getFormatDouble(String s){
        if(s.replace(" ","").equals("")){
            return 0.0;
        }else {
            Double sd=Double.parseDouble(s.replace(" ",""));
            DecimalFormat df = new DecimalFormat(".##");
            return Double.parseDouble(df.format(sd));
        }
    }

    /**
     * 保留两位小数，四舍五入（参数为Double型统计合计用）
     */
    public static Double getFormatSums (Double num) {
        //判断是不是数字，是否为空，若是则为0
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(num+"");

        if(num==null||num.equals("")|| isNum.matches()){
            num=0.0;
        }
        //保留两位小数
        DecimalFormat df = new DecimalFormat(".##");
        return Double.parseDouble(df.format(num));
    }
}
