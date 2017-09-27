package com.deverzone.repository;

import com.deverzone.domain.support.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GavinKim on 2017. 9. 27..
 */
public interface FAQRepository extends JpaRepository<FAQ,Long> {
}
