package ai.yuhan.system.server.service;

import ai.yuhan.core.api.CommonResult;
import ai.yuhan.system.server.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Fox
 */
public interface AccountService extends UserDetailsService {
    Account getByUsername(String username);

    CommonResult login(String username, String password,HttpServletRequest request);

     String testTransactionInvalid();
}
