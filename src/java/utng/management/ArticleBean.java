
package utng.management;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.ArticleDAO;
import utng.model.Article;
import utng.data.OrderDAO;
import utng.model.Order;

@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable{
    private List<Article>articles;
    private Article article;
    private Article name;
    private Article quantity;
    private List<Order>orders;

    public ArticleBean() {
        article = new Article();
        article.setOrder(new Order());
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article getName() {
        return name;
    }

    public void setName(Article name) {
        this.name = name;
    }

    public Article getQuantity() {
        return quantity;
    }

    public void setQuantity(Article quantity) {
        this.quantity = quantity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public String list() {
        ArticleDAO dao = new ArticleDAO();
        try {
            articles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Articles";
    }
    public String delete() {
        ArticleDAO dao = new ArticleDAO();
        try {
            dao.delete(article);
            articles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        article = new Article();
        article.setOrder(new Order());
        try {
            orders = new OrderDAO().getAll();
        } catch (Exception e) {
        }
        return "start";
    }
    
    public String save() {
        ArticleDAO dao = new ArticleDAO();
        try {
            if (article.getIdArticle() != 0) {
                dao.update(article);
            } else {
                dao.insert(article);
            }
            articles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Article article) {
        this.article = article;
        try {
            orders = new OrderDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
}
