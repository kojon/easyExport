package cn.net.chestnut.annotation;

import java.lang.annotation.*;

/**
 * Created by tarzan on 18/6/4.
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelExportField {

    /** 表头名称 **/
    String name();

    /** 表头列的下标 **/
    int index();

    /** 单元格对应的枚举类 **/
    Class<? extends Enum> enumClass() default Enum.class;

    /** 枚举的成员变量 **/
    String enumField() default "";

    /** 枚举需要展示到excel中的成员变量 **/
    String enumShowField() default "";

    /** 单元格对应json数据字典 **/
    String valueMap() default "";

    /** 表头的列宽 **/
    int width() default 12;
}
