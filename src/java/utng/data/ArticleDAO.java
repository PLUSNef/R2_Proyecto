
package utng.data;
import org.hibernate.HibernateException;
import utng.model.Article;

public class ArticleDAO extends DAO<Article>{
    public ArticleDAO(){
        super(new Article());
    }
    public Article getOneById(Article article) 
            throws HibernateException {
        return super.getOneById(
                article.getIdArticle()); //To change body of generated methods, choose Tools | Templates.
    }
}
