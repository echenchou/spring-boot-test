package ec.boot;
import org.springframework.boot.builder.SpringApplicationBuilder;  
import org.springframework.boot.context.web.SpringBootServletInitializer;  
  
/** 
* TODO 发布war包时需要此类作为servlet容器启动的初始化类，并添加springboot的启动器。
* 
* @coder ECHEN 
* @date 2016年5月12日 上午9:07:59
*/
public class ServletInitializer extends SpringBootServletInitializer {  
  
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  
  
}  