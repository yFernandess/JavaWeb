import br.com.JavaWeb.DAO.CidadeDAO;
import br.com.JavaWeb.DAO.EstadoDAO;
import br.com.JavaWeb.domain.Cidade;
import br.com.JavaWeb.domain.Estado;
import java.util.ArrayList;

public class CidadeDAOTest {

	public void buscar() {
		Long codigo = 3L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		System.out.println("C?digo da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("C?digo do estado da cidade: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do estado da cidade: " + cidade.getEstado().getNome());
	}
	
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		ArrayList<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado) {
			System.out.println("C?digo da cidade: " + cidade.getCodigo());
			System.out.println("Nome da cidade: " + cidade.getNome());
			System.out.println("C?digo do estado da cidade: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do estado da cidade: " + cidade.getEstado().getNome());
		}
	}
	
	public void salvar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		Cidade cidade = new Cidade();
		
		cidade.setNome("Mar?lia");
		cidade.setEstado(estado);
		
		cidadeDAO.salvar(cidade);
	}
	
	public void editar() {
		Long codigoCidade = 3L;
		Long codigoEstado = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Cidade a ser editada: ");
		System.out.println("C?digo da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("C?digo do estado da cidade: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do estado da cidade: " + cidade.getEstado().getNome());
		
		cidade.setNome("Florian?polis");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade editada: ");
		System.out.println("C?digo da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("C?digo do estado da cidade: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do estado da cidade: " + cidade.getEstado().getNome());
	}
	
	public void excluir() {
		Long codigo = 3L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		System.out.println("Cidade removida com sucesso!");
		System.out.println("C?digo da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("C?digo do estado da cidade: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do estado da cidade: " + cidade.getEstado().getNome());
	}
}
