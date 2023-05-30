package repository;

import java.util.List;

public interface Persistent <T>{
    public void save(T entity);
    public void insert(T entity);
    public void delete(int id);
    public List<T> findAll();
    public void update(T entity);
}
