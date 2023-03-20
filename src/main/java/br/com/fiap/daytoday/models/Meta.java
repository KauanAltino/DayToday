package br.com.fiap.daytoday.models;

public class Meta {
    private Long id;
    private int nome_id;
    private int categoria_id;
    private String descricao;
    
    public Meta(int nome_id, int categoria_id, String descricao) {
        this.nome_id = nome_id;
        this.categoria_id = categoria_id;
        this.descricao = descricao;
    }    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNome_id() {
        return nome_id;
    }
    public void setNome_id(int nome_id) {
        this.nome_id = nome_id;
    }
    public int getCategoria_id() {
        return categoria_id;
    }
    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Meta [ Id do nome de usuário= " + nome_id + ", O id da categoria= " + categoria_id + ", Descricao= " + descricao + "]";
    }

}
