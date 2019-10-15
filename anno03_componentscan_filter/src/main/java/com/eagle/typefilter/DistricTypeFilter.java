package com.eagle.typefilter;

import com.eagle.annotation.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Properties;

/**
 * 创建时间: 2019/10/15,15:55
 * 工程师: EagleMao
 * 功效: 自定义扫描规则过滤器
 */
public class DistricTypeFilter extends AbstractTypeHierarchyTraversingFilter{

    //定义路径校验对象
    private PathMatcher pathMatcher;

    /**
     *  定义区域的名称,应该从配置文件中获取
     *  但是不能使用@value 读取properties 文件
     *  因为负责填充属性的 InstantiationAwareBeanPostProcessor 与 TypeFilter 实例创建没有关系
     */
    private String districtName;

    public DistricTypeFilter() {

        /**
         * 调用父类的构造函数
         * 第一个参数 considerInherited    不考虑基类
         * 第二个参数 considerInterfaces   不考虑接口上的信息
         */
        super(false,false);
        //利用spring默认的resource通配符路径方式
        pathMatcher = new AntPathMatcher();
        //读取配置文件（硬编码）
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            //给districtName赋值
            districtName = properties.getProperty("common.district.name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  本类注册为Exclude ,返回true 表示拒绝
     * @param className
     * @return
     */
    @Override
    protected boolean matchClassName(String className) {
        /**
         *   判断是否在指定包下的类   只处理和区域相关的业务类
         */
        try {
            if (!isPotentialPackageClass(className)) {
                //不符合路径规则
                return false;
            }
            //判断当前区域和配置区域是否一致，不一致则不能注册到spring容器
            Class<?> clazz = ClassUtils.forName(className, DistricTypeFilter.class.getClassLoader());
            //获取district 注解
            District district = clazz.getAnnotation(District.class);
            //判断有没有注解
            if (district == null) {
                return false;
            }
            //取出注解的属性
            String districtValue = district.value();
            //校验取出的value值和配置文件中的值是否一致，则注册到ioc容器,返回true，否则放回false
            return (!districtName.equalsIgnoreCase(districtValue));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //定义可以处理类的类名，指定的package下的
    private static final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("com.eagle.service.*.*");

    /**
     *   本类逻辑中可以处理的类
     */
    private boolean isPotentialPackageClass (String className) {
        //1.将类名装换成资源路径，以匹配是否符合扫描规则
        String path = ClassUtils.convertClassNameToResourcePath(className);
        //2.校验
        return pathMatcher.match(PATTERN_STANDARD,path);
    }
}
