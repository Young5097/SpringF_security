package org.hdivsamples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.hdivsamples.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Connection connection;

	@Override
	public List<Account> findUsersByUsernameAndPassword(final String username, final String password) {
		
        String ldapUrl = "ldap://localhost:10389";
        String baseDn = "dc=example,dc=com";
        String bindDn = "cn=admin," + baseDn;
        String bindPassword = "password";

        // Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, bindDn);
        env.put(Context.SECURITY_CREDENTIALS, bindPassword);

        DirContext context;
		try {
			context = new InitialDirContext(env);
			
			String searchFilter = "(uid=" + username + ")";
			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration<SearchResult> searchResults = context.search(baseDn, searchFilter, searchControls);

		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		
		// 1.pw에서 AND, OR 제거
		// 2. PreparedStatement
		password.replaceAll("or", ""); 
		String sql = "SELECT * FROM account WHERE username = ? AND password = ?";

		RowMapper<Account> rowMapper = new RowMapper<Account>() {
			@Override
			public Account mapRow(final ResultSet rs, int rowNum) throws SQLException {
				Account localAccount = new Account();
				localAccount.setUsername(rs.getString("username"));
				localAccount.setName(rs.getString("name"));
				localAccount.setSurname(rs.getString("surname"));
				localAccount.setPassword(rs.getString("password"));
				return localAccount;
			}
		};

		// jdbcTemplate는 자동으로 PreparedStatement 사용
		List<Account> results = jdbcTemplate.query(sql, rowMapper, username, password);
		return results;
	}

	@Override
	public List<Account> findUsersByUsername(final String username) {
		String str = "select * from account where username='" + username + "'";

		RowMapper<Account> rowMapper = new RowMapper<Account>() {
			@Override
			public Account mapRow(final ResultSet paramResultSet, final int paramInt) throws java.sql.SQLException {
				Account localAccount = new Account();
				localAccount.setUsername(paramResultSet.getString("username"));
				localAccount.setName(paramResultSet.getString("name"));
				localAccount.setSurname(paramResultSet.getString("surname"));
				localAccount.setPassword(paramResultSet.getString("password"));
				return localAccount;
			}
		};

		return jdbcTemplate.query(str, rowMapper);
	}

	@Override
	public List<Account> findAllUsers() {

		String str = "select * from account";

		RowMapper<Account> rowMapper = new RowMapper<Account>() {
			@Override
			public Account mapRow(final ResultSet paramResultSet, final int paramInt) throws java.sql.SQLException {
				Account localAccount = new Account();
				localAccount.setUsername(paramResultSet.getString("username"));
				localAccount.setName(paramResultSet.getString("name"));
				localAccount.setSurname(paramResultSet.getString("surname"));
				localAccount.setPassword(paramResultSet.getString("password"));
				return localAccount;
			}
		};

		return jdbcTemplate.query(str, rowMapper);
	}

	public void setJdbcTemplate(final JdbcTemplate paramJdbcTemplate) {
		jdbcTemplate = paramJdbcTemplate;
	}
}
