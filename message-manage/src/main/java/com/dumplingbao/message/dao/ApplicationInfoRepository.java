package com.dumplingbao.message.dao;


import com.dumplingbao.message.domain.ApplicationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


/**
 * @author dumplingbao
 */
public interface ApplicationInfoRepository extends MongoRepository<ApplicationInfo, String> {

    /**
     * 根据id获取PO
     *
     * @param id
     * @return
     */
    @Override
    Optional findById(String id);

    /**
     * 保存
     *
     * @param applicationInfo
     * @return
     */
    @Override
    ApplicationInfo save(ApplicationInfo applicationInfo);

    /**
     * 获取所有数据，带分页排序
     *
     * @param pageable
     * @return
     */
    @Override
    Page<ApplicationInfo> findAll(Pageable pageable);

    /**
     * 删除数据
     * @param id
     */
    @Override
    void deleteById(String id);

    /**
     * 根据文件名过滤，带分页排序
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<ApplicationInfo> findByNameLike(String name, Pageable pageable);

    /**
     * 根据文件名过滤的结果总数
     *
     * @param name
     * @return
     */
    List<ApplicationInfo> findByNameLike(String name);
}
