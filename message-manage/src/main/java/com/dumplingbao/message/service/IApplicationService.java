package com.dumplingbao.message.service;

import com.dumplingbao.message.domain.ApplicationInfo;

/**
 * @author dumplingbao
 */
public interface IApplicationService {

    void saveOrUpdate(ApplicationInfo applicationInfo);

    ApplicationInfo findById(String id);
}
