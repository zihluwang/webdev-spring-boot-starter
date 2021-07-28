package cn.vorbote.webdev;

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
     * Constructor.
     *
     * @param issuer The issuer of jwt.
     * @param secret The secret to use in jwt.
     */
    public WebdevServiceImpl(String issuer, String secret) {
        this.issuer = issuer;
        this.secret = secret;
    }

    /**
     * Build configuration info.
     *
     * @return {@link ConfigurationInfo}
     */
    @Override
    public ConfigurationInfo configurationInfo() {
        return ConfigurationInfo.builder()
                .issuer(this.issuer)
                .secret(this.secret).build();
    }
}
