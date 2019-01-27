package com.cbfteam.dao;  
import com.cbfteam.daoInterface.UserDaoInterface;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;   
import com.cbfteam.beans.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  
public class UserDao implements UserDaoInterface {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
    @Override
    public int save(User pa, Boolean is_admin){
    
    String sql="insert into user(username,password,email,fname,lname,birthdate,"
            + "gender,reg_date,is_active,is_admin) "
            + "values('"+pa.getUsername().replace("'", "\\'")+"','"+pa.getPassword().replace("'", "\\'")+"','"+pa.getEmail().replace("'", "\\'")+"',"
            +"'"+pa.getFname().replace("'", "\\'")+"','"+pa.getLname().replace("'", "\\'")+"','"+pa.getBirthdate()+"','"+((pa.getGender()==null)?"Other":pa.getGender())+"',"+"NOW()"+",'Active'"+","+is_admin+")";  
    return template.update(sql);  
}  
    @Override
    public int update(User p){
    String sql="";
    
        sql="update user set username='"+p.getUsername().replace("'", "\\'")+"', password='"+p.getPassword().replace("'", "\\'")+"',email='"+p.getEmail().replace("'", "\\'")
            +"',fname='"+p.getFname().replace("'", "\\'")+"',lname='"+p.getLname().replace("'", "\\'")+"',is_active='"+p.getIs_active()+"',birthdate='"+p.getBirthdate()
            +"',gender='"+p.getGender()+"' where id="+p.getId()+"";  
        
    return template.update(sql);  
}  
    @Override  
    public int delete(int id){  
    String sql="delete from user where id="+id+"";  
    return template.update(sql);  
}  
    @Override  
    public User getUserById(int id){  
    String sql="select * from user where id=?"; 
    try{
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
    }catch(EmptyResultDataAccessException e){
        return null;
    }  
}

    @Override
    public User validateUser(String username){
    BCryptPasswordEncoder cr = new BCryptPasswordEncoder();
    String sql="select * from user where username=? AND is_active='Active'";
    try{
    return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));   
    }catch(EmptyResultDataAccessException e){
        return null;
    }
}
    @Override
    public Boolean validateUsername(String username, String email){
    String sql="select * from teamproject.user where username=? AND email=?";
    try{
       template.queryForObject(sql, new Object[]{username,email}, new BeanPropertyRowMapper<User>(User.class));       
    }catch(EmptyResultDataAccessException e){
        return true;
    }return false;
}

    @Override  
    public List<User> getUsers(){  
    return template.query("select * from user where username != 'ADMIN'",new RowMapper<User>(){  
        public User mapRow(ResultSet rs, int row) throws SQLException {  
            User e=new User();  
            e.setId(rs.getInt(1));  
            e.setUsername(rs.getString(2));  
            e.setPassword(rs.getString(3));  
            e.setEmail(rs.getString(4));  
            e.setFname(rs.getString(5));
            e.setLname(rs.getString(6));
            e.setBirthdate(rs.getString(7));
            e.setGender(rs.getString(8));
      
            e.setReg_date(rs.getString(9));
            e.setIs_active(rs.getString(10));
            e.setIs_admin(rs.getBoolean(11));
            
            return e;  
        }  
    });  
}
    @Override  
    public List<String> getUsernames(){  
    return template.query("select username from user INNER JOIN article on user.id = article.creator_id WHERE pub_date IS NULL ORDER BY sub_date DESC",new RowMapper<String>(){  
        public String mapRow(ResultSet rs, int row) throws SQLException {  
            String e="";  
            e=(rs.getString(1));  
            
            return e;  
        }  
    });  
}
    @Override  
    public List<String> getUsernamesByAllPublished(){  
    return template.query("select user.username from teamproject.user INNER JOIN teamproject.article on "
            + "user.id = article.creator_id WHERE pub_date IS NOT NULL ORDER BY pub_date DESC",new RowMapper<String>(){  
        public String mapRow(ResultSet rs, int row) throws SQLException {  
            String e="";  
            e=(rs.getString(1));  
            
            return e;  
        }  
    });  
} 

    @Override  
    public List<String> getUsernamesByPublishedCategory(String category){  
    return template.query("select user.username from teamproject.user INNER JOIN teamproject.article on "
            + "user.id = article.creator_id WHERE (pub_date IS NOT NULL AND category ='"+category+"') ORDER BY pub_date DESC",new RowMapper<String>(){  
        public String mapRow(ResultSet rs, int row) throws SQLException {  
            String e="";  
            e=(rs.getString(1));  
            
            return e;  
        }  
    });  
}

}  