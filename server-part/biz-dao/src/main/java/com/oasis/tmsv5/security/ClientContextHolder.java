package com.oasis.tmsv5.security;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.model.security.Account;
import com.oasis.tmsv5.util.helper.DomainHelper;

public class ClientContextHolder {

    private static ThreadLocal<ClientContext> contextHolder = new ThreadLocal<ClientContext>();

    public static void clearContext() {
        contextHolder.set(null);
    }

    public static ClientContext getContext() {
        if (contextHolder.get() == null) {
            contextHolder.set(new ClientContext());
        }

        return contextHolder.get();
    }

    public static void setContext(ClientContext context) {
        contextHolder.set(context);
    }

    public static ClientContext createEmptyContext() {
        return new ClientContext();
    }

    public static void buildSystemContext(){
    	Account acc = new Account();
    	acc.setId(DomainHelper.SYSTEM_ACCOUNT);
    	if (contextHolder.get() == null) {
    		ClientContext sc = new ClientContext();
    		sc.setAccountId(acc.getId());
    		sc.setLoginName(DomainHelper.SYSTEM_ACCOUNT.toString());
    		sc.setNameCn(DomainHelper.SYSTEM_ACCOUNT.toString());
    		sc.setNetAuthority("111");
    		sc.setIp("1.1.1.1");
            contextHolder.set(sc);
        }
    }
}
