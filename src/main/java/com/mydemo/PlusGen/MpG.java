package com.mydemo.PlusGen;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpG {

    private static final String PACKAGE_NAME = "com.cun.plus";

    public static void main(String[] args) {
        //1. ȫ������
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false) // �Ƿ�֧��ARģʽ
                .setAuthor("zpy") // ����
                .setOutputDir("E:\\data\\me\\my-generator\\src\\main\\java\\com\\mydemo\\base") // ����·��
                .setFileOverride(true) // �ļ�����
                .setIdType(IdType.AUTO) // ��������
                .setServiceName("%sService") // �������ɵ�service�ӿڵ����ֵ�����ĸ�Ƿ�ΪI
                // IUserService
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setOpen(false);

        //2. ����Դ����
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) // �������ݿ�����
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://172.17.38.227/szbaoan?characterEncoding=UTF-8")
                .setUsername("root")
                .setPassword("Intel@123456");

        //3. ��������
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //ȫ�ִ�д����
                .setDbColumnUnderline(true) // ָ������ �ֶ����Ƿ�ʹ���»���
                .setNaming(NamingStrategy.underline_to_camel) // ���ݿ��ӳ�䵽ʵ�����������
                .setTablePrefix("tb_")
                .setInclude("ait_accident"); // ���ɵı�

        //4. ������������
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(PACKAGE_NAME)
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");

        //5. ��������
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. ִ��
        ag.execute();
    }

}