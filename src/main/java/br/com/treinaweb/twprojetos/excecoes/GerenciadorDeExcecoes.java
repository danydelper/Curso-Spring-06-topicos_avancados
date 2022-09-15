package br.com.treinaweb.twprojetos.excecoes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GerenciadorDeExcecoes implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
       ModelAndView modelAndView = new ModelAndView("problema");

       modelAndView.addObject("status", status.value());
       switch (status.value()) {
            case 404:
                modelAndView.addObject("titulo", "Página não encontrada.");
                modelAndView.addObject("mensagem", "A página que você procura não existe!");
                modelAndView.addObject("causa", "A Url para página '" + model.get("path") + "' não existe.");
                modelAndView.addObject("cssClass", "text-warning");
                break;
            case 500:
                modelAndView.addObject("titulo", "Erro Interno no Servidor.");
                modelAndView.addObject("mensagem", "Alguma coisa deu errado!");
                modelAndView.addObject("causa", "Ocorreu um erro inesperado, tente mais tarde.");
                modelAndView.addObject("cssClass", "text-danger");
                break;
            default:
                modelAndView.addObject("titulo", "Erro não Identificado.");
                modelAndView.addObject("mensagem", "Comunique ao supervisor!");
                modelAndView.addObject("causa", "Ocorreu um erro inesperado, com código '" + status.value() + "' .");
                modelAndView.addObject("cssClass", "text-danger");
                break;
        // TODO -> COLOCAR PARA GRAVAR UM ARQUIVO COM ERRO

       }

       return modelAndView;
    }
    
}
