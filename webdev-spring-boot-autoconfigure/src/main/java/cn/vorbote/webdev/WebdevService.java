package cn.vorbote.webdev;

import cn.vorbote.webdev.jwt.JwtConfigurationInfo;
import cn.vorbote.webdev.net.NetConfigurationInfo;

/**
 * This is the main service class.
 *
 * @author vorbote thills@vorbote.cn
 */
public interface WebdevService {

    /**
     * Build JWT configuration info.
     *
     * @return {@link cn.vorbote.webdev.jwt.JwtConfigurationInfo}
     */
    JwtConfigurationInfo jwtConfigurationInfo();

    /**
     * Build NET configuration info.
     *
     * @return {@link cn.vorbote.webdev.net.NetConfigurationInfo}
     */
    NetConfigurationInfo netConfigurationInfo();

}
