package com.richard.java.standard;

import java.io.File;

/**
 * <code>AbstractStandardJava.java</code>
 * <p>主要是 Java 开发规范的示例代码.</p>
 *
 * <p>包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。
 * 包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式</p>
 *
 * <p>类名必须使用 UpperCamelCase 风格，遵从驼峰形式(除领域模型)，例如：MarcoPolo, UserDAO, XMLService, TCPUDPDeal
 * 若使用了设计模式，建议在类名中体现具体设计模式，例如：OrderFactory，ResourceObserver</p>
 *
 * <p>抽象类命名使用 Abstract 或 Base 开头;异常类命名使用 Exception 结尾;测试类 命名以它要测试的类的名称开始，以 Test 结尾</p>
 *
 * <p>类注释必须包含创建者信息</p>
 *
 * @author richard
 */
@SuppressWarnings("all")
public abstract class AbstractStandardJava {

    /**
     * 成员变量采用 lowerCamelCase 风格，遵从驼峰形式
     *
     * 类属性必须采用此格式注释
     */
    private String inputUserId;

    /**
     * 常量命名全部大写，单词用下划线隔开，为求表达语义，不要嫌名字长,反例：MAX_COUNT(语义不清)
     */
    private int MAX_STOCK_COUNT = 10;

    /**
     * 括号是数组类型的一部分，紧随类型之后
     */
    String[] dateArray = new String[10];

    /**
     * 布尔类型变量不要在前面加is(特别是在POJO类中)，反例: isSuccess
     */
    private Boolean success;

    /**
     * long 或者 Long 初始赋值时，必须使用大写的 L，不能是小写的 l
     */
    Long orderId = 2L;

    /**
     * 接口属性示例：不要加任何修饰符号，尽量不要在接口中定义变量
     */
    String COMPANY = "DHU";

    /**
     * 针对POJO类：所有的POJO类属性必须使用包装数据类型
     */
    private Integer count;

    /**
     * 方法名及参数名采用 lowerCamelCase 风格，遵从驼峰形式
     * 左括号和后一个字符之间不出现空格，右括号和前一个字符之间也不出现空格
     *
     * 方法参数在定义和传入时，多个参数逗号后边必须加空格
     *
     * @param userId  用户id
     * @param date  日期
     */
    public void getHttpMesssage(String userId, int date) {
        /*
         * 方法内多行注释示例
         * 局部变量采用lowerCamelCase风格，遵从驼峰形式
         * 两个声明变量的语句为相同逻辑，没必要空一行
         */
        int arrayLength = 0;
        String compareId;

        /*
         * if、for、while、switch、do等保留关键字左右括号之间必须加空格
         * 左大括号前加空格且不换行;左大括号后换行
         */
        if (arrayLength == 1) {
            //任何运算符左右必须加一个空格(含=、逻辑运算符&&、&，加减乘除，三目运算符等)
            arrayLength = 0;
        } else {
            //右大括号前换行，右大括号后有 else，不用换行

            arrayLength = 1;

            //在右大括号后直接结束，则必须换行(注: if - else 结构尽量少用)
        }

        //不要在条件判断中执行其它复杂的语句，将复杂逻辑判断的结果赋值给一个有意义的布尔变量名
        File file = new File("filePath");
        boolean fileExisted = (("filePath" != null) && (file.isFile()) || ("".equals("")));

        if (fileExisted) {
            //上述赋给 fileExisted 的值不该写入 if 之后的括号中
        }

        //方法内单行注释示例(必须单独占一行)
        StringBuilder sb = new StringBuilder("test");

        //for循环与上述的if属于不同业务逻辑，空一行区分
        for (int i = 0; i < 10; i++) {
            /*
             * 应使用常量或确定有值的对象来调用equals
             * 所有的相同类型的包装类对象之间值的比较,全部使用 equals 方法比较
             */
            if ("test".equals(userId)) {
                System.out.println("建议使用java.util.Objects#equals");
            }

            //循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展
            sb.append("hello");
        }
        sb.toString();
    }

    /**
     * 针对rpc方法：返回值和参数都必须使用包装数据类型(包装类型查询无结果为null，可以区分为0的情况)
     *
     * @param orderId
     * @return
     */
    public Integer getCountByOderId(Long orderId) {
        //所有方法：局部变量使用基本类型
        int count = 0;

        //switch 示例
        switch (count) {
            case 0:
                //用return终止case
                return 0;
            case 1:
                count++;
                //用break终止case
                break;
            case 2:
                //没有return / break, 注释说明到哪个case为止：到 case 4
            case 3:
                //到 case 4
                System.out.print("AA");
            case 4:
                // case 语句只起到语句标号作用，而不进行判断, 若 count值为 2 ，则会输出 AABB
                System.out.print("BB");
                break;
            default :
                //default语句必须包含且在最后，即使它不包含下面的break(default后面冒号空行)
                break;
        }

        //TODO : 标记人, 标记时间, [预计处理时间] 说明需要实现的功能

        //FIXME : 标记人, 标记时间, [预计修复时间] 说明代码中哪里引起的错误需要纠正

        return 0;
    }

    /**
     * 接口方法示例：不要加任何修饰符号(如果是接口，abstract应该去除)
     *
     * 抽象方法，必须要用 Javadoc 注释，除了返回值、参数、 异常说明外，还必须指出该方法做什么事情，实现什么功能(子类实现也一样)
     */
    abstract void getMessage();

    /**
     * 所有的覆写方法，必须加@Override注解
     *
     * 针对POJO类：toString方法必须实现，若继承类其他类，加上super.toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "外部正在调用或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影响";
    }

    /**
     * 内部枚举类，说明枚举类注释格式
     *
     * @author richard
     */
    static class ColorEnum {
        /**
         * 颜色id (枚举中的字段必须要有注释，说明数据项的用途)
         */
        private Integer colorId;

        /**
         * 颜色名称
         */
        private String name;
    }

}
