## Web Dev SpringBoot Starter

Sponsored by **JetBrains**

[![JetBrains Logo (Main) logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png)](https://www.jetbrains.com/community/opensource/?utm_campaign=opensource&utm_content=approved&utm_medium=email&utm_source=newsletter&utm_term=jblogo#support)

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