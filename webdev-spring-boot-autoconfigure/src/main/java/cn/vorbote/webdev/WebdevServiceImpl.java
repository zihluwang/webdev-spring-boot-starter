package cn.vorbote.webdev;

import cn.vorbote.webdev.jwt.JwtConfigurationInfo;
import cn.vorbote.webdev.net.NetConfigurationInfo;

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
    private String issuer;

    /**
     * The secret to use in jwt.
     */
    private String secret;

    /**
     * The key of the token.
     */
    private String tokenKey;

    /**
     * Headers which are allowed to be used in request header.
     */
    private List<String> allowedHeaders;

    /**
     * Headers which are allowed to be used in request header.
     */
    private List<String> exposedHeaders;

    /**
     * Constructor.
     *
     * @param issuer The issuer of jwt.
     * @param secret The secret to use in jwt.
     */
    public WebdevServiceImpl(String issuer,
                             String secret,
                             String tokenKey,
                             List<String> allowedHeaders,
                             List<String> exposedHeaders) {
        this.issuer = issuer;
        this.secret = secret;
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
                .secret(this.secret).build();
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
