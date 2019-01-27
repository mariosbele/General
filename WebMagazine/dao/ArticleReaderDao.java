package com.cbfteam.dao;  
import com.cbfteam.daoInterface.ArticleReaderDaoInterface;
import com.cbfteam.beans.ArticleComment;
import com.cbfteam.beans.ArticleReader; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
  
public class ArticleReaderDao implements ArticleReaderDaoInterface {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}

    @Override
    public int saveArticleReader(int article_id, int reader_id){
    String sql="insert into teamproject.article_reader(article_id,reader_id,is_like,question_answer,comment,sub_date) "
            + "values("+article_id+","+reader_id+",NULL,NULL,NULL,NULL)";  
    return template.update(sql);     
}

    @Override  
    public int saveQuestion(int article_id, int reader_id, String question_answer){  
    String sql="insert into teamproject.article_reader(article_id,reader_id,is_like,question_answer,comment,sub_date) "
            + "values("+article_id+","+reader_id+",NULL,'"+question_answer+"',comment = NULL, sub_date= NULL)";  
    return template.update(sql);  
}
    @Override  
    public int saveLike(int article_id, int reader_id, String is_like){  
    String sql="insert into teamproject.article_reader(article_id,reader_id,is_like,question_answer,comment,sub_date) "
            + "values("+article_id+","+reader_id+",'"+is_like+"',NULL,NULL,NULL)";  
    return template.update(sql);  
}
    @Override  
    public int saveComment(int article_id, int reader_id, String comment){  
    String sql="insert into teamproject.article_reader(article_id,reader_id,is_like,question_answer,comment,sub_date) "
            + "values("+article_id+","+reader_id+", NULL ,NULL,'"+comment.replace("'", "\\'")+"',NOW())";  
    return template.update(sql);  
}

    @Override  
    public int updateNullQuestion(int article_id, int reader_id, String question_answer){  
    String sql="update teamproject.article_reader set question_answer= '"+question_answer+"' where article_id="+article_id+" AND reader_id="+reader_id+"";  
    return template.update(sql);  
}

    @Override  
    public int updateNullLike(int article_id, int reader_id, String is_like){  
    String sql="update teamproject.article_reader set is_like= '"+is_like+"' where article_id="+article_id+" AND reader_id="+reader_id+"";  
    return template.update(sql);  
}

    @Override  
    public int updateNullComment(int article_id, int reader_id, String comment){  
    String sql="update teamproject.article_reader set comment= '"+comment.replace("'", "\\'")+"' where article_id="+article_id+" AND reader_id="+reader_id+"";  
    return template.update(sql);  
}

    @Override  
    public int delete(int article_id, int reader_id){  
    String sql="delete from teamproject.article_reader where article_id="+article_id+" AND reader_id = "+reader_id+" AND is_like IS NULL AND question_answer IS NULL and comment IS NULL";  
    return template.update(sql);  
}

    @Override  
    public Integer getArticleLikes(int article_id, String like){  
    String sql="select count(*) from teamproject.article_reader where article_id=? AND is_like LIKE ?";
    try{
    return template.queryForObject(sql, new Object[] {article_id, like}, Integer.class);    
    }catch(EmptyResultDataAccessException e){return null;}  
}

    @Override
    public Integer getArticleAnwsers(int article_id, String answer){  // 'YES', 'NO', 'OTHER'
    String sql="select count(*) from teamproject.article_reader where article_id=? AND question_answer LIKE ?";
    try{
    return template.queryForObject(sql, new Object[] {article_id, answer}, Integer.class);    
    }catch(EmptyResultDataAccessException e){return null;}  
}

    @Override  
    public Integer getArticleReaderByArticleIdReaderId(int article_id, int reader_id){  
    String sql="select count(*) from teamproject.article_reader where article_id=? AND reader_id=?";
    try{
    return template.queryForObject(sql, new Object[] { article_id,reader_id }, Integer.class);    
    }catch(EmptyResultDataAccessException e){return null;}  
}

    @Override  
    public Integer getArticleReaderByIsLikeArticleIdReaderId(int article_id, int reader_id){  
    String sql="select count(*) from teamproject.article_reader where article_id=? AND reader_id=? AND is_like IS NOT NULL";
    try{
    return template.queryForObject(sql, new Object[] { article_id,reader_id }, Integer.class);   
    }catch(EmptyResultDataAccessException e){return null;}
}


    @Override  
    public Integer getHasAnswer(int article_id, int reader_id){  
    String sql="select count(*) from teamproject.article_reader where article_id=? AND reader_id=? AND question_answer IS NOT NULL";
    try{
    return template.queryForObject(sql, new Object[] { article_id,reader_id }, Integer.class);
    }catch(EmptyResultDataAccessException e){return null;}  
}



    @Override  
    public List<ArticleComment> getArticleComments(int article_id){  
    return template.query("select user.username, article_reader.comment, article_reader.sub_date from teamproject.article_reader INNER JOIN teamproject.user "
            + "on article_reader.reader_id = user.id WHERE article_reader.article_id= "+article_id+" and article_reader.comment IS NOT NULL ORDER BY article_reader.sub_date",new RowMapper<ArticleComment>(){  
        
            public ArticleComment mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleComment e= new ArticleComment();  
            e.setUsername(rs.getString(1));
            e.setComment(rs.getString(2));
            e.setSub_date(rs.getString(3));
            return e;  
            }  
        });  
    } 


}  