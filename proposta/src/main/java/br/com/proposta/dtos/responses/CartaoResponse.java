package br.com.proposta.dtos.responses;

public class CartaoResponse {

    private String id;

    public CartaoResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}