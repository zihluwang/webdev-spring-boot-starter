## Open Source Core

开发者在这些年的开发经验中，发现有不少使用 `SpringBoot` 的 `Web Application` 项目会自行配置跨域请求处理器，所以在此次项目中，我们将 CORS
过滤器进行了封装，让其能在经过配置后自动注入 `SpringBoot` 容器内，以加快各位开发者的开发进程。

对于 JWT 功能，你只需要进行如下配置：
```properties
# 开启JWT功能
vorbote.web-dev.jwt.enabled=true
# JWT使用的算法，默认使用 HS256
vorbote.web-dev.jwt.algorithm=[cn.vorbote.simplejwt.choices.JwtAlgorithm中的数据]
# JWT的密钥
vorbote.web-dev.jwt.secret=[你指定的密钥]
# JWT的签发者
vorbote.web-dev.jwt.issuer=[你个人或公司的名字或其他能代表你个人或公司的具有特殊含义的字符串]
```

对于跨域请求处理功能，你只需要进行如下配置：
```properties
# 开启CorsFilter
vorbote.web-dev.cors.enabled=true
# 请参阅 MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials) 进行指定
vorbote.web-dev.cors.allow-credentials=[true|false]
# 请参阅 MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin) 进行指定
vorbote.web-dev.cors.allow-origin=[允许的来源（字符串数组）]
# 请参阅 MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers) 进行指定
vorbote.web-dev.cors.allow-headers=[允许的请求头（字符串数组）]
# 请参阅 MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods) 进行指定
vorbote.web-dev.cors.allow-methods=[允许的请求方式（字符串数组）]
# 请参阅 MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers) 进行指定
vorbote.web-dev.cors.expose-headers=[需要进行暴露的响应头（字符串数字）]
```

> 该库现在处于 **_ALPHA_** 测试中，如果您想帮助我们测试，您可以克隆此库并使用 **maven** 或 **gradle** 将其构建到您的本地存储库。如果您在
> 使用过程中发现任何错误或有任何疑问，请随时通过提交 **Issues** 与我们描述你遇到的情况。如果你有能力修复或自行改进，我们也欢迎您的 
> **Pull Request**。