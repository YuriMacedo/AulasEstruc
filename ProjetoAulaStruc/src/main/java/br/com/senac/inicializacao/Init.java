package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	AlunoService alunoService;
	//@Autowired
	//AlunoRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Yuri");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Daniel");
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());
			
		}
		//repo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
		try {
			Aluno aluno = alunoService.buscarAlunoById(1);
			System.out.println(aluno.getNome());
			
		} catch (Exception e) {
			System.out.println("Aluno não encontrado.");
		}
		
		try {
			alunoService.DeletarAluno(3);
			
		} catch (Exception e) {
			System.out.println("Id não encontrado");
		}
		
		List<Aluno> listaAlunos2 = alunoService.buscarTodosAlunos();
		
		for (Aluno aluno : listaAlunos2) {
			System.out.println(aluno.getNome());
			
		}
		
		Aluno alunoAlterado = new Aluno();
		alunoAlterado.setId(1);
		alunoAlterado.setNome("Bora cumpadi!");
		alunoService.SalvarAlteracao(alunoAlterado);
	}
	
}
