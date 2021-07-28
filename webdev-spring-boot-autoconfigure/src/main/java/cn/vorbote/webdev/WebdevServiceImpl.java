package cn.vorbote.webdev;

public class WebdevServiceImpl implements WebdevService {

    /**
     * 签发人
     */
    private String issuer = "";

    /**
     * 密钥
     */
    private String secret = "";

    public WebdevServiceImpl(String issuer, String secret) {
        this.issuer = issuer;
        this.secret = secret;
    }

    @Override
    public ConfigurationInfo configurationInfo() {
        return ConfigurationInfo.builder()
                .issuer(this.issuer)
                .secret(this.secret).build();
    }
}
