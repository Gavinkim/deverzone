package com.deverzone.repository;

import com.deverzone.domain.support.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GavinKim on 2017. 9. 27..
 */
public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
