package cn.vorbote.webdev;

import cn.vorbote.simplejwt.AccessKeyUtil;
import cn.vorbote.webdev.jwt.JwtProperties;
import cn.vorbote.webdev.net.NetProperties;
import cn.vorbote.webdev.service.WebdevService;
import cn.vorbote.webdev.service.impl.WebdevServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is the auto configure class.
 *
 * @author vorbote thills@vorbote.cn
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(value = {JwtProperties.class, NetProperties.class})
public class WebdevAutoConfigure {

    private final JwtProperties jwtProperties;
    private final NetProperties netProperties;

    @Autowired
    public WebdevAutoConfigure(JwtProperties jwtProperties,
                               NetProperties netProperties) {
        this.jwtProperties = jwtProperties;
        this.netProperties = netProperties;
    }

    @Bean
    @ConditionalOnMissingBean(value = WebdevService.class)
    public WebdevService webdevService() {
        log.debug("Injecting webdev service...");
        log.debug("Issuer: {}, Secret: {}", jwtProperties.getIssuer(), jwtProperties.getSecret());
        return new WebdevServiceImpl(jwtProperties.getIssuer(),
                jwtProperties.getSecret(), netProperties.getTokenKey(),
                netProperties.getAllowedHeaders(), netProperties.getExposedHeaders());
    }

    @Bean
    @ConditionalOnBean(value = WebdevService.class)
    public AccessKeyUtil accessKeyUtil() {
        log.debug("Injecting accessKeyUtil...");
        var info = webdevService().jwtConfigurationInfo();
        return new AccessKeyUtil(info.getSecret(), info.getIssuer());
    }
}
