package br.com.proposta.dtos.requests;


import br.com.proposta.models.Proposta;

public class NovoCartaoRequest {

    private String documento;

    private String nome;

    private String idProposta;

    public NovoCartaoRequest(Proposta proposta) {
        this.documento = proposta.getIdentificacao();
        this.nome = proposta.getNome();
        this.idProposta = String.valueOf(proposta.getId());
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }
}
