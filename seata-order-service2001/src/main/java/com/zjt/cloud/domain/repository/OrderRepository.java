package com.zjt.cloud.domain.repository;

import com.zjt.cloud.domain.CusOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zjt
 * @date 2020-10-29
 */
public interface OrderRepository extends PagingAndSortingRepository<CusOrder, Integer> {
}
