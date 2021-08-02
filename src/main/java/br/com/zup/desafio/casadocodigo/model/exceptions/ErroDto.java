package br.com.zup.desafio.casadocodigo.model.exceptions;

public class ErroDto {

    private String campo;
    private String erro;

    public ErroDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public ErroDto(String erro) {
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
