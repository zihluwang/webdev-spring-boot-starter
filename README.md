## OpenSource Core

> You could also read the **CHINESE** version of [README](README_zh-CN.md)

In these years of development experience, developers have found that many `Web Application` projects using `SpringBoot` 
will configure their own cross-domain request processors, so in this project, we will use CORS filter is encapsulated so
that it can be automatically injected into the `SpringBoot` container after configuration to speed up the development 
process of each developer.

For the JWT function, you only need to configure the following:
````properties
# Enable JWT function
vorbote.web-dev.jwt.enabled=true
# The algorithm used by JWT, HS256 is used by default
vorbote.web-dev.jwt.algorithm=[Data in cn.vorbote.simplejwt.choices.JwtAlgorithm]
# JWT key
vorbote.web-dev.jwt.secret=[the secret you specify]
# Issuer of the JWT
vorbote.web-dev.jwt.issuer=[Your personal or company name or other string with special meaning that can represent your \
  personal or company]
````

For cross-domain request processing, you only need to configure the following:
````properties
# Enable CorsFilter
vorbote.web-dev.cors.enabled=true
# See MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials) to specify
vorbote.web-dev.cors.allow-credentials=[true|false]
# See MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin) for 
# specification
vorbote.web-dev.cors.allow-origin=[allowed origins (array of strings)]
# See MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers) for 
# specification
vorbote.web-dev.cors.allow-headers=[allow headers (string array)]
# See MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods) for 
# specification
vorbote.web-dev.cors.allow-methods=[allowed request methods (array of strings)]
# See MDN Docs (https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers) for 
# specification
vorbote.web-dev.cors.expose-headers=[response headers that need to be exposed (string number)]
````

> The library is now in **_ALPHA_** test, if you could want to help us to test, you could clone this library and use 
> **maven** or **gradle** to build it to your local repository. If you found any bugs or have any question while using 
> it, please do not hesitate to contact us by submitting an **issue** with the situation you met. If you are able to
> fix or improve that problem on your own, we are also welcome your **Pull Request**.