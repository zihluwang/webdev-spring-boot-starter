package cn.vorbote.webdev.service.impl;

import cn.vorbote.simplejwt.choices.JwtAlgorithm;
import cn.vorbote.webdev.jwt.JwtConfigurationInfo;
import cn.vorbote.webdev.net.NetConfigurationInfo;
import cn.vorbote.webdev.service.WebdevService;

import java.util.List;

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
     * The key of the token.
     */
    private final String tokenKey;

    /**
     * Headers which are allowed to be used in request header.
     */
    private final List<String> allowedHeaders;

    /**
     * Headers which are allowed to be used in request header.
     */
    private final List<String> exposedHeaders;

    /**
     * Constructor.
     *
     * @param issuer The issuer of jwt.
     * @param secret The secret to use in jwt.
     */
    public WebdevServiceImpl(String issuer,
                             String secret,
                             JwtAlgorithm algorithm,
                             String tokenKey,
                             List<String> allowedHeaders,
                             List<String> exposedHeaders) {
        this.issuer = issuer;
        this.secret = secret;
        this.algorithm = algorithm;
        this.tokenKey = tokenKey;
        this.allowedHeaders = allowedHeaders;
        this.exposedHeaders = exposedHeaders;
    }

    /**
     * Build JWT configuration info.
     *
     * @return {@link cn.vorbote.webdev.jwt.JwtConfigurationInfo}
     */
    @Override
    public JwtConfigurationInfo jwtConfigurationInfo() {
        return JwtConfigurationInfo.builder()
                .issuer(this.issuer)
                .secret(this.secret)
                .algorithm(this.algorithm).build();
    }

    /**
     * Build configuration info.
     *
     * @return {@link cn.vorbote.webdev.jwt.JwtConfigurationInfo}
     */
    @Override
    public NetConfigurationInfo netConfigurationInfo() {
        return NetConfigurationInfo.builder().
                tokenKey(this.tokenKey)
                .allowedHeaders(this.allowedHeaders)
                .exposedHeaders(this.exposedHeaders).build();
    }
}
