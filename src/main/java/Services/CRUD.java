package Services;

import java.util.List;

public interface CRUD <T>{
    void insert(T obj) throws Exception;
    void delete (T obj) throws Exception;
    void update (T obj) throws Exception;
    public List<T> find() throws Exception;



}
