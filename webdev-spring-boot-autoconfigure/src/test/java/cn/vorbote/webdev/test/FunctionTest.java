package cn.vorbote.webdev.test;

import cn.vorbote.webdev.net.NetConfigurationInfo;
import org.junit.Test;

import java.util.Arrays;

public class FunctionTest {

    @Test
    public void run01() {
        var allowedKeys = Arrays.asList("AccessKey", "Hello");
        // var exposedKeys = Arrays.asList("AccessKey", "Hello");

        var conf = NetConfigurationInfo.builder()
                .allowedHeaders(allowedKeys)
                .exposedHeaders(allowedKeys)
                .build();

        System.out.println("conf.ExposedHeaders() = " + conf.ExposedHeaders());
        System.out.println("conf.AllowedHeaders() = " + conf.AllowedHeaders());
    }
}
