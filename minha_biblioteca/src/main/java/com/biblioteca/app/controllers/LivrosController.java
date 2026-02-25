package com.biblioteca.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblioteca.app.models.Livro;
import com.biblioteca.app.repository.LivrosRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LivrosController {

    @Autowired
    private LivrosRepository csr;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Livro> livros = csr.findAll();
        mv.addObject("livros", livros);
        return mv;
    }

    @RequestMapping(value="/cadastrarLivro", method=RequestMethod.GET)
    public String cadastrarLivro(){
        return "cadastrar_livro";
    }

    @RequestMapping(value="/cadastrarLivro", method=RequestMethod.POST)
    public String cadastrarLivro(Livro livro){
        csr.save(livro);
        return "redirect:/cadastroSucesso";
    }

    @RequestMapping("/cadastroSucesso")
    public String cadastroSucesso(){
        return "cadastro_sucesso";
    }

    @RequestMapping(value="/editarLivro/{id}", method=RequestMethod.GET)
    public ModelAndView editarLivro(@PathVariable("id") long id){
        Livro livro = csr.findById(id);
        ModelAndView mv = new ModelAndView("editar_livro");
        mv.addObject("livro", livro);
        return mv;
    }

    @RequestMapping(value="/editarLivro/{id}", method=RequestMethod.POST)
    public String editarLivro(@Validated Livro livro, BindingResult result, RedirectAttributes attributes){
        csr.save(livro);        
        return "redirect:/alteracaoSucesso";
    }

    @RequestMapping("/alteracaoSucesso")
    public String alteracaoSucesso(){
        return "edicao_sucesso";
    }

    @RequestMapping("/confirmarExclusao/{id}")
    public ModelAndView confirmarExclusao(@PathVariable("id") long id){
        Livro livro = csr.findById(id);
        ModelAndView mv = new ModelAndView("excluir_livro");
        mv.addObject("livro", livro);
        return mv;
    }

    @RequestMapping("/excluirLivro")
    public String excluirLivro(long id){
        Livro livro = csr.findById(id);
        csr.delete(livro);
        return "redirect:/";
    }

    @ModelAttribute
    public void addActivePage(HttpServletRequest request, Model model){
        String uri = request.getRequestURI();
        if (uri.contains("/cadastrarLivro")) model.addAttribute("activePage", "cadastrar");
        else model.addAttribute("activePage", "home");
    }

}
