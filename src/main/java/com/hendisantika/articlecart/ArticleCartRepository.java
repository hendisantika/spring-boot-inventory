package com.hendisantika.articlecart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-inventory
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/12/21
 * Time: 17.30
 */
public interface ArticleCartRepository extends JpaRepository<ArticleCart, Integer> {
}
