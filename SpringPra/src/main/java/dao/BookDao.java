package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Mr.wxx
 * @create 2021-04-11-20:47
 **/
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /***
     * 减去某个用户的余额
     * @param username
     * @param price
     */
    public void updateBalance(String username, int price){
        String sql = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql, price, username);
    }


}
