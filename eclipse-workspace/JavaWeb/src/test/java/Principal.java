
public class Principal {

	public static void main(String[] args) {
		EstadoDAOTest estadoTest = new EstadoDAOTest();
		CidadeDAOTest cidadeTest = new CidadeDAOTest();
		
		//Testar um m?todo por vez
		estadoTest.buscar();
		estadoTest.excluir();
		estadoTest.salvar();
		estadoTest.listar();
		estadoTest.editar();
		
		cidadeTest.salvar();
		cidadeTest.buscar();
		cidadeTest.editar();
		cidadeTest.listar();
		cidadeTest.excluir();
	}

}
