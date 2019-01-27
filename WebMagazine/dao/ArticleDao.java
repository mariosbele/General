package com.cbfteam.dao;  
import com.cbfteam.daoInterface.ArticleDaoInterface;
import com.cbfteam.beans.Article;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;   
import com.cbfteam.beans.User;

  
public class ArticleDao implements ArticleDaoInterface {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
    @Override  
    public int saveArticle(Article pa, User user){  
    String sql="insert into teamproject.article(creator_id,sub_date,pub_date,category,title,article,"
            + "question,is_saved) "
            + "values('"+user.getId()+"', null, null,"
            +"'"+pa.getCategory()+"','"+pa.getTitle().replace("'", "\\'")+"','"+pa.getArticle().replace("'", "\\'")+"','"+pa.getQuestion()+"', true)";  
    return template.update(sql);  
}

    @Override  
    public int submitSavedArticle(Article a){  
    String sql="update teamproject.article set  sub_date= NOW(), pub_date = NULL, "
            +"category='"+a.getCategory()+"',title='"+a.getTitle().replace("'", "\\'")+"',article='"+a.getArticle().replace("'", "\\'")
            +"',question='"+a.getQuestion()+"',is_saved = false where id="+a.getId()+"";  
    return template.update(sql);  
}
    @Override  
    public int publishArticle(int id){  
    String sql="update teamproject.article set pub_date= NOW() where id="+id+"";  
    return template.update(sql);  
}
    @Override  
    public int deleteArticle(int id){  
    String sql="delete from teamproject.article where id="+id+"";  
    return template.update(sql);  
}  
    @Override  
    public Article getArticleById(int id){  
    String sql="select * from teamproject.article where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Article>(Article.class));  
}

    @Override
    public String getUsernameByArticleID(int id, int art_id){
        String sql="select username from teamproject.user INNER JOIN teamproject.article on user.id=article.id where article.creator_id=? AND article.id=?";  
    return template.queryForObject(sql, new Object[]{id, art_id},new BeanPropertyRowMapper<String>(String.class)); 
}

    @Override  
    public List<Article> getPublishedArticles(){  
    return template.query("select * from teamproject.article where article.pub_date IS NOT null ORDER BY article.pub_date DESC",new RowMapper<Article>(){  
        public Article mapRow(ResultSet rs, int row) throws SQLException {  
            Article e=new Article();  
            e.setId(rs.getInt(1));  
            e.setCreator_id(rs.getInt(2));  
            e.setSub_date(rs.getString(3));  
            e.setPub_date(rs.getString(4));  
            e.setCategory(rs.getString(5));
            e.setTitle(rs.getString(6));
            e.setArticle(rs.getString(7));
            e.setQuestion(rs.getString(8));
            e.setIs_saved(rs.getBoolean(9));            
            return e;  
            }  
        });  
    }
    @Override  
    public List<Article> getUnPublishedArticles(){  
    return template.query("select * from teamproject.article where is_saved=false AND pub_date IS null ORDER BY sub_date DESC",new RowMapper<Article>(){  
        public Article mapRow(ResultSet rs, int row) throws SQLException {  
            Article e=new Article();  
            e.setId(rs.getInt(1));  
            e.setCreator_id(rs.getInt(2));  
            e.setSub_date(rs.getString(3));  
            e.setPub_date(rs.getString(4));  
            e.setCategory(rs.getString(5));
            e.setTitle(rs.getString(6));
            e.setArticle(rs.getString(7));
            e.setQuestion(rs.getString(8));
            e.setIs_saved(rs.getBoolean(9));            
            return e;  
            }  
        });  
    }

    @Override  
    public List<Article> getPublishedArticlesByCategory(String category){  
    return template.query("select * from teamproject.article where category ='"+category+"' AND pub_date IS NOT NULL ORDER BY pub_date DESC",new RowMapper<Article>(){  
        public Article mapRow(ResultSet rs, int row) throws SQLException {  
            Article e=new Article();  
            e.setId(rs.getInt(1));  
            e.setCreator_id(rs.getInt(2));  
            e.setSub_date(rs.getString(3));  
            e.setPub_date(rs.getString(4));  
            e.setCategory(rs.getString(5));
            e.setTitle(rs.getString(6));
            e.setArticle(rs.getString(7));
            e.setQuestion(rs.getString(8));
            e.setIs_saved(rs.getBoolean(9));            
            return e;  
            }  
        });  
    }
    @Override  
    public List<Article> getSavedArticlesByCreatorId(int id){  
    return template.query("select * from teamproject.article where creator_id='"+id+"' AND is_saved= true ORDER BY id DESC",new RowMapper<Article>(){  
        public Article mapRow(ResultSet rs, int row) throws SQLException {  
            Article e=new Article();  
            e.setId(rs.getInt(1));  
            e.setCreator_id(rs.getInt(2));  
            e.setSub_date(rs.getString(3));  
            e.setPub_date(rs.getString(4));  
            e.setCategory(rs.getString(5));
            e.setTitle(rs.getString(6));
            e.setArticle(rs.getString(7));
            e.setQuestion(rs.getString(8));
            e.setIs_saved(rs.getBoolean(9));            
            return e;  
            }  
        });  
    }
    @Override  
    public List<Article> getPublishedArticlesByCreatoryId(int id){  
    return template.query("select * from teamproject.article where (creator_id= '"+id+"' AND pub_date IS NOT null) ORDER BY pub_date DESC",new RowMapper<Article>(){  
        public Article mapRow(ResultSet rs, int row) throws SQLException {  
            Article e=new Article();  
            e.setId(rs.getInt(1));  
            e.setCreator_id(rs.getInt(2));  
            e.setSub_date(rs.getString(3));  
            e.setPub_date(rs.getString(4));  
            e.setCategory(rs.getString(5));
            e.setTitle(rs.getString(6));
            e.setArticle(rs.getString(7));
            e.setQuestion(rs.getString(8));
            e.setIs_saved(rs.getBoolean(9));            
            return e;  
            }  
        });  
    }
}  