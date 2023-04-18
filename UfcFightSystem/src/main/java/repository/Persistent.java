package repository;

import java.util.List;

public interface Persistent <T>{
    public void save(T entity);
    public void insert(T entity);
    public void delete(T entity);
    public List<T> findAll();
    public T findById(T entity);
    public void update(T entity);
}
