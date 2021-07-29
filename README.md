# Web Dev Suite

A useful Web development suite, integrated with jwt, and request header resolving.

## User Guide

If you want to use this suite, please make sure that you know about the usage of 
the following configurations.

> This is the integration of simple-jwt, you can use this with the following codes.

```xml
<dependency>
    <groupId>cn.vorbote</groupId>
    <artifactId>simple-jwt</artifactId>
    <version>1.0.1</version>
</dependency>
```

- `vorbote.web-dev.jwt`
  - `issuer`: This configuration is to specify the issuer of **Jwt Token**.
  - `secret`: This is to specify the secret in the **Verify Signature**
  
For example, while you write the following codes in `application.yml`:
```yml
vorbote:
  web-dev:
    jwt:
      issuer: Example Issuer
      secret: exampleSecret
```

Then I wrote down these code as a demo: ![Demo1](https://dist.cq.vorbote.cn/image/png/Qv7Md6-1627578986.png)
The demo run out the result in the picture: ![Demo2](https://dist.cq.vorbote.cn/image/png/UY5R26-1627579413.png)
The token is `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJERU1PIFVTRVIiLCJzdWIiOiJERU1PIEFQUCIsIm5iZiI6MTYyNzU3OTM5OCwiaXNzIjoiRXhhbXBsZSBJc3N1ZXIiLCJleHAiOjE2Mjc1ODExOTgsImlhdCI6MTYyNzU3OTM5OCwianRpIjoiMjVmOWU5M2UtOGIzNy00NjI1LTgyOWItZDllZDZmNWE1M2M4In0.eKtIQOqX5QXqG5u6-ubmywJhpOhaSbGym5-949v1yrzCTeqrJSHR0VQi97PLZDT6fxILphT_dTnTRR2fWdZECQ`,
and you can also paste it into the [jwt.io](https://jwt.io) to resolve the JWT token. Here is the result:
![Result](https://dist.cq.vorbote.cn/image/png/2grGRR-1627579482.png)

As for the configuration for net, its configuration's meanings is as followed:

- `vorbote.web-dev.net`
  - `token-key`: The key of your token in the **Request Header**.
  - `allowed-headers`: The keys to allow the front end to send in **Request Header**.
  - `exposed-headers`: The headers to expose in **Response Header**.
  
You need to add these configurations in your `cors filter`. And here is a sample:
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

