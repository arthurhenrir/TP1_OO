package tp1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MainTp1 {
	public static void main(String[] args) {
		//Variaveis
		int escolha, qnt, contCliente = 10, contProduto = 10, busca, lucro, estoque;
		double valor;
		char confirma;
		String nome, telefone, endereco, buscaCliente, descricao, buscaProduto;
		
		//Arraylists dos clientes
		ArrayList<String> enderecoClientes =  new ArrayList<String>(); //ArrayList que sera armazenado os enderecos dos clientes
		ArrayList<String> telefoneClientes =  new ArrayList<String>(); //ArrayList que sera armazenado os telefones dos clientes
		ArrayList<String> nomeClientes =  new ArrayList<String>(); //ArrayList que sera armazenado os nomes dos clientes
		
		//Arraylists dos produtos
		ArrayList<String> nomeProduto = new ArrayList<String>(); //ArrayList que armazenará o nome dos produtos
		ArrayList<String> descricaoProduto = new ArrayList<String>(); //ArrayList que armazenará a descrição dos produtos
		ArrayList<Double> valorProduto = new ArrayList<Double>(); //ArrayList que armazenará o valor dos produtos
		ArrayList<Integer> lucroProduto = new ArrayList<Integer>(); //ArrayList que armazenará a porcentagem de lucro dos produtos
		ArrayList<Integer> estoqueProduto = new ArrayList<Integer>(); //ArrayList que armazenará o estoque do produto
		
		Scanner ler = new Scanner(System.in);
		
		povoamentoClientes(nomeClientes, enderecoClientes, telefoneClientes); //Funcao para povoar os 10 dados de clientes
		povoamentoProdutos(nomeProduto, descricaoProduto, valorProduto, lucroProduto, estoqueProduto); //Funcao para povoar os 10 dados de clientes
		do { //Laço de repetição do menu
			chamadoMenu();
			escolha = ler.nextInt();
			switch(escolha) {
				case 1:
					System.out.println("Cadastro de cliente");
					System.out.println("Quantos clientes gostaria de adicionar");
					qnt = ler.nextInt();
					ler.nextLine();
					for(int i = 0; i < qnt; i++) {
						System.out.println("Digite o nome do cliente");
						nome = ler.nextLine();
						nomeClientes.add(nome);
						System.out.println("Digite o telefone do cliente");
						telefone = ler.next();
						ler.nextLine();
						telefoneClientes.add(telefone);
						System.out.println("Digite o endereco do cliente");
						endereco = ler.nextLine();
						enderecoClientes.add(endereco);
						contCliente++; //Variavel para contabilizar a quantidade total de clientes para os fins do case 2
					}
					System.out.println("Cadastro finalizado");
				break;
				case 2:
					busca=0; //Variavel para verificar se o for achou um cliente, caso no ache ela se manterá em zero
					System.out.println("Busca por cliente");
					System.out.println("Digite o nome do cliente desejado");
					ler.nextLine();
					buscaCliente = ler.nextLine();
					for(int i = 0; i < contCliente; i++) {
						if(buscaCliente.equalsIgnoreCase(nomeClientes.get(i))){
							System.out.println("Cliente encontrado"); //Listagem dos dados do cliente
							System.out.println("Nome: " + nomeClientes.get(i));
							System.out.println("Telefone: " + telefoneClientes.get(i));
							System.out.println("Endereço: " + enderecoClientes.get(i));
							busca=1;
							System.out.println("Gostaria de editar? \n S/N");
							confirma = ler.next().charAt(0);							
							if(confirma == 'S' || confirma =='s') { //Verificaçao se deseja realmente editar os dados do cliente
								System.out.println("Digite o novo nome do cliente");
								ler.nextLine();
								nome = ler.nextLine();
								nomeClientes.set(i, nome);
								System.out.println("Digite o novo telefone do cliente");
								telefone = ler.next();
								telefoneClientes.set(i, telefone);
								System.out.println("Digite o novo endereco do cliente");
								ler.nextLine();
								endereco = ler.nextLine();
								enderecoClientes.set(i, endereco);
							} else {
								System.out.println("Voltando ao menu");
								break; 
							}
						}
					}
					if(busca == 0) { //Valor de busca será 0 se durante o for acima nao trocar o valor para 1
						System.out.println("Cliente não encontrado");
					}
				break;
				case 3:
					System.out.println("Cadastro de produto");
					System.out.println("Quantos produtos gostaria de adicionar?");
					qnt = ler.nextInt();
					for(int i = 0; i < qnt; i++) {
						System.out.println("Digite o nome do produto");
						ler.nextLine();
						nome = ler.nextLine();
						nomeProduto.add(nome);
						System.out.println("Digite a descricao do produto");
						descricao = ler.nextLine();
						descricaoProduto.add(descricao);
						System.out.println("Digite o valor do produto");
						valor = ler.nextDouble();
						valorProduto.add(valor);
						System.out.println("Digite a porcentagem de lucro do produto");
						lucro = ler.nextInt();
						lucroProduto.add(lucro);
						System.out.println("Digite a quantidade desse produto em estoque");
						estoque = ler.nextInt();
						while(estoque < 0) { //Validacao para nao inserir estoque negativo
							System.out.println("Quantia invalida de estoque, tente novamente");
							estoque = ler.nextInt();
						}
						estoqueProduto.add(estoque);
						contProduto++; //Variavel para contabilizar quantidadede de produtos inseridos
					}
					System.out.println("Cadastro Finalizado");
				break;
				case 4:
					busca=0;
					System.out.println("Pesquisa de produto");
					System.out.println("Digite o nome do produto que deseja pesquisar");
					ler.nextLine();
					buscaProduto = ler.nextLine();
					for(int i = 0; i < contProduto; i++) {
						if(buscaProduto.equalsIgnoreCase(nomeProduto.get(i))){
							busca=1;
							printaProduto(nomeProduto, descricaoProduto, valorProduto, lucroProduto, estoqueProduto, i);
							confirma = ler.next().charAt(0);
							if(confirma == 'S' || confirma =='s') {
								System.out.println("Digite o novo nome do produto");
								ler.nextLine();
								nome = ler.nextLine();
								nomeProduto.set(i, nome);
								System.out.println("Digite a nova descricao do produto");
								descricao = ler.nextLine();
								descricaoProduto.set(i, descricao);
								System.out.println("Digite o novo valor do produto");
								valor = ler.nextDouble();
								valorProduto.set(i, valor);
								System.out.println("Digite a nova porcentagem de lucro do produto");
								lucro = ler.nextInt();
								lucroProduto.set(i, lucro);
								System.out.println("Digite a nova quantidade desse produto em estoque");
								estoque = ler.nextInt();
								estoqueProduto.set(i, estoque);
							}
						}
					}
					if(busca == 0) {
						System.out.println("Produto não encontrado");
					}
				break;
				case 5:
					System.out.println("Cadastro de vendas");
					cadastroVendas(nomeClientes, nomeProduto, contCliente, estoqueProduto, contProduto); //Metodo para cadastrar novas vendas
				break;
				case 6:
					estoque(contProduto, nomeProduto, estoqueProduto); //Metodo para printar o estoque
				break;
				case 7:
					System.out.println("Encerrando o programa");
				break;
				default:
					System.out.println("Opçao do menu invalida, tente novamente");
			}
		}while(escolha != 7);
	}
	public static void chamadoMenu() {
		System.out.println("\nBem-Vindo ao controlador de clientes e produtos");
		System.out.println("Escolha a opção do menu desejada");
		System.out.println("1 - Cadastrar novo cliente");
		System.out.println("2 - Pesquisar cliente");
		System.out.println("3 - Cadastrar novo produto");
		System.out.println("4 - Pesquisar produto");
		System.out.println("5 - Cadastrar venda");
		System.out.println("6 - Mostrar produtos em estoque");
		System.out.println("7 - Sair");
	}
	public static void estoque(int contProduto, ArrayList<String> nomes, ArrayList<Integer> estoque) {
		System.out.println("Listagem de estoque");
		for(int i = 0; i < contProduto; i++) {
			if(estoque.get(i) == 0) {
				System.out.println(nomes.get(i) + " está sem estoque");
			} else {
				System.out.println(nomes.get(i) + ": " + estoque.get(i) + " Unidades em estoque");
			}			
		}
	}	
	public static void printaProduto(ArrayList<String> nome, ArrayList<String> descricao, ArrayList<Double> valor, ArrayList<Integer> lucro, ArrayList<Integer> estoque, int i) {
		DecimalFormat formatador = new DecimalFormat("0.00");
		System.out.println("Produto encontrado");
		System.out.println("Nome: " + nome.get(i));
		System.out.println("Descrição: " + descricao.get(i));
		System.out.println("Valor: " + formatador.format(valor.get(i)));
		System.out.println("Porcentagem de lucro: " + lucro.get(i));
		System.out.println("Quantia em estoque: " + estoque.get(i));
		System.out.println("Deseja Alterar esses dados? \nS/N");
	}
	public static void cadastroVendas(ArrayList<String> nomeCliente, ArrayList<String> nomeProduto, int contClientes, ArrayList<Integer> estoque, int contProduto) {	
		int escolhaCliente, escolhaProduto, qntVenda;
		char confirma;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o numero do cliente que está realizando a compra");
		for(int i = 0; i < contClientes; i++) {
			System.out.println(i+1 + " - " + nomeCliente.get(i));
		}
		escolhaCliente = ler.nextInt();
		while(escolhaCliente > contClientes) { //Validacao da opçao do cliente escolhido
			System.out.println("Numero invalido, digite novamente");
			escolhaCliente = ler.nextInt();
		}
		do { //Laço de repetiçao da venda do produto, repetirá ate o usuario digitar N
			System.out.println("Digite o numero do produto desejado");
			for(int i = 0; i < contProduto; i++) {
				System.out.println(i+1 + " - " + nomeProduto.get(i));
			}
			escolhaProduto = ler.nextInt();
			while(escolhaProduto > contProduto) {
				System.out.println("Numero invalido, digite novamente");
				escolhaProduto = ler.nextInt();
			}
			System.out.println("Quantas unidades do produto foram vendidas?");
			qntVenda = ler.nextInt();
			while(estoque.get(escolhaProduto - 1) - qntVenda < 0) { //Validação para poder vender só enquanto o estoque estiver maior ou igual à 0
				System.out.println("Venda incompativel, estoque ficara negativado, tente outro valor");
				qntVenda = ler.nextInt();
			}
			estoque.set(escolhaProduto - 1, estoque.get(escolhaProduto - 1) - qntVenda);
			System.out.println("Venda concluida\nGostaria de realizar mais uma?\nS/N");
			confirma = ler.next().charAt(0);
		}while(confirma == 'S' || confirma == 's');
		
	}
	public static void povoamentoClientes(ArrayList<String> nomeCliente, ArrayList<String> enderecoCliente, ArrayList<String> telefoneCliente) {
		Random gerador = new Random(); //Gerador de numeros aleatorios
		for(int i = 0; i<10 ; i++) {
			nomeCliente.add("Joao" + (i+1));
			enderecoCliente.add("Quadra " + gerador.nextInt(50));
			telefoneCliente.add("" + gerador.nextInt(1000));
		}		
	}
	public static void povoamentoProdutos(ArrayList<String> nomeProdutos, ArrayList<String> descricaoProdutos, ArrayList<Double> valorProdutos, ArrayList<Integer> lucroProdutos, ArrayList<Integer> estoqueProdutos) {
		Random gerador = new Random(); //Gerador de numeros aleatorios
		for(int i = 0; i<10 ; i++) {
			nomeProdutos.add("Pipoca" + i);
			descricaoProdutos.add("Texto" + i);
			valorProdutos.add(gerador.nextDouble() * 100);
			lucroProdutos.add(gerador.nextInt(100));
			estoqueProdutos.add(gerador.nextInt(100));
		}
	}
}
