package com.david.rpcproxy.anno;

/**
 * @version $Id: null.java, v 1.0 2019/11/22 4:58 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public interface HttpClient {

   Object postSend(Object[] params);

   Object getSend(Object[] params);
}
