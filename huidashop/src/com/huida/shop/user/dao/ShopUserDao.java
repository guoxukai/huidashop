package com.huida.shop.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.huida.shop.user.vo.ShopUser;
import com.huida.util.DbUtil;

/**
 * 负责与用户表相关数据库操作
 * @author wangzhen
 *
 */
public class ShopUserDao {
	//执行语句的工具
	QueryRunner queryRunner = new QueryRunner();
	
	/**
	 * 去数据库里面执行sql语句返回统计结果
	 * @param usercode
	 * @return
	 * @throws SQLException 
	 */
	public long selectCountUserByUserCode(String usercode) throws SQLException {
		String sql = "select count(1) from shop_user where usercode=?";
		Long count = queryRunner.query(DbUtil.getConnection(),sql,new ScalarHandler<Long>(),usercode);
		return count;
	}

	/**
	 * 将用户对象插入到数据库
	 * @param shopUser
	 * @return
	 * @throws SQLException 
	 */
	public int insert(ShopUser shopUser) throws SQLException {
		String sql = "insert into shop_user("
				+ "ID,USERCODE,PASSWORD,"
				+ "PHONENUM,REALNAME,MAIL,"
				+ "MAILACTIVEFLAG,MAILACTIVECODE,USERADDR,"
				+ "HEADPHOTO,NICKNAME) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		int rows = queryRunner.update(DbUtil.getConnection(),sql,
				shopUser.getId(),shopUser.getUsercode(),shopUser.getPassword(),
				shopUser.getPhonenum(),shopUser.getRealname(),shopUser.getMail(),
				shopUser.getMailactiveflag(),shopUser.getMailactivecode(),shopUser.getUseraddr(),
				shopUser.getHeadphoto(),shopUser.getNickname()
				);
		return rows;
	}

	/**
	 * 根据用户登录账号去查
	 * @param usercode
	 * @return
	 * @throws SQLException 
	 */
	public ShopUser selectUserByUsercode(String usercode) throws SQLException {
		String sql = "select * from shop_user where usercode=?";
		ShopUser user = queryRunner.query(DbUtil.getConnection(),sql,new BeanHandler<ShopUser>(ShopUser.class),usercode);
		return user;
	}

}
