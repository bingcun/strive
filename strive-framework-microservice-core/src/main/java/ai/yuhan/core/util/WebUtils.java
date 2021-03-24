package ai.yuhan.core.util;

import ai.yuhan.core.vo.LoginInfo;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: bingcun.chen
 * @Date: 2021/2/25 23:35
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class WebUtils {
    public WebUtils() {
    }

    public static LoginInfo getLoginInfoFromRequest(HttpServletRequest request) {
        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");
        return loginInfo == null ? (LoginInfo)request.getAttribute("loginInfo") : loginInfo;
    }

    public static LoginInfo getLoginInfoFromSimpleRequest(HttpServletRequest request) {
        LoginInfo loginInfo = request.getAttributeNames() == null ? null : (LoginInfo)request.getAttribute("loginInfo");
        return loginInfo == null ? (request.getAttribute("loginInfo") == null ? null : (LoginInfo)request.getAttribute("loginInfo")) : loginInfo;
    }

    public static void setLoginInfoToRequest(HttpServletRequest request, LoginInfo loginInfo) {
        request.setAttribute("loginInfo", loginInfo);
        request.getSession().setAttribute("loginInfo", loginInfo);
    }

    public static String getClientIpFromRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getClientIpFromSimpleRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
