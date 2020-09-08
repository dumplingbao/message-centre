package com.dumplingbao.message.service.impl;

import com.dumplingbao.message.dao.ApplicationInfoRepository;
import com.dumplingbao.message.domain.ApplicationInfo;
import com.dumplingbao.message.service.IApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/8 11:43
 */
@Slf4j
@Service
public class ApplicationInfoServiceImpl implements IApplicationService {

    @Autowired
    private ApplicationInfoRepository applicationInfoRepository;

    @Override
    public void saveOrUpdate(ApplicationInfo applicationInfo) {
        log.info("[saveOrUpdateApplicationInfo] before = {}", applicationInfo.toString());
        ApplicationInfo save = applicationInfoRepository.save(applicationInfo);
        log.info("[saveOrUpdateApplicationInfo] return = {}", save.toString());
    }

    @Override
    public ApplicationInfo findById(String id) {
        Optional<ApplicationInfo> applicationInfo = applicationInfoRepository.findById(id);
        return applicationInfo.isPresent() ? applicationInfo.get() : null;
    }
}
