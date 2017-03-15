package ${basepackage}.interceptor;

import ${basepackagecore}.base.Constants;
//import ${basepackagecore}.entity.User;
import org.common5iq.util.Utils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/***
 * 拦截器
 */
public class Interceptor implements HandlerInterceptor {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet
     * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute(Constants.SESSION_USER);
        if (Utils.isObjectEmpty(user)) {// 未登录
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                String reJson = null;

                response.setContentType("text/plan");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println(reJson);
                out.flush();
                out.close();
                return false;
            }
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        } else {

//            Map<String, String> powers = adminUser.getPowers();
//            // 没有权限
//            if (Utils.isObjectEmpty(powers) || powers.size() == 0) {
//                response.sendRedirect(request.getContextPath() + "/user/login");
//                return false;
//            }
//
//            for (Entry<String, String> e : powers.entrySet()) {
//                if (Utils.isObjectEmpty(Utils.notNullTrim(e.getKey())))
//                    continue;
//
//                logger.debug(request.getRequestURI());
//
//                String srcStr = request.getRequestURI();
//                String subStr = request.getRequestURI().replace(Utils.notNullTrim(e.getKey()), "");
//
//                logger.debug("subStr=" + subStr + " powerUrl=" + e.getKey());
//
//                if (srcStr.equals(subStr + Utils.notNullTrim(e.getKey())))
//                    return true;
//            }

            response.sendRedirect(request.getContextPath() + "/permissions.jsp");
            return false;
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
     * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
     * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object, java.lang.Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
