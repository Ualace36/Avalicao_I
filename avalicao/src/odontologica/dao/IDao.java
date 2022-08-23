package odontologica.dao;

public interface IDao <T>{
    public T salvar(T t);
    public T buscar(int id);
    public void excluir(int id);
    public T modificar(T t);
}
