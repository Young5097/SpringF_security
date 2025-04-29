## Injection Test

```
id : 1
pw : ' or 1=1
```

### 해결책
```java
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
```