package config;

import com.eagle.annotation.District;
import com.eagle.typefilter.DistricTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 创建时间: 2019/10/15,15:42
 * 工程师: EagleMao
 * 功效:
 */
@Configuration
@ComponentScan(value = "com.eagle" , excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,classes = DistricTypeFilter.class))
public class SpringConfiguration {
}
