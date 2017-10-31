Feign中使用Hystrix，实现服务消费断路器功能
不需要在Feigh工程中引入Hystix，Feign中已经依赖了Hystrix

1) pom.xml增加Feign(spring-cloud-starter-feign)、eureka(spring-cloud-starter-eureka)配置
2) 在应用主类Application增加@EnableDiscoveryClient注解来添加发现服务能力,通过@EnableFeignClients注解开启Feign功能
3) 使用@FeignClient注解中的fallback属性指定回调类
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
4) 创建回调类ComputeClientHystrix，实现@FeignClient的接口，此时实现的方法就是对应@FeignClient接口中映射的fallback函数。
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
5) 通过Spring MVC的注解来配置compute-service服务下的具体实现。
在web层中调用上面定义的ComputeClient，具体如下：
@RestController
public class ConsumerController {
    @Autowired
    ComputeClient computeClient;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}
6) application.properties中不用变，指定eureka服务注册中心即可
spring.application.name=feign-hystrix-consumer
server.port=3633
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/


Feign增加断路器Hystrix请求服务地址：
http://10.5.2.241:3633/add
http://localhost:3633/add