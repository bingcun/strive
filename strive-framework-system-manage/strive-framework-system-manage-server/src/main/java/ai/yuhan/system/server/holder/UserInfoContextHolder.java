//package ai.yuhan.system.holder;
//
//
//
///**
// * @Author: bingcun.chen
// * @Date: 2021/2/14 10:21
// * @Version 1.0
// */
//public final class UserInfoContextHolder {
//    private UserInfoContextHolder() {
//    }
//
//    /**
//     *  存储当前登录用户的信息
//     */
//    private static ThreadLocal<UserInfo> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();
//
//    public static UserInfo getUser() {
//        return USER_INFO_THREAD_LOCAL.get();
//    }
//
//    public static UserInfo getUserNotAssertion() {
//        return USER_INFO_THREAD_LOCAL.get();
//    }
//
//    public static void setUser(UserInfo user) {
//        USER_INFO_THREAD_LOCAL.set(user);
//    }
//
//    public static void remove() {
//        USER_INFO_THREAD_LOCAL.remove();
//    }
//
//}
