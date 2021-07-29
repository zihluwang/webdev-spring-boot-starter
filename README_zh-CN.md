# Web Dev Suite

一套十分有用的网络开发套件，集成了JWT以及请求头解析器。

## 用户指南

如果您向使用好这个套件，请务必确保您了解如下配置项目。

以下是JWT的配置，此套件的JWT实现采用**maven**中的`cn.vorbote:simple-jwt:1.0.2`。
通过将如下的代码添加到`pom.xml`文件中的`dependencies`节点中即可使用`simple-jwt`

```xml
<dependency>
    <groupId>cn.vorbote</groupId>
    <artifactId>simple-jwt</artifactId>
    <version>1.0.2</version>
</dependency>
```

配置项目介绍：
- `vorbote.web-dev.jwt`
  - `issuer`: 这个配置将会指定**JWT令牌的签发者**。
  - `secret`: 这个配置将会指定**令牌的验证签名**。
  
例如，您可以将如下代码添加到`springboot`项目的配置`application.yml`中
```yml
vorbote:
  web-dev:
    jwt:
      issuer: Example Issuer
      secret: exampleSecret
```
这将会指定JWT组件的签发者为`Example Issuer`，将JWT的签名密钥设置为`exampleSecret`。

您可以参考如下的Demo ![Demo1](https://dist.cq.vorbote.cn/image/png/Qv7Md6-1627578986.png)
这个Demo的运行结果如下 ![Demo2](https://dist.cq.vorbote.cn/image/png/UY5R26-1627579413.png)
令牌是`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJERU1PIFVTRVIiLCJzdWIiOiJERU1PIEFQUCIsIm5iZiI6MTYyNzU3OTM5OCwiaXNzIjoiRXhhbXBsZSBJc3N1ZXIiLCJleHAiOjE2Mjc1ODExOTgsImlhdCI6MTYyNzU3OTM5OCwianRpIjoiMjVmOWU5M2UtOGIzNy00NjI1LTgyOWItZDllZDZmNWE1M2M4In0.eKtIQOqX5QXqG5u6-ubmywJhpOhaSbGym5-949v1yrzCTeqrJSHR0VQi97PLZDT6fxILphT_dTnTRR2fWdZECQ`,
并且您可以将其粘贴到 [jwt.io](https://jwt.io) 来解析这个Token令牌。
如下是解析结果：
![Result](https://dist.cq.vorbote.cn/image/png/2grGRR-1627579482.png)

至于`net`部分的配置项目，它的配置的含义如下：

- `vorbote.web-dev.net`
  - `token-key`: 指定**Request Header**中的的验证头的Key。
  - `allowed-headers`: 指定哪些请求头可以被放置在**Request Header**中发送。
  - `exposed-headers`: 指定哪些响应头能被暴露在**Response Header**中。
  
这些配置项需要您手动添加到您的**跨域过滤器**中。以下就是一个跨域过滤器的*SAMPLE*
```java
import cn.vorbote.webdev.WebdevService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(value = 0)
public class CommonFilter implements Filter {

    private final String allowedHeaders;
    private final String exposedHeaders;

    /**
     * This constructor will auto inject {@code WebdevService.class} into this filter.
     */
    public CommonFilter(WebdevService webdevService) {
        log.info("Common Request filter loaded...");
        var netConf = webdevService.netConfigurationInfo();
        this.allowedHeaders = netConf.getAllowedHeaders();
        this.exposedHeaders = netConf.getExposedHeaders();

        log.info("Allowed request headers:[{}]，exposed headers:[{}]", allowedHeaders, exposedHeaders);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;

        // Handle CORS Request
        resp.addHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH");
        resp.addHeader("Access-Control-Allow-Headers", allowedHeaders);

        // Set the header to expose
        resp.addHeader("Access-Control-Expose-Headers", exposedHeaders);

        // All request sent by xhr will send OPTIONS Request at the same time, thus
        // intercept all OPTIONS requests.
        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("OPTIONS")) {
            return;
        }
        // Let other requests go forward.
        chain.doFilter(request, response);
    }
}
```

