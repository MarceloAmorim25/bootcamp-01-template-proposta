package br.com.proposta.services;

import br.com.proposta.dtos.requests.NovoCartaoRequest;
import br.com.proposta.models.Proposta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Service
public class GerarCartaoService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IntegracaoCartaoService integracaoCartaoService;

    private final Logger logger = LoggerFactory.getLogger(Proposta.class);


    @Transactional
    public void geraCartaoSegundoPlano(Proposta proposta){

        if(proposta.getIdCartao() == null){

            boolean cartaoCriadoNaApiDeContas =
                    integracaoCartaoService.criarCartao(new NovoCartaoRequest(proposta)).getStatusCode() == HttpStatus.CREATED;

            if(cartaoCriadoNaApiDeContas){

                proposta.associaCartao(String.valueOf(proposta.getId()));

                entityManager.merge(proposta);

                logger.info("Cartão criado em segundo plano e associado com a proposta do cliente={}", proposta.getNome());

            }
        }
    }
}
