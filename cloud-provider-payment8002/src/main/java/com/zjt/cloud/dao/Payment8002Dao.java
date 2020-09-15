package com.zjt.cloud.dao;

import com.zjt.cloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zjt
 * @date 2020-08-27
 */
@Mapper
@Repository
public interface Payment8002Dao {

    long create(Payment payment);

    Payment findById(@Param("id") Long id);

}
