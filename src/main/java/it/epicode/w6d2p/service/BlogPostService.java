package it.epicode.w6d2p.service;

import it.epicode.w6d2p.model.Autore;
import it.epicode.w6d2p.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlogPostService {

    private List<BlogPost> posts = new ArrayList<>();
    @Autowired
    private AutoreService autoreService;

    public List<BlogPost> cercaTuttiIBlogPosts(){
        return  posts;
    }

    public BlogPost cercaPostPerId(int id) throws NoSuchElementException{
        return posts.stream().filter(blogPost -> blogPost.getId()==id).findAny().
                orElseThrow(()->new NoSuchElementException("BlogPost non trovato"));
    }

    public BlogPost salvaBlogPost(BlogPost blogPost,Autore autore)throws NoSuchElementException{
        try{ Autore a= autoreService.cercaAutorePerId(autore.getId());
         blogPost.setAutore(a);
        posts.add(blogPost);
        return blogPost;}catch (NoSuchElementException e){
        throw  new NoSuchElementException("Autore non trovato");
        }
    }

    public BlogPost aggiornaBlogPost(int id, BlogPost blogPost,Autore autore) throws NoSuchElementException{
        BlogPost post = cercaPostPerId(id);


        post.setCategoria(blogPost.getCategoria());
        post.setContenuto(blogPost.getContenuto());
        post.setTitolo(blogPost.getTitolo());
        post.setTempoLettura(blogPost.getTempoLettura());

        return post;
    }

    public void cancellaBlogPost(int id) throws NoSuchElementException{
        BlogPost post = cercaPostPerId(id);
        posts.remove(post);
    }
}
