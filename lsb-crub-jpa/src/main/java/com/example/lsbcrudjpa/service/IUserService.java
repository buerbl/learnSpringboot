package com.example.lsbcrudjpa.service;


import com.example.lsbcrudjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
public interface IUserService  {

    Boolean saveOne();

    void test1();

    Long countByName(String name);

    List<User> findByAdressOrderByName(String adress);

    Page<User> queryFirst10ByAdress(String adress, Pageable pageable);


}
