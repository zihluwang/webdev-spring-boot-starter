package cn.vorbote.webdev.service.impl;

import cn.vorbote.simplejwt.choices.JwtAlgorithm;
import cn.vorbote.webdev.cors.CorsConfigurationInfo;
import cn.vorbote.webdev.jwt.JwtConfigurationInfo;
import cn.vorbote.webdev.service.WebdevService;

/**
 * This is the implementation of main service class.
 *
 * @author vorbote thills@vorbote.cn
 */
public class WebdevServiceImpl implements WebdevService {

    /**
     * The issuer of jwt.
     */
    private final String issuer;

    /**
     * The secret to use in jwt.
     */
    private final String secret;

    /**
     * The algorithm of jwt
     */
    private final JwtAlgorithm algorithm;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials"
     * >MDN Docs</a>, this tells browsers whether to expose the response to the frontend JavaScript code when
     * the request's credentials mode ({@code Request.credentials}) is included.
     */
    private final boolean allowCredentials;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin"
     * >MDN Docs</a>, this response header indicates whether the response can be shared with requesting code from the
     * given origin.
     */
    private final String[] allowOrigin;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers"
     * >MDN Docs</a>, this response header is used in response to a preflight request which includes the
     * {@code Access-Control-Request-Headers} to indicate which HTTP headers can be used during the actual request.
     */
    private final String[] allowHeaders;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods"
     * >MDN Docs</a>, this response header specifies one or more methods allowed when accessing a resource in response
     * to a preflight request.
     */
    private final String[] allowMethods;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers"
     * >MDN Docs</a>, this response header allows a server to indicate which response headers should be made available
     * to scripts running in the browser, in response to a cross-origin request.<br/>
     * Only the <a href="https://developer.mozilla.org/en-US/docs/Glossary/CORS-safelisted_response_header"
     * >CORS-safelisted</a> response headers are exposed by default. For clients to be able to access other headers,
     * the server must list them using the Access-Control-Expose-Headers header.
     */
    private final String[] exposeHeaders;

    /**
     * Constructor.
     *
     * @param issuer The issuer of jwt.
     * @param secret The secret to use in jwt.
     */
    public WebdevServiceImpl(String issuer,
                             String secret,
                             JwtAlgorithm algorithm,
                             boolean allowCredentials,
                             String[] allowOrigin,
                             String[] allowHeaders,
                             String[] allowMethods,
                             String[] exposeHeaders) {
        this.issuer = issuer;
        this.secret = secret;
        this.algorithm = algorithm;
        this.allowCredentials = allowCredentials;
        this.allowOrigin = allowOrigin;
        this.allowHeaders = allowHeaders;
        this.allowMethods = allowMethods;
        this.exposeHeaders = exposeHeaders;
    }

    /**
     * Build JWT configuration info.
     *
     * @return {@link JwtConfigurationInfo}
     */
    @Override
    public JwtConfigurationInfo jwtConfigurationInfo() {
        return JwtConfigurationInfo.builder()
                .issuer(this.issuer)
                .secret(this.secret)
                .algorithm(this.algorithm).build();
    }

    @Override
    public CorsConfigurationInfo corsConfigurationInfo() {
        return CorsConfigurationInfo.builder()
                .allowCredentials(this.allowCredentials)
                .allowOrigin(this.allowOrigin)
                .allowMethods(this.allowMethods)
                .allowHeaders(this.allowHeaders)
                .exposeHeaders(this.exposeHeaders).build();
    }
}
