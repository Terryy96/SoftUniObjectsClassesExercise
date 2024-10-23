import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Article {

    private String title;
    private String content;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article (String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void edit (String newContent){
        Article.this.content = newContent;
    }

    public void changeAuthor (String newAuthor){
        Article.this.author = newAuthor;
    }

    public void rename (String newTitle){
        Article.this.title = newTitle;
    }
    public String articleInfo (){
        return String.format("%s - %s: %s", title, content, author);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputArticle = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        String title = inputArticle.get(0);
        String content = inputArticle.get(1);
        String author = inputArticle.get(2);
        Article article = new Article(title, content, author);

        for (int i = 0; i <n ; i++) {
            String command = scanner.nextLine();
            String [] tokens =command.split(" ");


            if (tokens[0].equals("Edit:")){
                String newContent = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                article.edit(newContent);
            }else if (tokens[0].equals("ChangeAuthor:")){
                String newAuthor = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                article.changeAuthor(newAuthor);
            }else if (tokens[0].equals("Rename:")){
                String newName = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                article.rename(newName);
            }
        }

        System.out.println(article.articleInfo());
    }
}
