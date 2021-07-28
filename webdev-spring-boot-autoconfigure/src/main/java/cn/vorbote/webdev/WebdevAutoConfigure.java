package cn.vorbote.webdev;

import cn.vorbote.simplejwt.AccessKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = WebdevProperties.class)
@Slf4j
public class WebdevAutoConfigure {

    private final WebdevProperties webdevProperties;

    @Autowired
    public WebdevAutoConfigure(WebdevProperties webdevProperties) {
        this.webdevProperties = webdevProperties;
    }

    @Bean
    @ConditionalOnMissingBean(value = WebdevService.class)
    public WebdevService webdevService() {
        log.debug("Injecting webdev service...");
        log.debug("Issuer: {}, Secret: {}", webdevProperties.getIssuer(), webdevProperties.getSecret());
        return new WebdevServiceImpl(webdevProperties.getIssuer(), webdevProperties.getSecret());
    }

    @Bean
    @ConditionalOnBean(value = WebdevService.class)
    public AccessKeyUtil accessKeyUtil() {
        log.debug("Injecting accessKeyUtil...");
        var info = webdevService().configurationInfo();
        return new AccessKeyUtil(info.getSecret(), info.getIssuer());
    }
}
