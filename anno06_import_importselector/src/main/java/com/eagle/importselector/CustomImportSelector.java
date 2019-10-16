package com.eagle.importselector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 创建时间: 2019/10/16,15:59
 * 工程师: EagleMao
 * 功效: 自定义的导入器
 */
public class CustomImportSelector implements ImportSelector{

    //表达式（aspectj表达式）
    private String expression;

    /**
     *    m默认的构造函数 ，用于读取配置文件 ， 给表达式赋值
     */
    public CustomImportSelector () {
        try {
            //获取properties对象
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customImport.properties");
            //给expression赋值
            expression = properties.getProperty("custom.importselector.expression");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *      实现要导入类的字节码
     *      导入的过滤规则采用typeFilter 的aspectj表达式的方式
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //定义扫描包名称
        String[] basePackages = null;
        //判断有@import注解的类上有没有@componentscan注解
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())){
            //取出@componentScan注解的属性
            Map<String,Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            //取出basePackage属性
            basePackages = (String[]) attributes.get("basePackages");
        }
        //判断是否有此注解，是否指定了扫描信息
        if (basePackages == null || basePackages.length == 0) {
            String basePackage = null;
            try {
                //取出@import所在类的包的名称
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            }catch (Exception e){
                e.printStackTrace();
            }
            //把包名填充到basePackages中
            basePackages = new String[]{basePackage};
        }
        //创建类路径扫描器  false 表示不采用默认的过滤规则
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        //创建类型过滤器（使用aspectJ表达式类型的过滤器）
        TypeFilter typeFilter = new AspectJTypeFilter(expression,CustomImportSelector.class.getClassLoader());
        //把类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);
        //定义要扫描类的全限定类名的集合
        final Set<String> classes = new HashSet<String>();
        //填充集合的内容
        for (String basePackage : basePackages) {
            scanner.findCandidateComponents(basePackage).forEach(BeanDefinition -> classes.add(BeanDefinition.getBeanClassName()));
        }
        //按照方法的返回值要求，返回全限定类名的数组
        return classes.toArray(new String[classes.size()]);
    }
}
